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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
        

public class DataRowCounter {

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(new Date());
        
        try (BufferedReader reader = new BufferedReader(new FileReader("leave.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming each line is a CSV and date is in the 5th column (start date)
                String[] columns = line.split(",");
                if (columns.length > 5) {
                    String startDate = columns[4];
                    String endDate = columns[5];
                    
                    // Check if today is within the start and end dates
                    if (isDateInRange(today, startDate, endDate)) {
                        rowCount++;
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
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateToCheck = dateFormat.parse(date);
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);
            return !dateToCheck.before(start) && !dateToCheck.after(end);
        } catch (Exception e) {
            e.printStackTrace(); // Handle date parsing errors
            return false;
        }
    }
    
    public static void main(String[] args) {
        int count = countLeaveonDay();
        System.out.println("Number of people on leave today: " + count);
    }
}
