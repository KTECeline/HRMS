
package attendanceManagement;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import javax.swing.JOptionPane;
import auth.Session;
        

public class AttendanceReport {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Date format for parsing date fields
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm"); // Time format for parsing time fields

    // Method to generate a monthly report for a specific user and write to a file
    public void generateMonthlyReport(String filePath, int month, int year, String sessionUserId, String outputFileName) {
        Map<String, Integer> lateDays = new HashMap<>();
        Map<String, Integer> onTimeDays = new HashMap<>();
        Map<String, Integer> totalDays = new HashMap<>();
        Map<String, Long> totalHoursWorked = new HashMap<>();
        Map<String, Long> totalOvertime = new HashMap<>();
        Map<String, Long> totalUndertime = new HashMap<>();
        Map<String, List<Date>> clockInTimes = new HashMap<>();
        List<String> allRecords = new ArrayList<>(); // List to hold all records for the month

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 8) {
                    String userId = fields[1];
                    String date = fields[7]; // Date is in the last column
                    String clockInTime = fields[2]; // Clock-in time is in the third column
                    String totalTime = fields[3]; // Total time worked is in the fourth column
                    String overtime = fields[4]; // Overtime is in the fifth column
                    String undertime = fields[5]; // Undertime is in the sixth column

                    // Only process data for the specific user ID
                    if (!userId.equals(sessionUserId)) {
                        continue;
                    }

                    // Check if the date is within the specified month and year
                    if (isInMonth(date, month, year)) {
                        // Track the record for the month
                        String record = String.format("Date: %s, Clock-In: %s, Total Time: %s, Overtime: %s, Undertime: %s",
                                date, clockInTime, totalTime, overtime, undertime);
                        allRecords.add(record);

                        // Parse the clock-in time
                        if (clockInTime != null && !clockInTime.equals("null")) {
                            try {
                                Date clockIn = timeFormat.parse(clockInTime);
                                Date cutoffTime = timeFormat.parse("09:30"); // 9:30 AM cutoff time
                                
                                // Track clock-in times for averaging later
                                clockInTimes.computeIfAbsent(userId, k -> new ArrayList<>()).add(clockIn);

                                // Increment late or on-time days
                                if (clockIn.after(cutoffTime)) {
                                    lateDays.put(userId, lateDays.getOrDefault(userId, 0) + 1);
                                } else {
                                    onTimeDays.put(userId, onTimeDays.getOrDefault(userId, 0) + 1);
                                }

                                // Increment total days for the user
                                totalDays.put(userId, totalDays.getOrDefault(userId, 0) + 1);

                            } catch (ParseException e) {
                                System.err.println("ParseException for time: " + clockInTime);
                                e.printStackTrace();
                            }
                        }

                        // Calculate total hours worked
                        if (totalTime != null && !totalTime.equals("null")) {
                            try {
                                long hoursWorked = parseTimeToMinutes(totalTime);
                                totalHoursWorked.put(userId, totalHoursWorked.getOrDefault(userId, 0L) + hoursWorked);
                            } catch (ParseException e) {
                                System.err.println("ParseException for total time: " + totalTime);
                                e.printStackTrace();
                            }
                        }

                        // Calculate total overtime
                        if (overtime != null && !overtime.equals("null")) {
                            try {
                                long overtimeMinutes = parseTimeToMinutes(overtime);
                                totalOvertime.put(userId, totalOvertime.getOrDefault(userId, 0L) + overtimeMinutes);
                            } catch (ParseException e) {
                                System.err.println("ParseException for overtime: " + overtime);
                                e.printStackTrace();
                            }
                        }

                        // Calculate total undertime
                        if (undertime != null && !undertime.equals("null")) {
                            try {
                                long undertimeMinutes = parseTimeToMinutes(undertime);
                                totalUndertime.put(userId, totalUndertime.getOrDefault(userId, 0L) + undertimeMinutes);
                            } catch (ParseException e) {
                                System.err.println("ParseException for undertime: " + undertime);
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the report to a file
        writeReportToFile(sessionUserId, lateDays, onTimeDays, totalDays, totalHoursWorked, totalOvertime, totalUndertime, clockInTimes, allRecords, outputFileName);
    }

    // Check if the date is in the specified month and year
    private boolean isInMonth(String date, int month, int year) {
        try {
            Date d = dateFormat.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            return cal.get(Calendar.MONTH) + 1 == month && cal.get(Calendar.YEAR) == year;
        } catch (ParseException e) {
            System.err.println("ParseException for date: " + date);
            e.printStackTrace();
            return false;
        }
    }

    // Parse time in HH:mm format to total minutes
    private long parseTimeToMinutes(String time) throws ParseException {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    // Write the report to a text file
    private void writeReportToFile(String sessionUserId, Map<String, Integer> lateDays, Map<String, Integer> onTimeDays, Map<String, Integer> totalDays, Map<String, Long> totalHoursWorked, Map<String, Long> totalOvertime, Map<String, Long> totalUndertime, Map<String, List<Date>> clockInTimes, List<String> allRecords, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write("=====================================\n");
            writer.write("       Monthly Attendance Report      \n");
            writer.write("=====================================\n");
            writer.write("User ID: " + sessionUserId + "\n\n");
            
            int total = totalDays.getOrDefault(sessionUserId, 0);
            int late = lateDays.getOrDefault(sessionUserId, 0);
            int onTime = onTimeDays.getOrDefault(sessionUserId, 0);
            long hoursWorked = totalHoursWorked.getOrDefault(sessionUserId, 0L);
            long overtime = totalOvertime.getOrDefault(sessionUserId, 0L);
            long undertime = totalUndertime.getOrDefault(sessionUserId, 0L);
            List<Date> userClockInTimes = clockInTimes.getOrDefault(sessionUserId, new ArrayList<>());

            // Calculate average clock-in time
            Date averageClockInTime = calculateAverageClockInTime(userClockInTimes);

            // Convert total minutes to hours and minutes for readability
            String totalHoursFormatted = formatMinutesToHHMM(hoursWorked);
            String overtimeFormatted = formatMinutesToHHMM(overtime);
            String undertimeFormatted = formatMinutesToHHMM(undertime);

            writer.write("Total Days Worked: " + total + "\n");
            writer.write("Days Late: " + late + "\n");
            writer.write("Days On-Time: " + onTime + "\n");
            writer.write("Total Hours Worked: " + totalHoursFormatted + "\n");
            writer.write("Total Overtime: " + overtimeFormatted + "\n");
            writer.write("Total Undertime: " + undertimeFormatted + "\n");
            writer.write("Average Clock-In Time: " + (averageClockInTime != null ? timeFormat.format(averageClockInTime) : "N/A") + "\n");

            // Write all records for the month
            writer.write("\n--- Detailed Records for the Month ---\n");
            for (String record : allRecords) {
                writer.write(record + "\n");
            }

            writer.write("=====================================\n");
            writer.write("End of Report\n");

            System.out.println("Report has been written to " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Calculate average clock-in time from a list of dates
    private Date calculateAverageClockInTime(List<Date> clockInTimes) {
        if (clockInTimes.isEmpty()) return null;

        long totalMilliseconds = 0;
        for (Date date : clockInTimes) {
            totalMilliseconds += date.getTime();
        }
        long averageMilliseconds = totalMilliseconds / clockInTimes.size();

        return new Date(averageMilliseconds);
    }

    // Convert total minutes to HH:mm format
    private String formatMinutesToHHMM(long minutes) {
        long hours = minutes / 60;
        long remainingMinutes = minutes % 60;
        return String.format("%02d:%02d", hours, remainingMinutes);
    }
    public void getMonthlyReport() {
    // Get the current date
    LocalDate now = LocalDate.now();
    int month = now.getMonthValue();
    int year = now.getYear();
    String sessionUserId;
    if (Session.isLoggedIn()) {
        sessionUserId = Session.getUserId();
        System.out.println("User ID from Session: " + sessionUserId);
    } else {
        System.out.println("User is not logged in.");
        return; // or throw an exception, depending on your requirements
    }
    // Format the file name based on current month, year, and user ID
    String filePath = "attendance.txt";
    String outputFileName = String.format("%d_%d_%s.txt", month, year, sessionUserId);
    
    // Generate the monthly report
    generateMonthlyReport(filePath, month, year, sessionUserId, outputFileName);
    
     JOptionPane.showMessageDialog(null, "Monthly report successfully generated. Please check the file: " + outputFileName);
}

}

