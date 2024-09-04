package auth;


import javax.swing.JOptionPane;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Yeong Huey Yee
 */
public class Create extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public Create() {
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
        btnLogin1 = new javax.swing.JButton();
        txtAnswer = new javax.swing.JTextField();
        SQbox = new javax.swing.JComboBox<>();
        BackBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(119, 136, 153));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Security Q!");
        Header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 218, -1));

        mainPanel.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 90));

        hrUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hrUsername.setText("Security Question :");
        mainPanel.add(hrUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 260, 20));

        hrPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hrPassword.setText("Answer :");
        mainPanel.add(hrPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 260, 20));

        btnLogin1.setBackground(new java.awt.Color(119, 136, 154));
        btnLogin1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin1.setText("Set");
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });
        mainPanel.add(btnLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 100, 40));
        mainPanel.add(txtAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 300, 30));

        SQbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What city were you born in?", "Where is your hometown?", "What is your favorite hobby", "What is the name of your first pet?", "What is your mother's name?", "What is your father's name?" }));
        mainPanel.add(SQbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 300, -1));

        BackBTN.setBackground(new java.awt.Color(119, 136, 154));
        BackBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackBTN.setForeground(new java.awt.Color(255, 255, 255));
        BackBTN.setText("Back");
        BackBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBTNActionPerformed(evt);
            }
        });
        mainPanel.add(BackBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 100, 40));

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

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        
        String SQ = (String) SQbox.getSelectedItem();
        String answer = txtAnswer.getText().trim();
        String username = Session.getUsername();
        String userId = Session.getUserId();
        String email="";
        String phone = "";
  
    

    try (FileReader fr = new FileReader("usertxt.txt");
     Scanner reader = new Scanner(fr)) {
    while (reader.hasNextLine()) {
        String line = reader.nextLine();
        String[] parts = line.split(",");

        if (parts.length >= 15&& parts[0].trim().equals(userId)) { 
            phone = parts[6].trim();
            email = parts[10].trim();
            break;
            // Log information for debugging
        }
    }
} catch (FileNotFoundException ex) {
    // Create the file if it does not exist
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("security.txt", true))) {
        // Initialize the file with some default content, if needed
    } catch (IOException e) {
        System.err.println("Error creating security.txt: " + e.getMessage());
    }
} catch (IOException ex) {
    System.err.println("Error reading security.txt: " + ex.getMessage());
    Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
}

try (BufferedWriter bw = new BufferedWriter(new FileWriter("security.txt", true))) {
    bw.write(userId + "," + username + "," + phone + "," + email + "," + SQ + "," + answer + "\n");
    JOptionPane.showMessageDialog(null, "Security question answered successfully! Your information has been recorded.");
} catch (IOException e) {
    System.err.println("Error writing to security.txt: " + e.getMessage());
}  
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void BackBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBTNActionPerformed
        // TODO add your handling code here:
      

    }//GEN-LAST:event_BackBTNActionPerformed

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
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Create().setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBTN;
    private javax.swing.JPanel Header;
    private javax.swing.JComboBox<String> SQbox;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JLabel hrPassword;
    private javax.swing.JLabel hrUsername;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtAnswer;
    // End of variables declaration//GEN-END:variables
}
