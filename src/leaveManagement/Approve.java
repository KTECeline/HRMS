/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package leaveManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import auth.Session;

/**
 *
 * @author jinyi
 */
public class Approve extends javax.swing.JFrame {

    /**
     * Creates new form Approve
     */
    public Approve() {
        initComponents();
        loadTableData();
        
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTable1MouseClicked(evt);
    
    }
        
    });
    }
    private void loadTableData() {
    String filePath = "leave.txt";
    File file = new File(filePath);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Define date format

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String firstLine = br.readLine().trim();
        String[] columnsName = firstLine.split(",");

        
        int statusColumn= 8;
        List<Integer> columnsToDisplay = new ArrayList<>();
        int[] selectedColumns = {10, 1, 3, 4, 5, 6, 7};
        for (int index : selectedColumns) {
                columnsToDisplay.add(index);
        }

        // Create a new array for the filtered columns (excluding the username column)
        String[] filteredColumnsName = new String[columnsToDisplay.size()];
        for (int i = 0; i < columnsToDisplay.size(); i++) {
            filteredColumnsName[i] = columnsName[columnsToDisplay.get(i)];
        }
       

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
            if (dataRow[statusColumn].equalsIgnoreCase("pending")) {
                // Create a new array for the filtered data, excluding the username
                String[] filteredDataRow = new String[columnsToDisplay.size()];
                try {
                    for (int i = 0; i < columnsToDisplay.size(); i++) {
                        filteredDataRow[i] = dataRow[columnsToDisplay.get(i)];
                    }
                    model.addRow(filteredDataRow);
                } catch (Exception e) {
                    // Handle the date parsing error
                    System.err.println("Date parsing error for row: " + String.join(",", dataRow));
                    e.printStackTrace();
                }
            }
        }

        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    } catch (Exception ex) {
        Logger.getLogger(Approve.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

    

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        String username = Session.username;
        loadTableData(); // Load data when the form window is opened
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
    R.setText(model.getValueAt(selectedRow, 5).toString());
   

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        UN = new javax.swing.JLabel();
        TL = new javax.swing.JLabel();
        SD = new javax.swing.JLabel();
        ED = new javax.swing.JLabel();
        D = new javax.swing.JLabel();
        R = new javax.swing.JLabel();
        C = new javax.swing.JTextField();
        Approve = new javax.swing.JButton();
        reject = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Leave Applications ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(309, 309, 309))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setText("User                  :");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setText("Type of Leave  :");

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setText("Start date         :");

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel7.setText("End date           :");

        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel8.setText("Reason              :");

        jLabel9.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel9.setText("Comment          :");

        jLabel10.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel10.setText("Days                  :");

        UN.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        UN.setText("...");

        TL.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        TL.setText("...");

        SD.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        SD.setText("...");

        ED.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        ED.setText("...");

        D.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        D.setText("...");

        R.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        R.setText("...");

        C.setText("none");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });

        Approve.setBackground(new java.awt.Color(153, 255, 153));
        Approve.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        Approve.setText("Approve");
        Approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveActionPerformed(evt);
            }
        });

        reject.setBackground(new java.awt.Color(255, 153, 153));
        reject.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        reject.setText("Reject");
        reject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectActionPerformed(evt);
            }
        });

        jButton1.setText("Reload Table");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(TL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(R, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                            .addComponent(D, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ED, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Approve, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reject, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                            .addComponent(SD)))
                    .addComponent(Approve, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ED))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(D))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(R))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(reject, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectActionPerformed
      int selectedRowIndex = jTable1.getSelectedRow();
    if (selectedRowIndex != -1) {
        String comment = C.getText(); // Assuming C is a JTextField for comments
        String filePath = "leave.txt";
        
        try {
            // Read all lines from the file
            java.util.List<String> lines = Files.readAllLines(Paths.get(filePath));

            // Get the selected row's content
            String selectedApplyDate = (String) jTable1.getValueAt(selectedRowIndex, 0);
            String selectedUsername = (String) jTable1.getValueAt(selectedRowIndex, 1);
            String selectedType = (String) jTable1.getValueAt(selectedRowIndex, 2);
            String selectedStartDate = (String) jTable1.getValueAt(selectedRowIndex, 3);
            String selectedEndDate = (String) jTable1.getValueAt(selectedRowIndex, 4);

            StringBuilder newContent = new StringBuilder();
            boolean found = false;

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length > 11 
                    && parts[1].equals(selectedUsername)
                    && parts[3].equals(selectedType)
                    && parts[4].equals(selectedStartDate)
                    && parts[5].equals(selectedEndDate)
                    && parts[10].equals(selectedApplyDate)) {
                    
                 
                    parts[8] = "Rejected";
                    // Replace the comment
                    parts[11] = comment;
                    found = true;
                }
                newContent.append(String.join(",", parts)).append(System.lineSeparator());
            }

            if (found) {
                // Write the updated content back to the file
                Files.write(Paths.get(filePath), newContent.toString().getBytes());
                JOptionPane.showMessageDialog(this, "Leave approved successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Selected row not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while approving the leave.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row first.");
    }

    }//GEN-LAST:event_rejectActionPerformed

    private void ApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApproveActionPerformed
    int selectedRowIndex = jTable1.getSelectedRow();
    if (selectedRowIndex != -1) {
        String comment = C.getText(); // Assuming C is a JTextField for comments
        String filePath = "leave.txt";
        
        try {
            // Read all lines from the file
            java.util.List<String> lines = Files.readAllLines(Paths.get(filePath));

            // Get the selected row's content
            String selectedApplyDate = (String) jTable1.getValueAt(selectedRowIndex, 0);
            String selectedUsername = (String) jTable1.getValueAt(selectedRowIndex, 1);
            String selectedType = (String) jTable1.getValueAt(selectedRowIndex, 2);
            String selectedStartDate = (String) jTable1.getValueAt(selectedRowIndex, 3);
            String selectedEndDate = (String) jTable1.getValueAt(selectedRowIndex, 4);

            StringBuilder newContent = new StringBuilder();
            boolean found = false;

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length > 11 
                    && parts[1].equals(selectedUsername)
                    && parts[3].equals(selectedType)
                    && parts[4].equals(selectedStartDate)
                    && parts[5].equals(selectedEndDate)
                    && parts[10].equals(selectedApplyDate)) {
                    
                    // Replace "Pending" with "Approved"
                    parts[8] = "Approved";
                    // Replace the comment
                    parts[11] = comment;
                    found = true;
                }
                newContent.append(String.join(",", parts)).append(System.lineSeparator());
            }

            if (found) {
                // Write the updated content back to the file
                Files.write(Paths.get(filePath), newContent.toString().getBytes());
                JOptionPane.showMessageDialog(this, "Leave approved successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Selected row not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while approving the leave.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row first.");
    }

    }//GEN-LAST:event_ApproveActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    UN.setText("...");
    TL.setText("...");
    SD.setText("...");
    ED.setText("...");
    D.setText("...");
    R.setText("..."); // Assuming you have an additional label `R`

    // Reload table data
     loadTableData();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ui.dashboard.ManagerDashboard().setVisible(true);
            }
        });
        this.dispose();    // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Approve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Approve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Approve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Approve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Approve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Approve;
    private javax.swing.JTextField C;
    private javax.swing.JLabel D;
    private javax.swing.JLabel ED;
    private javax.swing.JLabel R;
    private javax.swing.JLabel SD;
    private javax.swing.JLabel TL;
    private javax.swing.JLabel UN;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton reject;
    // End of variables declaration//GEN-END:variables

    
}
