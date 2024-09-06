package adminManagement.Annoucement;

import ui.dashboard.*;
import attendanceManagement.Attendance;
import auth.Session;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Yeong Huey Yee
 */
public class AnnoucementDada extends javax.swing.JFrame {

    /**
     * Creates new form maindash
     */
    public AnnoucementDada() {
        initComponents();
        String username = Session.getUsername();
        String role = Session.getRole();
        
        empName.setText(username);
        roleLabel.setText(role);
        
        
        if (Session.isLoggedIn()) {
            String userId = Session.getUserId();
            System.out.println("User ID from Session: " + userId);
        } else {
            System.out.println("User is not logged in.");
        } loadUserData();
    }

private void loadUserData() {
        String filePath = "announcement.txt";
        DefaultTableModel model = (DefaultTableModel) AnnoucementTable.getModel();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming the file is comma-separated
                String[] rowData = line.split(",");
                model.addRow(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
        sidePanel = new javax.swing.JPanel();
        btnProfile = new javax.swing.JButton();
        roleLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        empName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        CreateBTN = new javax.swing.JButton();
        DeleteBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        AnnoucementTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        TimeIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(128, 128, 128));
        sidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProfile.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        btnProfile.setText("View Profile");
        btnProfile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });
        sidePanel.add(btnProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 30));

        roleLabel.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(242, 242, 242));
        roleLabel.setText("Admin");
        sidePanel.add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jButton1.setText("Leave");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 130, 50));

        jButton2.setText("Attendance");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 130, 50));

        jButton3.setText("Log Out");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 130, 50));

        jButton4.setText("Annoucement");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 130, 50));

        jButton5.setText("Dashboard");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 130, 50));

        empName.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        empName.setForeground(new java.awt.Color(255, 255, 255));
        empName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empName.setText("EmpName");
        empName.setToolTipText("");
        sidePanel.add(empName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

        mainPanel.add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 600));

        jPanel1.setBackground(new java.awt.Color(128, 128, 128));

        header.setBackground(new java.awt.Color(255, 242, 242));
        header.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setText("Admin Panel");
        header.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(356, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(header)
                .addContainerGap())
        );

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 860, 50));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 204, 204));

        CreateBTN.setText("Create");
        CreateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(CreateBTN)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(CreateBTN)
                .addContainerGap())
        );

        DeleteBTN.setText("Delete");
        DeleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBTNActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel1.setText("Annoucement Center");

        AnnoucementTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AnnoucementTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Title", "Annoucement", "Audience", "By", "Date"
            }
        ));
        AnnoucementTable.setRowHeight(30);
        jScrollPane1.setViewportView(AnnoucementTable);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(101, 101, 101)
                .addComponent(DeleteBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 52, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(DeleteBTN))
                        .addGap(12, 12, 12)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 860, 560));

        TimeIn.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(TimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(TimeIn)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 450, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // TODO add your handling code here:
        profile.ProfileButton profileLoader = new profile.ProfileButton();
       profile.ViewProfile viewprofile = new profile.ViewProfile();
         
        profileLoader.onViewProfileButtonClick(viewprofile); 
        this.dispose();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        leaveManagement.ApplyLeave leave = new leaveManagement.ApplyLeave();
leave.setVisible(true);
this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            attendanceManagement.Attendance attendance = new attendanceManagement.Attendance();
attendance.setVisible(true);
this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        auth.Session.logout();
        JOptionPane.showMessageDialog(this, "You have been logged out.");

    // Close the current frame and exit application
    this.dispose();
    System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void DeleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBTNActionPerformed
        // TODO add your handling code here:
      
 try {
    // Read the contents of the announcement file
    List<String> announcements = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("announcement.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            announcements.add(line);
        }
    }

    // Find the announcement to delete
    int selectedRow = AnnoucementTable.getSelectedRow();
    if (selectedRow >= 0) {
        String uniqueId = (String) AnnoucementTable.getValueAt(selectedRow, 0); // Assuming the ID is in the first column
        String announcementToDelete = null;
        for (String announcement : announcements) {
            String[] parts = announcement.split(",");
            if (parts[0].equals(uniqueId)) {
                announcementToDelete = announcement;
                break;
            }
        }

        // Remove the announcement from the list
        if (announcementToDelete != null) {
            announcements.remove(announcementToDelete);

            // Rewrite the file without the deleted announcement
            try (PrintWriter out = new PrintWriter(new FileWriter("announcement.txt"))) {
                for (String announcement : announcements) {
                    out.println(announcement);
                }
                out.flush();
                JOptionPane.showMessageDialog(this, "Announcement deleted successfully!");

                // Clear the table before reloading the user data
                DefaultTableModel tableModel = (DefaultTableModel) AnnoucementTable.getModel();
                tableModel.setRowCount(0); // Clear the table

                loadUserData(); // Reload the table with the updated data
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage());
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "No announcement selected.");
    }
} catch (IOException e) {
    JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
}
  
    }//GEN-LAST:event_DeleteBTNActionPerformed

    private void CreateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBTNActionPerformed
        // TODO add your handling code here:
      
       adminManagement.Annoucement.Create createAnnoucement= new adminManagement.Annoucement.Create();
createAnnoucement.setVisible(true);
this.dispose();
    }//GEN-LAST:event_CreateBTNActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       adminManagement.DisplayA.DisplayAnnoucement diplayAnnoucement = new adminManagement.DisplayA.DisplayAnnoucement();
diplayAnnoucement.setVisible(true);
this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        ui.dashboard.BackButton backbutton= new ui.dashboard.BackButton();
        backbutton.navigateBasedOnRole();
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(AnnoucementDada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnnoucementDada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnnoucementDada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnnoucementDada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AnnoucementTable;
    private javax.swing.JButton CreateBTN;
    private javax.swing.JButton DeleteBTN;
    private javax.swing.JLabel TimeIn;
    private javax.swing.JButton btnProfile;
    private javax.swing.JLabel empName;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
