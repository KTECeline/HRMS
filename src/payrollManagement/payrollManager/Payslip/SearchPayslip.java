package payrollManagement.payrollManager.Payslip;

import payrollManagement.payrollManager.Create.SearchUser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Hui Nan
 */

public class SearchPayslip extends javax.swing.JFrame {

    /**
     * Creates new form Payslip
     */
    public SearchPayslip() {
        initComponents();
        loadTableData();
        
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
    }
    
    private void loadTableData() {
        String filePath = "payroll.txt";
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String[] columnsName = {"Payroll ID", "Employee ID", "Employee Name", "Year", "Month"};
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setColumnIdentifiers(columnsName);

            model.setRowCount(0);

            String line;
            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(",");
                if (dataRow.length >= 5) { 
                    String[] selectedData = {dataRow[0], dataRow[1], dataRow[2], dataRow[3], dataRow[4]}; 
                    model.addRow(selectedData); 
                }
            }

         } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Payslip.TextFileDataToJTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        headerPanel = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        box1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        searchPicture1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setToolTipText("");
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerPanel.setBackground(new java.awt.Color(128, 128, 128));
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("PAYSLIP");
        header.setToolTipText("");
        headerPanel.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 535, -1));

        mainPanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 50));

        title2.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 0, 0));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title2.setText("Generate Payslip");
        mainPanel.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 190, 50));

        box1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        searchPicture1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollManagement/Images/Search.png"))); // NOI18N

        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Search");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Payroll ID", "Employee ID", "Employee Name", "Year", "Month" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout box1Layout = new javax.swing.GroupLayout(box1);
        box1.setLayout(box1Layout);
        box1Layout.setHorizontalGroup(
            box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(box1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(box1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(searchPicture1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel21)
                .addGap(14, 14, 14)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        box1Layout.setVerticalGroup(
            box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(box1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchPicture1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(box1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(box1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        mainPanel.add(box1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 890, 390));

        btnExit.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        mainPanel.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, -1, 30));

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

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        ui.dashboard.BackButton backButton = new ui.dashboard.BackButton();
        backButton.navigateBasedOnRole();
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       String searchText = btnSearch.getText().trim().toLowerCase(); 
        String filePath = "payroll.txt";
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String[] columnsName = {"Payroll ID", "Employee ID", "Employee Name", "Year", "Month"};
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setColumnIdentifiers(columnsName);

            model.setRowCount(0);

            String line;
            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(",");
                if (dataRow.length >= 5) { 
                    String payrollid = dataRow[0].toLowerCase();
                    String employeeid = dataRow[1].toLowerCase();
                    String employeename = dataRow[2].toLowerCase();
                    String year = dataRow[3].toLowerCase();
                    String month = dataRow[4].toLowerCase();

                    if (payrollid.contains(searchText) || employeeid.contains(searchText) || employeename.contains(searchText) || year.contains(searchText) || month.contains(searchText)) {
                        String[] selectedData = {dataRow[0], dataRow[1], dataRow[2], dataRow[3], dataRow[4]};
                        model.addRow(selectedData);
                    }
                }
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(SearchPayslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed
    
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {                                     
        int selectedRow = table.getSelectedRow(); 
    
        String payrollID = table.getValueAt(selectedRow, 0).toString(); 

        String filePath = "payroll.txt";
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(",");
   
                if (dataRow[0].equals(payrollID)) {
                    String empID = dataRow[1]; 
                    String empName = dataRow[2]; 
                    String bankName = dataRow[20]; 
                    String bankAccount= dataRow[21]; 
                    String year = dataRow[3]; 
                    String month = dataRow[4];  
                    String bSalary = dataRow[5]; 
                    String allowance = dataRow[6];
                    String ot = dataRow[7]; 
                    String latePen = dataRow[8];
                    String gSalary = dataRow[9]; 
                    String yeeEPF = dataRow[10]; 
                    String yeeSosco = dataRow[11]; 
                    String yeeEIS = dataRow[12]; 
                    String yeePCB = dataRow[13];
                    String yeeTDeductions = dataRow[14];
                    String yeeNSalary = dataRow[15];
                    String yerEPF = dataRow[16];
                    String yerSosco = dataRow[17];
                    String yerEIS = dataRow[18];
                    String yerCon = dataRow[19];

                    Payslip payslipForm = new Payslip();
                    payslipForm.setLabelValues(empID, empName, bankName, bankAccount, year, month, bSalary, allowance, ot, latePen, gSalary, 
                                               yeeEPF, yeeSosco, yeeEIS, yeePCB, yeeTDeductions, yeeNSalary,
                                               yerEPF, yerSosco, yerEIS, yerCon);
                    payslipForm.setVisible(true);
                    this.dispose();
                }
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Payslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String searchText = btnSearch.getText().trim().toLowerCase();
        String searchCriteria = (String) jComboBox1.getSelectedItem(); 
        String filePath = "payroll.txt";
        File file = new File(filePath);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String[] columnsName = {"Payroll ID", "Employee ID", "Employee Name", "Year", "Month"};
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setColumnIdentifiers(columnsName);
            model.setRowCount(0);

            String line;
            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(",");
                if (dataRow.length >= 5) { 
                    String payrollid = dataRow[0].toLowerCase();
                    String employeeid = dataRow[1].toLowerCase();
                    String employeename = dataRow[2].toLowerCase();
                    String year = dataRow[3].toLowerCase();
                    String month = dataRow[4].toLowerCase();
                    
                    boolean match = false;

                    switch (searchCriteria) {
                        case "Payroll ID":
                            match = payrollid.contains(searchText);
                            break;
                        case "Employee ID":
                            match = employeeid.contains(searchText);
                            break;
                        case "Employee Name":
                            match = employeename.contains(searchText);
                            break;
                        case "Year":
                            match = year.contains(searchText);
                            break;
                        case "Month":
                            match = month.contains(searchText);
                            break;
                    }

                    if (match) {
                        String[] selectedData = {dataRow[0], dataRow[1], dataRow[2], dataRow[3], dataRow[4]};
                        model.addRow(selectedData); 
                    }
                }
            }

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(SearchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(SearchPayslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchPayslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchPayslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchPayslip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SearchPayslip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel box1;
    private javax.swing.JButton btnExit;
    private javax.swing.JTextField btnSearch;
    private javax.swing.JLabel header;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel searchPicture1;
    private javax.swing.JTable table;
    private javax.swing.JLabel title2;
    // End of variables declaration//GEN-END:variables
    
    private static class TextFileDataToJTable {

        public TextFileDataToJTable() {
        }
    }
}