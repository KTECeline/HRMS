package payrollManagement.payrollManager.Create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Hui Nan
 */

public class AttCalculation {

    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String filePath = "attendance.txt";

    public String calculateMonthlyOvertime(String lEmpID) throws IOException {
        String monthYear = readMonthYearFromFile(filePath);
        double totalOvertime = calculateMonthlyOvertime(filePath, monthYear, lEmpID); 
        LocalTime overtimeTime = LocalTime.of((int) totalOvertime, (int) ((totalOvertime % 1) * 60));
        return overtimeTime.format(TIME_FORMAT);
    }

    public String calculateMonthlyUndertime(String lEmpID) throws IOException {
        String monthYear = readMonthYearFromFile(filePath);
        double totalUndertime = calculateMonthlyUndertime(filePath, monthYear, lEmpID); 
        LocalTime undertimeTime = LocalTime.of((int) totalUndertime, (int) ((totalUndertime % 1) * 60));
        return undertimeTime.format(TIME_FORMAT);
    }

    private double calculateMonthlyOvertime(String filePath, String monthYear, String selectedEmpID) throws IOException {
        double totalOvertime = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] entry = line.split(",");
                if (entry.length < 8) continue;

                String currentUserId = entry[1].trim();
                String dateStr = entry[7].trim();
                String overtimeStr = entry[5].trim();

                if (currentUserId.equals(selectedEmpID)) {
                    try {
                        LocalDate date = LocalDate.parse(dateStr, DATE_FORMAT);
                        String monthYearStr = date.getYear() + "-" + String.format("%02d", date.getMonthValue());

                        if (monthYearStr.equals(monthYear)) {
                            LocalTime overtime = LocalTime.parse(overtimeStr, TIME_FORMAT);
                            double overtimeHours = overtime.getHour() + overtime.getMinute() / 60.0;
                            totalOvertime += overtimeHours;
                        }
                    } catch (DateTimeParseException e) {
                        System.err.println("Date or time format error in line: " + line + " - " + e.getMessage());
                    }
                }
            }
        }
        return totalOvertime;
    }

    private double calculateMonthlyUndertime(String filePath, String monthYear, String selectedEmpID) throws IOException {
        double totalUndertime = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] entry = line.split(",");
                if (entry.length < 8) continue;

                String currentUserId = entry[1].trim();
                String dateStr = entry[7].trim();
                String undertimeStr = entry[6].trim();

                if (currentUserId.equals(selectedEmpID)) {
                    try {
                        LocalDate date = LocalDate.parse(dateStr, DATE_FORMAT);
                        String monthYearStr = date.getYear() + "-" + String.format("%02d", date.getMonthValue());

                        if (monthYearStr.equals(monthYear)) {
                            LocalTime undertime = LocalTime.parse(undertimeStr, TIME_FORMAT);
                            double undertimeHours = undertime.getHour() + undertime.getMinute() / 60.0;
                            totalUndertime += undertimeHours;
                        }
                    } catch (DateTimeParseException e) {
                        System.err.println("Date or time format error in line: " + line + " - " + e.getMessage());
                    }
                }
            }
        }
        return totalUndertime;
    }

    private String readMonthYearFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                if (parts.length > 7) {
                    try {
                        LocalDate date = LocalDate.parse(parts[7], DATE_FORMAT);
                        return date.getYear() + "-" + String.format("%02d", date.getMonthValue());
                    } catch (DateTimeParseException e) {
                        throw new IOException("Date format error in file: " + e.getMessage(), e);
                    }
                }
            }
        }
        throw new IOException("Failed to read month and year from file.");
    }

    public double calculateInternSalary(String lEmpID) throws IOException {
        String monthYear = readMonthYearFromFile(filePath);
        int totalDays = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] entry = line.split(",");
                if (entry.length < 8) continue;
                String currentUserId = entry[1].trim();
                String dateStr = entry[7].trim();

                if (currentUserId.equals(lEmpID)) {
                    LocalDate date = LocalDate.parse(dateStr, DATE_FORMAT);
                    String monthYearStr = date.getYear() + "-" + String.format("%02d", date.getMonthValue());

                    if (monthYearStr.equals(monthYear)) {
                        totalDays++;
                    }
                }
            }
        }
        return totalDays;
    }

    public double calculatePartTimeSalary(String lEmpID, String monthYear) throws IOException {
        int totalMinutes = 0;  

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] entry = line.split(",");
                if (entry.length < 8) continue; 

                String currentUserId = entry[1].trim();  
                String dateStr = entry[7].trim();       
                String hoursStr = entry[4].trim();  

                if (currentUserId.equals(lEmpID)) {  
                    LocalDate date = LocalDate.parse(dateStr, DATE_FORMAT);  
                    String monthYearStr = date.getYear() + "-" + String.format("%02d", date.getMonthValue());

                    if (monthYearStr.equals(monthYear)) { 
                        String[] timeParts = hoursStr.split(":");
                        int hours = Integer.parseInt(timeParts[0]); 
                        int minutes = Integer.parseInt(timeParts[1]);  

                        totalMinutes += (hours * 60) + minutes;
                    }
                }
            }
        }

        double totalHours = totalMinutes / 60.0;
        return totalHours;  
    }
}