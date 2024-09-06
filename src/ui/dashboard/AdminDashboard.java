package ui.dashboard;
import auth.Session;
import javax.swing.JOptionPane;
import adminManagement.GetPanel.DataRowCounter;
import profile.ProfileButton;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Yeong Huey Yee
 */
public class AdminDashboard extends javax.swing.JFrame {
   
    
    public AdminDashboard() {
        initComponents();
        String username = Session.getUsername();
        empName1.setText(username);
        
        
        int totalEmployee=DataRowCounter.countEmployees("usertxt.txt");
        TotalEmployee.setText(String.valueOf(totalEmployee));
        
        int totalRows = DataRowCounter.countRowsInFile("data.txt");
        UnlockAcc.setText(String.valueOf(totalRows));
        
        int totalLeave = DataRowCounter.countLeaveonDay();
        txtLeave.setText(String.valueOf(totalLeave));
        
       
        
        if (Session.isLoggedIn()) {
            String userId = Session.getUserId();
            System.out.println("User ID from Session: " + userId);
        } else {
            System.out.println("User is not logged in.");
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
        OnLeave = new javax.swing.JPanel();
        txtLeave = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        btnProfile = new javax.swing.JButton();
        roleLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        empName1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        btn4 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        UnlockAcc = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        TotalEmployee = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        UNLOCKA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnLeave.setBackground(new java.awt.Color(255, 255, 255));
        OnLeave.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 204, 204)));

        txtLeave.setBackground(new java.awt.Color(102, 102, 102));
        txtLeave.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        txtLeave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/media/1.png"))); // NOI18N

        javax.swing.GroupLayout OnLeaveLayout = new javax.swing.GroupLayout(OnLeave);
        OnLeave.setLayout(OnLeaveLayout);
        OnLeaveLayout.setHorizontalGroup(
            OnLeaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OnLeaveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLeave)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        OnLeaveLayout.setVerticalGroup(
            OnLeaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OnLeaveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLeave)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        mainPanel.add(OnLeave, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 150, 90));

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
        sidePanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 130, 50));

        jButton2.setText("Attendance");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 130, 50));

        jButton3.setText("Log Out");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 130, 50));

        jButton4.setText("Announcements");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 130, 50));

        jButton5.setText("Dashboard");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 130, 50));

        empName1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        empName1.setForeground(new java.awt.Color(255, 255, 255));
        empName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empName1.setText("EmpName");
        empName1.setToolTipText("");
        sidePanel.add(empName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

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

        btn4.setBackground(new java.awt.Color(255, 204, 204));
        btn4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btn4.setText("History Changes");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        mainPanel.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 240, 140));

        btn1.setBackground(new java.awt.Color(255, 204, 204));
        btn1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btn1.setText("Lists");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        mainPanel.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 240, 120));

        btn2.setBackground(new java.awt.Color(255, 204, 204));
        btn2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btn2.setText("Unlock Accounts");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        mainPanel.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 240, 120));

        btn3.setBackground(new java.awt.Color(255, 204, 204));
        btn3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btn3.setText("Create Announcement");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        mainPanel.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, 240, 140));

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("On Leave");
        mainPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 180, -1));

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Unlock now");
        mainPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 180, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 204, 204)));

        UnlockAcc.setBackground(new java.awt.Color(102, 102, 102));
        UnlockAcc.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        UnlockAcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/media/3.png"))); // NOI18N
        UnlockAcc.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UnlockAcc, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UnlockAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 140, 90));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 204, 204)));

        TotalEmployee.setBackground(new java.awt.Color(102, 102, 102));
        TotalEmployee.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        TotalEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/media/4.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TotalEmployee)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(TotalEmployee)
                .addContainerGap())
        );

        mainPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 150, 90));

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Employees");
        mainPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 180, -1));
        mainPanel.add(UNLOCKA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 60, 40));

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

    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new leaveManagement.ApplyLeave().setVisible(true);
            }
        });  
    this.dispose();     // TODO add your handling code here:

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

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
      
         adminManagement.Logs.Logs log= new adminManagement.Logs.Logs();
log.setVisible(true);
this.dispose();
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        
        adminManagement.List.List list = new adminManagement.List.List();
list.setVisible(true);
this.dispose();
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        
         adminManagement.Unlock.UnlockUser unlockuser = new adminManagement.Unlock.UnlockUser();
unlockuser.setVisible(true);
this.dispose();
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
  
        adminManagement.Annoucement.AnnoucementDada AnnoucementData = new adminManagement.Annoucement.AnnoucementDada();
AnnoucementData.setVisible(true);
this.dispose();
    }//GEN-LAST:event_btn3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel OnLeave;
    private javax.swing.JLabel TotalEmployee;
    private javax.swing.JLabel UNLOCKA;
    private javax.swing.JLabel UnlockAcc;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btnProfile;
    private javax.swing.JLabel empName1;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel txtLeave;
    // End of variables declaration//GEN-END:variables
}
