package payrollManagement.payrollManager.Create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Hui Nan
 */

public class PayrollId {
    public static String nextUserId = "P1";
    public static final String USER_FILE = "../HRMS_2/Src/payrollManagement/payroll.txt";

    static {
        loadPayrollId();
    }

    private static void loadPayrollId() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            int highestId = 0;
            int lineNumber = 1;

            reader.readLine(); 

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] userData = line.split(",");
                    if (userData.length > 0) {
                        String idStr = userData[0].trim();
                        try {
                            if (idStr.startsWith("P")) {
                                int userId = Integer.parseInt(idStr.substring(1));
                                if (userId > highestId) {
                                    highestId = userId;
                                }
                            } else {
                                String message = String.format("Invalid user ID format at line %d: %s", lineNumber, line);
                                System.out.println(message);
                            }
                        } catch (NumberFormatException e) {
                            String message = String.format("Invalid numeric part in user ID at line %d: %s", lineNumber, line);
                            System.out.println(message);
                        }
                    } else {
                        String message = String.format("Invalid user data at line %d: %s", lineNumber, line);
                        System.out.println(message);
                    }
                }
                lineNumber++;
            }

            // Set the next user ID
            nextUserId = "P" + (highestId + 1);
            String message = String.format("Next payroll ID is: %s", nextUserId);
            System.out.println(message);
        } catch (IOException e) {
            String message = "Error reading user file";
            System.out.println(message);
            // Optionally, set a default ID if the file cannot be read
            nextUserId = "P1";
        }
    }

    public static String getNextPayrollId() {
        String currentId = nextUserId;
        int currentNumericPart = Integer.parseInt(currentId.substring(1));
        nextUserId = "P" + (currentNumericPart + 1);
        return currentId;
    }
}