/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adminManagement.GetPanel;

/**
 *
 * @author leopa
 */
// DataRowCounter.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
        

public class DataRowCounter {
private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd"); 
    public static int countRowsInFile(String filename) {
        int rows = 0;
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                rows++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            rows=0;
        }
        return rows;
    }
    public static int countEmployees(String filename) {
    int rows = 0;
    try {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        // Skip the header row
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            rows++;
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + filename);
        rows=0;
    }
    return rows;
}
    
    
    public static int countLeaveonDay (){     
     int rowCount = 0;
        
        String today = DATE_FORMAT.format(new Date());
        
        try (BufferedReader reader = new BufferedReader(new FileReader("leave.txt"))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                

                if (isFirstLine) {
                    isFirstLine = false; // Skip the first line if it is a header
                    continue;
                }
                String[] columns = line.split(",");
                if (columns.length > 5) {
                    String startDateStr = columns[4].trim();
                    String endDateStr = columns[5].trim();
                    
                    // Check if today is within the start and end dates
                    if (!startDateStr.equals("Start Date") && !endDateStr.equals("End Date")) {
                        if (isDateInRange(today, startDateStr, endDateStr)) {
                            rowCount++;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle file reading errors
        }
        
        return rowCount;
    }
    private static boolean isDateInRange(String date, String startDate, String endDate) {
        try {
            Date dateToCheck = DATE_FORMAT.parse(date);
            Date start = DATE_FORMAT.parse(startDate);
            Date end = DATE_FORMAT.parse(endDate);
            return !dateToCheck.before(start) && !dateToCheck.after(end);
        } catch (ParseException e) {
            System.err.println("Date parsing error: " + e.getMessage());
            return false; // Return false if there's a parsing error
        }
    }
    
    public static void main(String[] args) {
        int count = countLeaveonDay ();
        System.out.println("Number of people on leave today: " + count);
    }
}
