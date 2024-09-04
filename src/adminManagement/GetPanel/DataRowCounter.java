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
    }
    return rows;
}
}
