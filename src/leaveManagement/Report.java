/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package leaveManagement;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author jinyi
 */
public class Report extends javax.swing.JFrame {

    private static Map<String, UserLeaveData> userLeaveMap = new HashMap<>();
    
    public Report() {
        initComponents();
        loadData();
        updateTable();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTable1MouseClicked(evt);
    
    }
        
    });
    }

    private void loadData() {
        String userFilePath = "usertxt.txt";
        String leaveFilePath = "leave.txt";
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        try {
            // Read all lines from the user file
            List<String> userLines = Files.readAllLines(Paths.get(userFilePath));

            // Iterate over each line and initialize user data
            for (String line : userLines) {
                if (line.startsWith("Id")) continue; // Skip header

                String[] parts = line.split(",");
                if (parts.length < 4) continue; // Ensure there are enough columns

                String userId = parts[0].trim();
                String username = parts[1].trim();
                String fullName = parts[3].trim(); // Retrieve the full name (3rd column)

                // Initialize with default values
                UserLeaveData userLeaveData = new UserLeaveData(username, fullName);
                userLeaveMap.put(userId, userLeaveData);
            }

            // Read all lines from the leave file
            List<String> leaveLines = Files.readAllLines(Paths.get(leaveFilePath));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Fixed date format

            // Iterate over each line and process leave data
            for (String line : leaveLines) {
                if (line.startsWith("User Id")) continue; // Skip header

                String[] parts = line.split(",");
                if (parts.length < 10) continue; // Ensure there are enough columns

                String userId = parts[0].trim();
                String leaveDate = parts[4].trim();
                String leaveType = parts[3].trim();
                int daysTaken = Integer.parseInt(parts[6].trim());
                String status = parts[8].trim();
                int remainingLeave = Integer.parseInt(parts[9].trim());

                // Parse the leave date and check if it's in the current year
                Calendar leaveCalendar = Calendar.getInstance();
                leaveCalendar.setTime(sdf.parse(leaveDate));
                int leaveYear = leaveCalendar.get(Calendar.YEAR);

                if (leaveYear == currentYear) {
                    UserLeaveData userLeaveData = userLeaveMap.get(userId);

                    if (userLeaveData != null && status.equalsIgnoreCase("Approved")) {
                        if (leaveType.equalsIgnoreCase("Medical Leave")) {
                            userLeaveData.incrementMedicalLeaveCount();
                        } else if (leaveType.equalsIgnoreCase("Unpaid Leave")) {
                            userLeaveData.incrementEmergencyLeaveCount();
                        }
                        userLeaveData.addTotalDays(daysTaken);

                        if (leaveType.equalsIgnoreCase("Annual Leave")) {
                            userLeaveData.setRemainingAnnualLeave(remainingLeave);
                        }
                    }
                }
            }
             for (UserLeaveData data : userLeaveMap.values()) {
            if (data.getTotalDays() == 0) { // Assuming no leave records means total days is 0
                data.setRemainingAnnualLeave(12);
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
    }
     private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Map.Entry<String, UserLeaveData> entry : userLeaveMap.entrySet()) {
            UserLeaveData data = entry.getValue();
            model.addRow(new Object[]{
                data.getUsername(),
                data.getFullName(),
                data.getMedicalLeaveCount(),
                data.getEmergencyLeaveCount(),
                data.getTotalDays(),
                data.getRemainingAnnualLeave()
            });
        }
    }
        private static class UserLeaveData {
        private String username;
        private String fullName;
        private int medicalLeaveCount;
        private int emergencyLeaveCount;
        private int totalDays;
        private int remainingAnnualLeave;

        public UserLeaveData(String username, String fullName) {
            this.username = username;
            this.fullName = fullName;
            this.medicalLeaveCount = 0;
            this.emergencyLeaveCount = 0;
            this.totalDays = 0;
            this.remainingAnnualLeave = 0;
        }

        public void incrementMedicalLeaveCount() {
            this.medicalLeaveCount++;
        }

        public void incrementEmergencyLeaveCount() {
            this.emergencyLeaveCount++;
        }

        public void addTotalDays(int days) {
            this.totalDays += days;
        }

        public void setRemainingAnnualLeave(int remainingLeave) {
            this.remainingAnnualLeave = remainingLeave;
        }

        public String getUsername() { return username; }
        public String getFullName() { return fullName; }
        public int getMedicalLeaveCount() { return medicalLeaveCount; }
        public int getEmergencyLeaveCount() { return emergencyLeaveCount; }
        public int getTotalDays() { return totalDays; }
        public int getRemainingAnnualLeave() { return remainingAnnualLeave; }
    }
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
                          
    int selectedRow = jTable1.getSelectedRow();  // Get the selected row index
    TableModel model = jTable1.getModel();  // Get the table model

    // Set text fields and other components with the values from the selected row
    UN.setText(model.getValueAt(selectedRow, 0).toString());
    TL.setText(model.getValueAt(selectedRow, 1).toString());
    SD.setText(model.getValueAt(selectedRow, 2).toString());
    ED.setText(model.getValueAt(selectedRow, 3).toString());
    D.setText(model.getValueAt(selectedRow, 4).toString());
   

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        UN = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TL = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        SD = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ED = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        D = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel1.setText(" Leave Report");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(315, 315, 315))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Username", "Full Name", "Medical Leave Taken", "Unpaid Leave Taken", "Total Days of Leave Taken", "Remaining Annual Leave"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setText("User                                                      :");

        UN.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        UN.setText("...");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setText("Medical Leave Taken                         :");

        TL.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        TL.setText("...");

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setText("Unpaid Leave Taken                          :");

        SD.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        SD.setText("...");

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel7.setText("Total Days of Leave Taken               :");

        ED.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        ED.setText("...");

        jLabel10.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel10.setText("Remaining Annual Leave                  :");

        D.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        D.setText("...");

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TL, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                            .addComponent(UN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(D, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ED, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SD, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(UN))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TL))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(SD))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ED))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(D))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ui.dashboard.ManagerDashboard().setVisible(true);
            }
        });    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
        
        
                }
            

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel D;
    private javax.swing.JLabel ED;
    private javax.swing.JLabel SD;
    private javax.swing.JLabel TL;
    private javax.swing.JLabel UN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

} 

