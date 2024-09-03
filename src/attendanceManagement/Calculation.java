package attendanceManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

public class Calculation {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
    private static final LocalTime LATE_THRESHOLD = LocalTime.of(9, 30);
    
    private String userID;  // Add userID as a class variable
 
    public Calculation(String userID) {
        this.userID = userID;
    }

    public int calculateDaysWorked() {
        return filterAttendanceData().size();
    }

    public int calculateDaysLate() {
        int lateCount = 0;
        Map<String, String[]> data = filterAttendanceData();
        for (String[] entry : data.values()) {
            String clockInTime = entry[2];
            if (clockInTime != null && !clockInTime.isEmpty()) {
                try {
                    LocalTime clockIn = LocalTime.parse(clockInTime, TIME_FORMAT);
                    if (clockIn.isAfter(LATE_THRESHOLD)) {
                        lateCount++;
                    }
                } catch (DateTimeParseException e) {
                    // Handle invalid time format
                    System.err.println("Invalid time format: " + clockInTime);
                }
            }
        }
        return lateCount;
    }

    public int calculateDaysOnTime() {
        return calculateDaysWorked() - calculateDaysLate();
    }

    private LocalTime parseTime(String time) {
        if (time != null && !time.isEmpty()) {
            try {
                return LocalTime.parse(time, TIME_FORMAT);
            } catch (DateTimeParseException e) {
                System.err.println("Invalid time format: " + time);
            }
        }
        return LocalTime.of(0, 0);
    }

    private LocalTime addTimes(LocalTime time1, LocalTime time2) {
        int totalMinutes = time1.getHour() * 60 + time1.getMinute() + time2.getHour() * 60 + time2.getMinute();
        return LocalTime.of(totalMinutes / 60, totalMinutes % 60);
    }

    public String calculateTotalOvertime() {
        LocalTime totalOvertime = LocalTime.of(0, 0);
        Map<String, String[]> data = filterAttendanceData();
        for (String[] entry : data.values()) {
            String overtime = entry[5]; // Assume overtime is stored as HH:mm
            totalOvertime = addTimes(totalOvertime, parseTime(overtime));
        }
        return totalOvertime.format(TIME_FORMAT);
    }

    public String calculateTotalUndertime() {
        LocalTime totalUndertime = LocalTime.of(0, 0);
        Map<String, String[]> data = filterAttendanceData();
        for (String[] entry : data.values()) {
            String undertime = entry[6]; // Assume undertime is stored as HH:mm
            totalUndertime = addTimes(totalUndertime, parseTime(undertime));
        }
        return totalUndertime.format(TIME_FORMAT);
    }

    public String calculateAverageClockIn() {
        Map<String, String[]> data = filterAttendanceData();
        int count = 0;
        LocalTime sum = LocalTime.of(0, 0);

        for (String[] entry : data.values()) {
            String clockInTime = entry[2];
            if (clockInTime != null && !clockInTime.isEmpty()) {
                try {
                    LocalTime clockIn = LocalTime.parse(clockInTime, TIME_FORMAT);
                    sum = sum.plusHours(clockIn.getHour()).plusMinutes(clockIn.getMinute());
                    count++;
                } catch (DateTimeParseException e) {
                    // Handle invalid time format
                    System.err.println("Invalid time format for clock-in time: " + clockInTime);
                }
            }
        }

        if (count == 0) return "N/A";

        long averageMinutes = sum.toSecondOfDay() / 60 / count;
        LocalTime averageTime = LocalTime.of((int) (averageMinutes / 60), (int) (averageMinutes % 60));
        return averageTime.format(TIME_FORMAT);
    }

    private Map<String, String[]> filterAttendanceData() {
    Map<String, String[]> data = new HashMap<>();
    LocalDate today = LocalDate.now();
    int currentMonth = today.getMonthValue();
    int currentYear = today.getYear();

    try (BufferedReader br = new BufferedReader(new FileReader("attendance.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 8) {
                String entryUserID = parts[1];
                LocalDate entryDate = LocalDate.parse(parts[7]);

                // Check if the entry belongs to the specified user and is from the current month
                if (userID.equals(entryUserID) && entryDate.getMonthValue() == currentMonth && entryDate.getYear() == currentYear) {
                    data.put(parts[0], parts); // Use AttendanceId as the key for unique entries
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return data;
}

}


