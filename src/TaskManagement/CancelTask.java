/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TaskManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
public class CancelTask extends javax.swing.JFrame {

    /**
     * Creates new form Approve
     */
    public CancelTask() {
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
    String filePath = "task.txt";
    File file = new File(filePath);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Define date format

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String firstLine = br.readLine().trim();
        String[] columnsName = firstLine.split(",");

        List<Integer> columnsToDisplay = new ArrayList<>();
        int[] selectedColumns = { 1,2, 3, 4, 5, 6};
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
            
                // Create a new array for the filtered data, excluding the username
                
                try {
                    String[] filteredDataRow = new String[columnsToDisplay.size()];
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

        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

    } catch (Exception ex) {
        Logger.getLogger(CancelTask.class.getName()).log(Level.SEVERE, null, ex);
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
    details.setText(model.getValueAt(selectedRow, 5).toString());
   

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
        jLabel10 = new javax.swing.JLabel();
        UN = new javax.swing.JLabel();
        TL = new javax.swing.JLabel();
        SD = new javax.swing.JLabel();
        ED = new javax.swing.JLabel();
        D = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        details = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Tasks ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel2.setText("Assigned By     :");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setText("Department     :");

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setText("Task                  :");

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel7.setText("Start Date        :");

        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel8.setText("Details              :");

        jLabel10.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel10.setText("End Date          :");

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

        details.setColumns(20);
        details.setRows(5);
        jScrollPane2.setViewportView(details);

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

        jButton3.setBackground(new java.awt.Color(255, 153, 153));
        jButton3.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(UN, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(TL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(D, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                                    .addComponent(ED, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ED))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(D))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UN.setText("...");
        TL.setText("...");
        SD.setText("...");
        ED.setText("...");
        D.setText("...");
        details.setText("..."); // Assuming you have an additional label `R`

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
    this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    int selectedRowIndex = jTable1.getSelectedRow();
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    if (selectedRowIndex != -1) {
        String filePath = "C:\\Users\\jinyi\\Documents\\NetBeansProjects\\java_grp20\\try\\task.txt";
        
        try {
            // Read all lines from the file
            java.util.List<String> lines = Files.readAllLines(Paths.get(filePath));

            // Get the selected row's content
            String selectedUsername = (String) jTable1.getValueAt(selectedRowIndex, 0);
            String selectedDepartment = (String) jTable1.getValueAt(selectedRowIndex, 1);
            String selectedTask = (String) jTable1.getValueAt(selectedRowIndex, 2);
            String selectedStartDate = (String) jTable1.getValueAt(selectedRowIndex, 3);
            String selectedEndDate = (String) jTable1.getValueAt(selectedRowIndex, 4);
            String selectedDetails = (String) jTable1.getValueAt(selectedRowIndex, 5);
            String selectedAssign = (String) jTable1.getValueAt(selectedRowIndex, 6);

            StringBuilder newContent = new StringBuilder();
            boolean found = false;

            for (String line : lines) {
                String[] parts = line.split(",");
                // Assuming the file format has enough columns for comparison
                if (parts.length > 6 
                && parts[1].trim().equalsIgnoreCase(selectedUsername.trim())
                && parts[2].trim().equalsIgnoreCase(selectedDepartment.trim())
                && parts[3].trim().equalsIgnoreCase(selectedTask.trim())
                && parts[4].trim().equalsIgnoreCase(selectedStartDate.trim())
                && parts[5].trim().equalsIgnoreCase(selectedEndDate.trim())
                && parts[6].trim().equalsIgnoreCase(selectedDetails.trim())
                && parts[7].trim().equalsIgnoreCase(selectedAssign.trim())) {
                found = true;
                continue; // Skip this line to "remove" it
            }
                newContent.append(line).append(System.lineSeparator());
            }

            if (found) {
                int response = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to cancel this leave?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                if (response == JOptionPane.YES_OPTION) {
                    // Overwrite the file without the deleted line
                    Files.write(Paths.get(filePath), newContent.toString().getBytes());

                    // Remove the row from the JTable model
                    model.removeRow(selectedRowIndex);

                    JOptionPane.showMessageDialog(this, "Leave cancelled successfully.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selected leave not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while processing the leave cancellation.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row first.");
    }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CancelTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CancelTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CancelTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancelTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CancelTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel D;
    private javax.swing.JLabel ED;
    private javax.swing.JLabel SD;
    private javax.swing.JLabel TL;
    private javax.swing.JLabel UN;
    private javax.swing.JTextArea details;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    
}
