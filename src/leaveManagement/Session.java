package leaveManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Session {
    static String userId;
    static String role;
    static String gender;
    public static String username;
    static boolean isLoggedIn;

    public static void readUserIdFromFile() {
        try {
            File file = new File("usertxt.txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            userId = parts[0];
            role = parts [13];
            username= parts [1];
            gender = parts [5];
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
    
    public static String getGender(){
        return gender;
    }
    
    public static void createSession(String userId, String role, String username, String gender) {
        Session.userId = userId;
        Session.role = role;
        Session.username= username;
        Session.isLoggedIn = true;
        Session.gender= gender;
        
    }

    public static boolean isLoggedIn() {
        return Session.isLoggedIn;
    }
}
        
        


