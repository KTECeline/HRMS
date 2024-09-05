package ui.dashboard;

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Yeong Huey Yee
 */
public class EmployeeDashboard extends javax.swing.JFrame {


    public EmployeeDashboard() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        empName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnViewProfile = new javax.swing.JLabel();
        btnAttendance = new javax.swing.JButton();
        btnViewProfile2 = new javax.swing.JLabel();
        btnViewProfile3 = new javax.swing.JLabel();
        btnViewProfile1 = new javax.swing.JLabel();
        btnProfile = new javax.swing.JButton();
        btnAnnoucement = new javax.swing.JButton();
        btnLeave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(128, 128, 128));
        sidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeeManagement/image/emp (250 x 250 px).png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        sidePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 130, 100));

        empName.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        empName.setText("EmpName");
        empName.setToolTipText("");
        sidePanel.add(empName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, -1));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setText("Employee");
        sidePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        sidePanel.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 130, 50));

        mainPanel.add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 600));

        jPanel1.setBackground(new java.awt.Color(128, 128, 128));

        header.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        header.setText("EMPLOYEE MANAGEMENT SYSTEM");
        header.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(header))
        );

        mainPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 810, 50));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 2, 36)); // NOI18N
        jLabel3.setText("Welcome !");
        mainPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 190, 50));

        btnViewProfile.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        btnViewProfile.setText("Attendence");
        mainPanel.add(btnViewProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, -1, -1));

        btnAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeeManagement/image/4.png"))); // NOI18N
        btnAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceActionPerformed(evt);
            }
        });
        mainPanel.add(btnAttendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 240, 230));

        btnViewProfile2.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        btnViewProfile2.setText("Accouncement");
        mainPanel.add(btnViewProfile2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, -1, -1));

        btnViewProfile3.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        btnViewProfile3.setText("Leave");
        mainPanel.add(btnViewProfile3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, -1, -1));

        btnViewProfile1.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        btnViewProfile1.setText("Profile");
        mainPanel.add(btnViewProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeeManagement/image/1.png"))); // NOI18N
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });
        mainPanel.add(btnProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 240, 230));

        btnAnnoucement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeeManagement/image/2.png"))); // NOI18N
        btnAnnoucement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnoucementActionPerformed(evt);
            }
        });
        mainPanel.add(btnAnnoucement, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 240, 230));

        btnLeave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeeManagement/image/3.png"))); // NOI18N
        btnLeave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveActionPerformed(evt);
            }
        });
        mainPanel.add(btnLeave, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 240, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
    auth.Session.logout();
    JOptionPane.showMessageDialog(this, "You have been logged out.");
    this.dispose();
    System.exit(0);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendanceActionPerformed
        attendanceManagement.Attendance attendance = new attendanceManagement.Attendance();
        attendance.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAttendanceActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        profile.ProfileButton profileLoader = new profile.ProfileButton();
        profile.ViewProfile viewprofile = new profile.ViewProfile();
        profileLoader.onViewProfileButtonClick(viewprofile); 
        dispose();
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnAnnoucementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnoucementActionPerformed
        adminManagement.DisplayA.DisplayAnnoucement diplayAnnoucement = new adminManagement.DisplayA.DisplayAnnoucement();
        diplayAnnoucement.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAnnoucementActionPerformed

    private void btnLeaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveActionPerformed
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new leaveManagement.ApplyLeave().setVisible(true);
            }
        });  
    this.dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_btnLeaveActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new EmployeeDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnnoucement;
    private javax.swing.JButton btnAttendance;
    private javax.swing.JButton btnLeave;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnProfile;
    private javax.swing.JLabel btnViewProfile;
    private javax.swing.JLabel btnViewProfile1;
    private javax.swing.JLabel btnViewProfile2;
    private javax.swing.JLabel btnViewProfile3;
    private javax.swing.JLabel empName;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
