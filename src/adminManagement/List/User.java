/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adminManagement.List;

/**
 *
 * @author leopa
 */
import java.text.SimpleDateFormat;
import java.io.*;
import javax.swing.JOptionPane;

public class User {

    // Attributes
    private String userID;
    private String username;
    private String password;
    private String fullName;
    private String gender;
    private String phoneNumber;
    private String maritalStatus;
    private String nationality;
    private String email;
    private String address;
    private String role;
    private String position;
    private String department;
    private String employmentType;
    private String workTitle;
    private String workResponsibilities;
    private String emergencyName;
    private String emergencyPhoneNo;
    private String bankName;
    private String accountNumber;
    private String birthDateString;
    private String dateString;

    // Constructor
    public User(String userID, String username, String password, String fullName, String gender, String phoneNumber, String maritalStatus, String nationality, String email, String address, String role, String position, String department, String employmentType, String workTitle, String workResponsibilities, String emergencyName, String emergencyPhoneNo, String bankName, String accountNumber, String birthDateString, String dateString) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.email = email;
        this.address = address;
        this.role = role;
        this.position = position;
        this.department = department;
        this.employmentType = employmentType;
        this.workTitle = workTitle;
        this.workResponsibilities = workResponsibilities;
        this.emergencyName = emergencyName;
        this.emergencyPhoneNo = emergencyPhoneNo;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.birthDateString = birthDateString;
        this.dateString = dateString;
    }

    // Getters and Setters
    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmploymentType() { return employmentType; }
    public void setEmploymentType(String employmentType) { this.employmentType = employmentType; }

    public String getWorkTitle() { return workTitle; }
    public void setWorkTitle(String workTitle) { this.workTitle = workTitle; }

    public String getWorkResponsibilities() { return workResponsibilities; }
    public void setWorkResponsibilities(String workResponsibilities) { this.workResponsibilities = workResponsibilities; }

    public String getEmergencyName() { return emergencyName; }
    public void setEmergencyName(String emergencyName) { this.emergencyName = emergencyName; }

    public String getEmergencyPhoneNo() { return emergencyPhoneNo; }
    public void setEmergencyPhoneNo(String emergencyPhoneNo) { this.emergencyPhoneNo = emergencyPhoneNo; }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getBirthDateString() { return birthDateString; }
    public void setBirthDateString(String birthDateString) { this.birthDateString = birthDateString; }

    public String getDateString() { return dateString; }
    public void setDateString(String dateString) { this.dateString = dateString; }

    // Method to validate and save the data
    public void saveToFile() {
        // Validation: Check if any required field is empty
        if (userID.isEmpty() || username.isEmpty() || password.isEmpty() || fullName.isEmpty() || gender.isEmpty() || 
            phoneNumber.isEmpty() || maritalStatus.isEmpty() || nationality.isEmpty() || email.isEmpty() || 
            address.isEmpty() || role.isEmpty() || position.isEmpty() || department.isEmpty() || 
            employmentType.isEmpty() || workTitle.isEmpty() || workResponsibilities.isEmpty() || 
            emergencyName.isEmpty() || emergencyPhoneNo.isEmpty() || birthDateString.isEmpty() || dateString.isEmpty() || 
            bankName.isEmpty() || accountNumber.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Error: All fields must be filled in before saving.");
            return; // Stop execution if any field is empty
        }

        // Read existing data and check for the record to update
        File file = new File("usertxt.txt");
        StringBuilder fileContent = new StringBuilder();
        boolean recordUpdated = false;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 1 && data[0].equals(userID)) {
                    // Compare existing data with the current input
                    String currentRecord = userID + "," + username + "," + password + "," + fullName + "," + gender + "," +
                         birthDateString + "," + phoneNumber + "," + maritalStatus + "," + nationality + "," +
                         email + "," + address + "," + role + "," + position + "," + department + "," +
                         dateString + "," + employmentType + "," + workTitle + "," + workResponsibilities + "," +
                         emergencyName + "," + emergencyPhoneNo + "," + bankName + "," + accountNumber;

                    String existingRecord = String.join(",", data);

                    if (!existingRecord.equals(currentRecord)) {
                        fileContent.append(currentRecord).append(System.getProperty("line.separator"));
                        recordUpdated = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "No changes detected. Update not necessary.");
                        return;
                    }
                } else {
                    fileContent.append(line).append(System.getProperty("line.separator"));
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading data: " + e.getMessage());
        }

        // If a record was updated, write the updated content back to the file
        if (recordUpdated) {
            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write(fileContent.toString());
                JOptionPane.showMessageDialog(null, "Update successful!");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: User ID not found.");
        }

        // Load updated table data
        loadTableData();
    }

    // Dummy method for loading table data
    private void loadTableData() {
        // Implementation to load table data
    }
}