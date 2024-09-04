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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
        

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
    
    
    public static int countLeaveonDay (String filename){     
   int countLeaveOnDay = 0;
LocalDate currentDate = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // adjust the format to match your date format

try (BufferedReader br = new BufferedReader(new FileReader("leave.txt"))) {
    String line;
    boolean skipHeader = true;
    while ((line = br.readLine()) != null) {
        if (skipHeader) {
            skipHeader = false; // skip the first line (header)
            continue;
        }
        String[] columns = line.split(",");
        LocalDate startDate = LocalDate.parse(columns[3], formatter);
        LocalDate endDate = LocalDate.parse(columns[4], formatter);
        if (currentDate.isAfter(startDate) && currentDate.isBefore(endDate) || currentDate.isEqual(startDate) || currentDate.isEqual(endDate)) {
            countLeaveOnDay++;
        }
    }
} catch (FileNotFoundException e) {
    // file not found, set countLeaveOnDay to 0
    countLeaveOnDay = 0;
} catch (IOException e) {
    e.printStackTrace();
}return  countLeaveOnDay;
    }
}
