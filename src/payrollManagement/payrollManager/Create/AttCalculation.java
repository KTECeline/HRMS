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

    public int calculateMonthlyUndertime(String filePath, String monthYear, String selectedEmpID) throws IOException {
       int totalLateDays = 0;

       try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
           String line;
           reader.readLine(); 
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
                           if (!undertime.equals(LocalTime.MIDNIGHT)) {
                               totalLateDays++;
                           }
                       }
                   } catch (DateTimeParseException e) {
                       System.err.println("Date or time format error in line: " + line + " - " + e.getMessage());
                   }
               }
           }
       }
       return totalLateDays;
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
}