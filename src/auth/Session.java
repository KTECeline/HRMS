package auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Session {
    private static String userId;
    private static String role;
    private static String username;
    private static boolean isLoggedIn;

    public static void readUserIdFromFile() {
        try {
            File file = new File("usertxt.txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            userId = parts[0];
            role = parts [4];
            username= parts [2];
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    public static String getUserId() {
        return userId;
    }
    
    public static String getRole(){
        return role;
    }
    
    public static String getUsername(){
        return username;
    }
    
    public static void createSession(String userId, String role, String username) {
        Session.userId = userId;
        Session.role = role;
        Session.username= username;
        Session.isLoggedIn = true;
    }

    public static boolean isLoggedIn() {
        return Session.isLoggedIn;
    }
}
        
        
}

