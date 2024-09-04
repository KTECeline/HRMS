/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package adminManagement.List;

/**
 *
 * @author Yeong Huey Yee
 */

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.text.ParseException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;




public class UpdateEmployee extends javax.swing.JFrame {

    /**
     * Creates new form ManageEmployee
     */
    public UpdateEmployee() {
    initComponents();
    loadTableData(); // Load data when the form initializes
    int selectedRow = jTable1.getSelectedRow();
}
    
public void setEmployeeDetails(String userID, String username, String password, String fullName, String gender, String birthDate, String phoneNumber, String maritalStatus, String nationality, String email, String address, String role, String position, String department, String dateOfJoining, String employmentType, String jobTitle, String responsibilities, String emergencyName, String emergencyPhoneNo, String bankName, String accountNumber) {

        // Set the received data into the corresponding fields
    txtUserId.setText(userID);
    txtUsername.setText(username);
    txtPassword.setText(password);
    txtFullName.setText(fullName);
    txtGender.setSelectedItem(gender);

    // Handle Date of Birth and Date of Joining
    try {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");
        java.util.Date parsedBirthDate = format.parse(birthDate);
        txtBOD.setDate(parsedBirthDate);

        java.util.Date parsedJoinDate = format.parse(dateOfJoining);
        txtDateJoined.setDate(parsedJoinDate);
    } catch (ParseException e) {
        // Handle parsing exceptions
    }

    txtPhone.setText(phoneNumber);
    txtMS.setSelectedItem(maritalStatus);
    txtNationality.setSelectedItem(nationality);
    txtEmail.setText(email);
    txtAddress.setText(address);
    txtRole.setSelectedItem(role);
    txtPosition.setSelectedItem(position);
    txtDepartment.setSelectedItem(department);
    txtEmployement.setSelectedItem(employmentType);
    txtWkTitle.setText(jobTitle);
    txtResponsibilities.setText(responsibilities);
    txtEname.setText(emergencyName);
    txtContact.setText(emergencyPhoneNo);
    txtBankNM.setSelectedItem(bankName);
    txtBankNo.setText(accountNumber);
    }
    
   


    
private void setColumnWidths() {
   jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);   // ID column
    jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);  // Username column
    jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);  // Password column
    jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);  // Full Name column
    jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);   // Gender column
    jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);   // Date of Birth column
    jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);  // Phone Number column
    jTable1.getColumnModel().getColumn(7).setPreferredWidth(100);  // Marital Status column
    jTable1.getColumnModel().getColumn(8).setPreferredWidth(130);  // Nationality column
    jTable1.getColumnModel().getColumn(9).setPreferredWidth(150);   // Email column
    jTable1.getColumnModel().getColumn(10).setPreferredWidth(100);   // Home Address column
    jTable1.getColumnModel().getColumn(11).setPreferredWidth(200);  // Role column
    jTable1.getColumnModel().getColumn(12).setPreferredWidth(150);  // Position column
    jTable1.getColumnModel().getColumn(13).setPreferredWidth(100);  // Department column
    jTable1.getColumnModel().getColumn(14).setPreferredWidth(100);   // Date of Joined column
    jTable1.getColumnModel().getColumn(15).setPreferredWidth(120);   // Employment Type column
    jTable1.getColumnModel().getColumn(16).setPreferredWidth(120);  // Job Title column
    jTable1.getColumnModel().getColumn(17).setPreferredWidth(120);  // Responsiblies column
    jTable1.getColumnModel().getColumn(18).setPreferredWidth(100);  // Contact Number column
    jTable1.getColumnModel().getColumn(19).setPreferredWidth(100);   // Phone Number column
    jTable1.getColumnModel().getColumn(20).setPreferredWidth(130);   // Bank Name column
    jTable1.getColumnModel().getColumn(21).setPreferredWidth(100);  // Account Number column

    jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  // Disable auto-resize

// Set horizontal scroll policy for jScrollPane2
jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
}

private void addTableSelectionListener() {
    jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jTable1.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting()) {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow != -1) {
                String userID = jTable1.getValueAt(selectedRow, 0).toString();
                String username = jTable1.getValueAt(selectedRow, 1).toString();
                String password = jTable1.getValueAt(selectedRow, 2).toString();
                String fullName = jTable1.getValueAt(selectedRow, 3).toString();
                String gender = jTable1.getValueAt(selectedRow, 4).toString();
                String birthDate = jTable1.getValueAt(selectedRow, 5).toString();
                String phoneNumber = jTable1.getValueAt(selectedRow, 6).toString();
                String maritalStatus = jTable1.getValueAt(selectedRow, 7).toString();
                String nationality =jTable1.getValueAt(selectedRow, 8).toString();
                String email = jTable1.getValueAt(selectedRow, 9).toString();
                String address = jTable1.getValueAt(selectedRow, 10).toString();
                String role = jTable1.getValueAt(selectedRow, 11).toString();
                String position = jTable1.getValueAt(selectedRow, 12).toString();
                String department = jTable1.getValueAt(selectedRow, 13).toString();
                String dateOfJoining = jTable1.getValueAt(selectedRow, 14).toString();
                String employmentType = jTable1.getValueAt(selectedRow, 15).toString();
                String jobTitle = jTable1.getValueAt(selectedRow, 16).toString();
                String responsibilities = jTable1.getValueAt(selectedRow, 17).toString();
                String emergencyName = jTable1.getValueAt(selectedRow, 18).toString();
                String emergencyPhoneNo = jTable1.getValueAt(selectedRow, 19).toString();
                String bankName = jTable1.getValueAt(selectedRow, 20).toString();
                String accountNumber = jTable1.getValueAt(selectedRow, 21).toString();

                // Set the data into the corresponding fields
                setEmployeeDetails(userID, username, password, fullName, gender, birthDate, phoneNumber, maritalStatus, nationality, email, address, role, position, department, dateOfJoining, employmentType, jobTitle, responsibilities, emergencyName, emergencyPhoneNo, bankName, accountNumber);
            }
        }
    });
}



private void loadTableData() {
    String filePath = "usertxt.txt";
    File file = new File(filePath);
    
    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String firstLine = br.readLine().trim();
        String[] columnsName = firstLine.split(",");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setColumnIdentifiers(columnsName);
        
        // Clear existing rows
        model.setRowCount(0);
        
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();  // Remove leading and trailing whitespace
            if (line.isEmpty()) {
                continue;  // Skip empty lines
            }
            String[] dataRow = line.split(",");
            model.addRow(dataRow);
        }
        
        setColumnWidths();
        
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.setFocusable(true);
        jTable1.setSelectionBackground(Color.PINK);
        
    } catch (Exception ex) {
        Logger.getLogger(UpdateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error loading data from file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMS = new javax.swing.JComboBox<>();
        txtNationality = new javax.swing.JComboBox<>();
        txtGender = new javax.swing.JComboBox<>();
        txtFullName = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtBOD = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtUserId = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtEmployement = new javax.swing.JComboBox<>();
        txtRole = new javax.swing.JComboBox<>();
        txtDateJoined = new com.toedter.calendar.JDateChooser();
        txtDepartment = new javax.swing.JComboBox<>();
        txtPosition = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtEname = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtWkTitle = new javax.swing.JTextField();
        txtResponsibilities = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtBankNo = new javax.swing.JTextField();
        txtBankNM = new javax.swing.JComboBox<>();
        DltBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(128, 128, 128));

        header.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        header.setText("Admin Panel");
        header.setToolTipText("");

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(303, 303, 303)
                .addComponent(header)
                .addContainerGap(391, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(header))
                .addGap(9, 9, 9))
        );

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 50));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("User ID :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Username :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Password :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Full Name :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Gender :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Phone Number :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Date of birth :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Marital Status :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Nationality :");

        txtMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Married", "Single" }));

        txtNationality.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALAYSIAN", "NON-MALAYSIAN" }));

        txtGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        txtFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullNameActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel12.setText("Employee Personal Information");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Home Address :");

        txtAddress.setToolTipText("");
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Email Address :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNationality, 0, 1, Short.MAX_VALUE)
                            .addComponent(txtGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFullName)
                            .addComponent(txtPassword)
                            .addComponent(txtPhone)
                            .addComponent(txtBOD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtUserId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(216, 216, 216))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtUserId))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtBOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 270, 440));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Role :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Department :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Date of Joining :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Employment Type :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Position :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel18.setText("Professional & Company Information");

        txtEmployement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full time", "Part time", "Internship" }));

        txtRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Hr Officer", "Department Manager", "Employee", "Payroll Officer" }));
        txtRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoleActionPerformed(evt);
            }
        });

        txtDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sales", "IT", "Marketing", "None" }));

        txtPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT SUPPORT GROUP", "SALES OPERATION GROUP", "MARKETING OPERATION GROUP", "NONE" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel13)))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDateJoined, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmployement, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPosition, 0, 1, Short.MAX_VALUE)
                            .addComponent(txtRole, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 46, Short.MAX_VALUE)
                        .addComponent(jLabel18)))
                .addGap(46, 46, 46))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtDateJoined, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtEmployement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 360, 210));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel15.setText("Emergency Contact");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Contact Name :");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Phone Number :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(txtEname)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 210, 170));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel16.setText("Working Experience");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Job Title :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Responsibilities:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtWkTitle)
                            .addComponent(txtResponsibilities, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWkTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResponsibilities, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 360, 220));

        jButton16.setBackground(new java.awt.Color(255, 153, 153));
        jButton16.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        jButton16.setText("Update Account");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        mainPanel.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 610, 180, -1));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel27.setText("Bank Account Detail");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Bank Name :");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Account Number :");

        txtBankNM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HONG LEONG BANK", "CIMB BANK", "MAYBANK", "PUBLIC BANK" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(txtBankNo)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel27))
                    .addComponent(txtBankNM, 0, 164, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBankNM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBankNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, 210, 170));

        DltBTN.setBackground(new java.awt.Color(255, 51, 51));
        DltBTN.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        DltBTN.setText("Delete Account");
        DltBTN.setToolTipText("");
        DltBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DltBTNActionPerformed(evt);
            }
        });
        mainPanel.add(DltBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 650, -1, -1));

        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        mainPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 890, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoleActionPerformed

    }//GEN-LAST:event_txtRoleActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
                                        
           addTableSelectionListener();                              
    // Retrieve the input data
    String userID = txtUserId.getText().trim();
    String username = txtUsername.getText().trim();
    String password = txtPassword.getText().trim();
    String fullName = txtFullName.getText().trim();
    String gender = txtGender.getSelectedItem() != null ? txtGender.getSelectedItem().toString().trim() : "";
    String phoneNumber = txtPhone.getText().trim();
    String maritalStatus = txtMS.getSelectedItem() != null ? txtMS.getSelectedItem().toString().trim() : "";
    String nationality = txtNationality.getSelectedItem() != null ? txtNationality.getSelectedItem().toString().trim() : "";
    String email = txtEmail.getText().trim();
    String address = txtAddress.getText().trim();
    String role = txtRole.getSelectedItem() != null ? txtRole.getSelectedItem().toString().trim() : "";
    String position = txtPosition.getSelectedItem() != null ? txtPosition.getSelectedItem().toString().trim() : "";
    String department = txtDepartment.getSelectedItem() != null ? txtDepartment.getSelectedItem().toString().trim() : "";
    String employmentType = txtEmployement.getSelectedItem() != null ? txtEmployement.getSelectedItem().toString().trim() : "";
    String workTitle = txtWkTitle.getText().trim();
    String workResponsibilities = txtResponsibilities.getText().trim();
    String emergencyName = txtEname.getText().trim();
    String emergencyPhoneNo = txtContact.getText().trim();
    String bankName = txtBankNM.getSelectedItem() != null ? txtBankNM.getSelectedItem().toString().trim() : "";
    String accountNumber = txtBankNo.getText().trim();
    
    // Handle date conversion
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
    String birthDateString = "";
    String dateString = "";
    if (txtBOD.getDate() != null) {
        birthDateString = dateFormat.format(txtBOD.getDate());
    }
    if (txtDateJoined.getDate() != null) {
        dateString = dateFormat.format(txtDateJoined.getDate());
    }

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
                    
    loadTableData();


    }//GEN-LAST:event_jButton16ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
   
    }//GEN-LAST:event_jTable1MouseClicked

    private void DltBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DltBTNActionPerformed
                                  
                                         
    String userID = txtUserId.getText().trim();
    String fullName = txtFullName.getText().trim();

    if (userID.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Error: User ID must be provided.");
        return;
    }

    // Confirm deletion with the user
    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the record for " + fullName + "?", 
                                                 "Confirm Deletion", JOptionPane.YES_NO_OPTION);
    if (response != JOptionPane.YES_OPTION) {
        // User chose not to delete
        return;
    }

    // Read existing data and check for the record to delete
    File file = new File("usertxt.txt");
    StringBuilder fileContent = new StringBuilder();
    boolean recordDeleted = false;

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length > 1 && data[0].equals(userID)) {
                // Skip appending the line to delete it
                recordDeleted = true;
                continue; // Skip to the next line
            }
            fileContent.append(line).append(System.getProperty("line.separator"));
        }

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error reading data: " + e.getMessage());
        return;
    }

    // If a record was deleted, write the updated content back to the file
    if (recordDeleted) {
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(fileContent.toString());
            JOptionPane.showMessageDialog(null, "Record deleted successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving data: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(null, "Error: User ID not found.");
    }

    loadTableData();
                                      

    }//GEN-LAST:event_DltBTNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminManagement.List.List().setVisible(true);
                
            }
        });         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFullNameActionPerformed

    


    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new UpdateEmployee().setVisible(true);
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DltBTN;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton16;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtAddress;
    private com.toedter.calendar.JDateChooser txtBOD;
    private javax.swing.JComboBox<String> txtBankNM;
    private javax.swing.JTextField txtBankNo;
    private javax.swing.JTextField txtContact;
    private com.toedter.calendar.JDateChooser txtDateJoined;
    private javax.swing.JComboBox<String> txtDepartment;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JComboBox<String> txtEmployement;
    private javax.swing.JTextField txtEname;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JComboBox<String> txtGender;
    private javax.swing.JComboBox<String> txtMS;
    private javax.swing.JComboBox<String> txtNationality;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JComboBox<String> txtPosition;
    private javax.swing.JTextField txtResponsibilities;
    private javax.swing.JComboBox<String> txtRole;
    private javax.swing.JLabel txtUserId;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtWkTitle;
    // End of variables declaration//GEN-END:variables
}
