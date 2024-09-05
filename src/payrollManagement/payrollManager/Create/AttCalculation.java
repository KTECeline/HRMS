package payrollManagement.payrollManager.Create;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import auth.Session;
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
    private final String empID = Session.getUserId();  

    public String calculateMonthlyOvertime() throws IOException {
        String monthYear = readMonthYearFromFile(filePath);
        double totalOvertime = calculateMonthlyOvertime(filePath, monthYear);
        LocalTime overtimeTime = LocalTime.of((int) totalOvertime, (int) ((totalOvertime % 1) * 60));
        return overtimeTime.format(TIME_FORMAT);
    }

    public String calculateMonthlyUndertime() throws IOException {
        String monthYear = readMonthYearFromFile(filePath);
        double totalUndertime = calculateMonthlyUndertime(filePath, monthYear);
        LocalTime undertimeTime = LocalTime.of((int) totalUndertime, (int) ((totalUndertime % 1) * 60));
        return undertimeTime.format(TIME_FORMAT);
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

    private double calculateMonthlyOvertime(String filePath, String monthYear) throws IOException {
        double totalOvertime = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); 

            String line;
            while ((line = reader.readLine()) != null) {
                String[] entry = line.split(",");
                if (entry.length < 8) continue;

                String currentUserId = entry[1].trim();
                String dateStr = entry[7].trim();
                String overtimeStr = entry[5].trim();

                if (currentUserId.equals(empID)) {
                    try {
                        LocalDate date = LocalDate.parse(dateStr, DATE_FORMAT);
                        String monthYearStr = date.getYear() + "-" + String.format("%02d", date.getMonthValue());

                        if (monthYearStr.equals(monthYear)) {
                            LocalTime overtime = LocalTime.parse(overtimeStr, TIME_FORMAT);
                            totalOvertime += overtime.getHour() + overtime.getMinute() / 60.0;
                        }
                    } catch (DateTimeParseException e) {
                        System.err.println("Date or time format error in line: " + line + " - " + e.getMessage());
                    }
                }
            }
        }
        return totalOvertime;
    }

    private double calculateMonthlyUndertime(String filePath, String monthYear) throws IOException {
        double totalUndertime = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); 

            String line;
            while ((line = reader.readLine()) != null) {
                String[] entry = line.split(",");
                if (entry.length < 8) continue;

                String currentUserId = entry[1].trim();
                String dateStr = entry[7].trim();
                String undertimeStr = entry[6].trim();

                if (currentUserId.equals(empID)) {
                    try {
                        LocalDate date = LocalDate.parse(dateStr, DATE_FORMAT);
                        String monthYearStr = date.getYear() + "-" + String.format("%02d", date.getMonthValue());

                        if (monthYearStr.equals(monthYear)) {
                            LocalTime undertime = LocalTime.parse(undertimeStr, TIME_FORMAT);
                            totalUndertime += undertime.getHour() + undertime.getMinute() / 60.0;
                        }
                    } catch (DateTimeParseException e) {
                        System.err.println("Date or time format error in line: " + line + " - " + e.getMessage());
                    }
                }
            }
        }
        return totalUndertime;
    }

    double calculateInternSalary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    double calculatePartTimeSalary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}