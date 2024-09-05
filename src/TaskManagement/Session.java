package TaskManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Session {
    static String userId;
    static String role;
    static String gender;
    static String Dept;
    public static String username;
    static boolean isLoggedIn;

    public static void readUserIdFromFile() {
        try {
            File file = new File("usertxt.txt");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            userId = parts[0];
            role = parts [12];
            username= parts [1];
            gender = parts [5];
            Dept = parts [13];
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
    
    public static String getDept(){
        return Dept;
    }
    
    public static void createSession(String userId, String role, String username, String gender,String Dept) {
        Session.userId = userId;
        Session.role = role;
        Session.username= username;
        Session.isLoggedIn = true;
        Session.gender= gender;
        Session.Dept = Dept;

        
    }

    public static boolean isLoggedIn() {
        return Session.isLoggedIn;
    }
    
    public static void logout() {
        userId = null;
        role = null;
        username = null;
        isLoggedIn = false;
    }
}
        


