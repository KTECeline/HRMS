package payrollManagement.payrollManager.Create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
    public static final String USER_FILE = "payroll.txt";
private static boolean isLoaded = false;
private static Set<String> payrollIds = new HashSet<>();
    static {
        loadPayrollId();
    }

    private static void loadPayrollId() {
         if (isLoaded) {
            return;  // Prevent re-loading the file unnecessarily
        }
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
                        if (payrollIds.contains(idStr)) {
                            System.out.printf("Duplicate ID found at line %d: %s%n", lineNumber, idStr);
                            continue; // Skip duplicate entries
                        }
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
           
             System.out.printf("Next payroll ID is: %s%n", nextUserId);
            isLoaded=true;
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