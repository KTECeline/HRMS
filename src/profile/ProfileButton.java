/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package profile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author leopa
 */
public class ProfileButton {
public void loadProfile(String filePath, String userId, profile.ViewProfile viewprofile) {
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(",");

                if (dataRow[0].equals(userId)) {
                    String userID = dataRow[0];
                    String username = dataRow[1];
                    String password = dataRow[2];
                    String fullName = dataRow[3];
                    String gender = dataRow[4];
                    String dateOfBirth = dataRow[5];
                    String phoneNumber = dataRow[6];
                    String maritalStatus = dataRow[7];
                    String nationality = dataRow[8];
                    String email = dataRow[9];
                    String address = dataRow[10];
                    String role = dataRow[11];
                    String position = dataRow[12];
                    String department = dataRow[13];
                    String datejoined = dataRow[14];
                    String employmentType = dataRow[15];
                    String workTitle = dataRow[16];
                    String workResponsibilities = dataRow[17];
                    String emergencyName = dataRow[18];
                    String emergencyPhoneNo = dataRow[19];
                    String bankName = dataRow[20];
                    String accountNumber = dataRow[21];

                    viewprofile.setLabelValues(userID, username, password, fullName, gender, dateOfBirth,
                            phoneNumber, maritalStatus, nationality, email, address,
                            role, position, department, datejoined, employmentType,
                            workTitle, workResponsibilities, emergencyName, emergencyPhoneNo,
                            bankName, accountNumber);
                    viewprofile.setVisible(true);
                }
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(profile.ViewProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void onViewProfileButtonClick(profile.ViewProfile viewprofile) {
        String filePath = "usertxt.txt";
        String userId = auth.Session.getUserId();
        loadProfile(filePath, userId, viewprofile);
    }
}
