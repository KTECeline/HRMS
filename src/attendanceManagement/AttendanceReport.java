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
    private Calculation calculation;  // Add a Calculation instance

    // Constructor to initialize Calculation instance
    public AttendanceReport(String userID) {
        this.calculation = new Calculation(userID);  // Initialize with userID
    }

    // Method to generate a monthly report for a specific user and write to a file
    public void generateMonthlyReport(String filePath, int month, int year, String sessionUserId, String outputFileName) {
        List<String> allRecords = new ArrayList<>(); // List to hold all records for the month

        // Initialize attendance calculations for the user
        calculation = new Calculation(sessionUserId);
        int daysWorked = calculation.calculateDaysWorked(true);
        int daysLate = calculation.calculateDaysLate(true);
        int daysOnTime = calculation.calculateDaysOnTime(true);
        // You can add other calculations if they exist in the Calculation class

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 8) {
                    String userId = fields[1];
                    String date = fields[7]; // Date is in the last column
                    String clockInTime = fields[2]; // Clock-in time is in the third column
                    String totalTime = fields[4]; // Total time worked is in the fourth column
                    String overtime = fields[5]; // Overtime is in the fifth column
                    String undertime = fields[6]; // Undertime is in the sixth column

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
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the report to a file
        writeReportToFile(sessionUserId, daysWorked, daysLate, daysOnTime, allRecords, outputFileName);
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

    // Write the report to a text file
    private void writeReportToFile(String sessionUserId, int daysWorked, int daysLate, int daysOnTime, List<String> allRecords, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write("=====================================\n");
            writer.write("       Monthly Attendance Report      \n");
            writer.write("=====================================\n");
            writer.write("User ID: " + sessionUserId + "\n\n");
            
            writer.write("Total Days Worked: " + daysWorked + "\n");
            writer.write("Days Late: " + daysLate + "\n");
            writer.write("Days On-Time: " + daysOnTime + "\n");

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
