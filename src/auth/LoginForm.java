package auth;


import javax.swing.JOptionPane;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import ui.dashboard.*;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Yeong Huey Yee
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
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
        Header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        hrUsername = new javax.swing.JLabel();
        hrPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnLogin1 = new javax.swing.JButton();
        txtPassword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(119, 136, 153));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Login Here!");
        Header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 218, -1));

        mainPanel.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 90));

        hrUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hrUsername.setText("Username :");
        mainPanel.add(hrUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 260, 20));

        hrPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hrPassword.setText("Password :");
        mainPanel.add(hrPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 260, 20));

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        mainPanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 300, 30));

        jButton1.setBackground(new java.awt.Color(242, 242, 242));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 204));
        jButton1.setText("Forgot Username/Password ?");
        jButton1.setActionCommand("Forgot Username/Password?");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        mainPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, 20));

        btnLogin1.setBackground(new java.awt.Color(119, 136, 154));
        btnLogin1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin1.setText("Login");
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });
        mainPanel.add(btnLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 230, 40));
        mainPanel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 300, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        boolean isAuthenticated = false;
        String role ="";
        
        try {
            FileReader fr = new FileReader("usertxt.txt");
            Scanner reader = new Scanner(fr);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",");

                if (parts.length >=5) { 
                    String un = parts[2].trim();
                    String pw = parts[3].trim();

                    if (username.equals(un) && password.equals(pw)) {
                        isAuthenticated = true;
                        role=parts[4].trim();
                        break;
                    }
                }
            }
            reader.close();

            if (isAuthenticated) {
                switch(role){
                    case"Admin":
                        ui.dashboard.AdminDashboard admindashboard = new ui.dashboard.AdminDashboard();
                        admindashboard.setVisible(true);
                        break;
                    case "HR Officer":
                        ui.dashboard.HRDashboard hrdashboard = new ui.dashboard.HRDashboard();
                        hrdashboard.setVisible(true);
                        break;
                    case "Department Manager":
                        ui.dashboard.ManagerDashboard managerdashboard = new ui.dashboard.ManagerDashboard();
                        managerdashboard.setVisible(true);
                        break;
                    case "Payroll Officer":
                        ui.dashboard.PayrollDashboard payrolldashboard = new ui.dashboard.PayrollDashboard();
                        payrolldashboard.setVisible(true);
                        break;
                    case "Employee":
                        ui.dashboard.EmployeeDashboard employeedashboard = new ui.dashboard.EmployeeDashboard();
                        employeedashboard.setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Unknown role:" + role);
                        break;
                }this.dispose();
            }else {
                JOptionPane.showMessageDialog(null,"Invalid Login Details");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: File not found");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

            
        
    }//GEN-LAST:event_btnLogin1ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new LoginForm().setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JLabel hrPassword;
    private javax.swing.JLabel hrUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
