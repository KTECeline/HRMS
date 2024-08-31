/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package auth;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author leopa
 */
public class UserIdManager {
    public static int nextUserId=1;
    public static final String USER_FILE="usertxt.txt";
    private static final Logger LOGGER= Logger.getLogger(UserIdManager.class.getName());
    private static final Set<String> existingUsernames= new HashSet<>();
    static {
        loadUserId();
    }
    
    private static void loadUserId(){
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))){
            String line;
            int highestId=0;
            int lineNumber = 1;
            
            reader.readLine();
            
            while ((line =reader.readLine()) !=null){
               
                if (!line.trim().isEmpty()){
                String[] userData =line.split(",");
                if (userData.length >2) {
                    
                    try{
                        int userId = Integer.parseInt(userData[0].trim());
                    
                    if (userId >highestId) {
                        highestId=userId;
                    }
                    existingUsernames.add(userData[2].trim().toLowerCase());
                }catch (NumberFormatException e){
                   LOGGER.log(Level.WARNING, "Invalid user ID found at line {0}: {1}", new Object[]{lineNumber, line});
                }
            }else {
                    LOGGER.log(Level.WARNING,"Invalid userid found at line {0}:{1}",new Object[]{lineNumber,line});
                }
            }lineNumber++;
            }
            nextUserId= highestId +1;
            LOGGER.log(Level.INFO, "Highest user ID found: {0}. Next user ID set to: {1}", new Object[]{highestId, nextUserId});
        } catch (IOException e){
             LOGGER.log(Level.SEVERE, "Error reading user file", e);
            nextUserId =1;
        }
    }
    
    public static int getNextUserId(){
        return nextUserId++;
    
        
    }
    public static boolean isUsernameAvailable(String username){
    return !existingUsernames.contains(username.trim().toLowerCase());
} public static void addUsername(String username){
    existingUsernames.add(username.trim().toLowerCase());
}
}
   


