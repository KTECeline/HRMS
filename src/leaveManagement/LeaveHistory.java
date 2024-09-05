/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pkgtry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pkgtry.Session;
/**
 *
 * @author jinyi
 */
public class LeaveHistory extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public LeaveHistory() {
        initComponents();
        loadTableData();
        int[] leaveInfo = countUsernameOccurrences(Session.username);
        int occurrences = leaveInfo[0];
        int remainingAnnualDays = leaveInfo[1]; // Get the remaining annual days
        if (occurrences > 0){
            AL.setText("Annual Leave Left : " + remainingAnnualDays + " days ");
        }else{
            AL.setText("Annual Leave Left : 12 days ");
        }
    }
    private void loadTableData() {
    String filePath = "C:\\Users\\jinyi\\Documents\\NetBeansProjects\\java_grp20\\try\\leave.txt";
    File file = new File(filePath);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Define date format

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String firstLine = br.readLine().trim();
        String[] columnsName = firstLine.split(",");

        int usernameColumnIndex = 1;
        int statusColumn= 8;
        List<Integer> columnsToDisplay = new ArrayList<>();
        int[] selectedColumns = {3, 4, 5, 6, 7};
        for (int index : selectedColumns) {
            if (index != usernameColumnIndex) {
                columnsToDisplay.add(index);
            }
        }

        // Create a new array for the filtered columns (excluding the username column)
        String[] filteredColumnsName = new String[columnsToDisplay.size()];
        for (int i = 0; i < columnsToDisplay.size(); i++) {
            filteredColumnsName[i] = columnsName[columnsToDisplay.get(i)];
        }
        filteredColumnsName[filteredColumnsName.length - 1] = "Leave Status";

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setColumnIdentifiers(filteredColumnsName);

        // Clear existing rows
        model.setRowCount(0);

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();  // Remove leading and trailing whitespace
            if (line.isEmpty()) {
                continue;  // Skip empty lines
            }
            String[] dataRow = line.split(",");

            // Filter rows based on the username
            if (dataRow[usernameColumnIndex].equals(Session.username)&& dataRow[statusColumn].equalsIgnoreCase("approved")) {
                // Create a new array for the filtered data, excluding the username
                String[] filteredDataRow = new String[columnsToDisplay.size()];
                try {
                    for (int i = 0; i < columnsToDisplay.size(); i++) {
                        filteredDataRow[i] = dataRow[columnsToDisplay.get(i)];
                    }

                    // Determine leave status based on start and end dates
                    Date currentDate = new Date();
                    Date startDate = sdf.parse(dataRow[4]);  // Adjust the index for your start date column
                    Date endDate = sdf.parse(dataRow[5]);    // Adjust the index for your end date column
                    String leaveStatus;

                    if (currentDate.before(startDate)) {
                        leaveStatus = "Upcoming";
                    } else if (currentDate.after(endDate)) {
                        leaveStatus = "Completed";
                    } else {
                        leaveStatus = "Ongoing";
                    }

                    filteredDataRow[filteredDataRow.length - 1] = leaveStatus;  // Add leave status to the row

                    model.addRow(filteredDataRow);
                } catch (ParseException e) {
                    // Handle the date parsing error
                    System.err.println("Date parsing error for row: " + String.join(",", dataRow));
                    e.printStackTrace();
                }
            }
        }

        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    } catch (Exception ex) {
        Logger.getLogger(LeaveHistory.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}



    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        String username = Session.username;
        String Data = "Approved";
        loadTableData(); // Load data when the form window is opened
}
 
    private int[] countUsernameOccurrences(String username) {
    int count = 0; // Initialize count
    int totalDays = 0; // Initialize total days
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);

    try {
        // Read all lines from the file
        java.util.List<String> lines = Files.readAllLines(Paths.get("leave.txt"));

        // Iterate over each line to count the username with "annual leave" and sum up the days
        for (String line : lines) {
            // Split the line by commas
            String[] parts = line.split(",");

            // Check if parts have enough elements and if both username and leave type match
            if (parts.length > 4 && parts[1].equals(username) && parts[3].equalsIgnoreCase("annual leave ")&& parts[8].equalsIgnoreCase("approved")) {
                // Parse the start date from the file
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = dateFormat.parse(parts[4]);

                // Check if the start date falls within the current year
                if (startDate.getYear() + 1900 == currentYear) {
                    count++; // Increment count if both conditions are met
                    
                    // Parse the days from the file and add to totalDays
                    try {
                        totalDays += Integer.parseInt(parts[6]);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
    }

    // Calculate the remaining annual leave days
    int remainingAnnualDays = 12 - totalDays;

    return new int[] {count, remainingAnnualDays}; // Return the count and remaining annual days
    
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        AL = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Leave History");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(376, 376, 376))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        AL.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        AL.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(AL, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(AL)
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jButton2.setText("Cancel Leave");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pkgtry.ApplyLeave().setVisible(true);
            }
        });    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    int selectedRowIndex = jTable1.getSelectedRow();  
    if (selectedRowIndex != -1) {
        
        String leaveStatus = model.getValueAt(selectedRowIndex, model.getColumnCount() - 1).toString();
       if ("Upcoming".equalsIgnoreCase(leaveStatus)){
        int response = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to cancel this leave?",
                "Confirm",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (response == JOptionPane.YES_OPTION) {
            // Get the values of the row
            String[] rowValues = new String[model.getColumnCount()];
            for (int i = 0; i < model.getColumnCount(); i++) {
                rowValues[i] = model.getValueAt(selectedRowIndex, i).toString();
            }
            
            model.removeRow(selectedRowIndex);
            
            String filePath = "C:\\Users\\jinyi\\Documents\\NetBeansProjects\\java_grp20\\try\\leave.txt";
            File file = new File(filePath);
            
            try {
                // Read all lines from the file
                List<String> lines = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        lines.add(line);
                    }
                }
                
                // Find and remove the matching row
                for (int i = 0; i < lines.size(); i++) {
                    String[] dataRow = lines.get(i).split(",");
                    if (dataRow[1].equals(Session.username) && dataRow[3].equals(rowValues[0])) {  // Match username and start date
                        lines.remove(i);
                        break;
                    }
                }
                
                 try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    for (String line : lines) {
                        bw.write(line);
                        bw.newLine();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(LeaveHistory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        } else {
            // Show a message if the leave is not "Upcoming"
            JOptionPane.showMessageDialog(this, "Only upcoming leave can be canceled.", "Error", JOptionPane.ERROR_MESSAGE);}
     } else {
        // No row selected
        JOptionPane.showMessageDialog(this, "Please select a row to cancel leave.", "Error", JOptionPane.ERROR_MESSAGE);
    }
   
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(LeaveHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeaveHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeaveHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaveHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaveHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
