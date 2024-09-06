package payrollManagement.payrollManager.Record;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Hui Nan
 */

public class Record extends javax.swing.JFrame {

    /**
     * Creates new form Record
     */
    
    public Record() {
        initComponents();
        loadTableData(table, true); 
        loadTableData(table1, false); 
    }
    
    private void loadTableData(javax.swing.JTable table, boolean isEmployer) {
        String filePath = "payroll.txt";
        if (isEmployer) {
            loadEmployeeData(filePath, table);
        } else {
            loadEmployerData(filePath, table1);
        }
    }

    private void loadEmployeeData(String filePath, javax.swing.JTable table) {
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String[] columnsName = {"EmpID", "Name", "Year", "Month", "BSalary", "Allowance", "OT", "LPenalty", "GSalary", "EPF", "Sosco", "EIS", "Tax", "TDeduction", "NSalary"};
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setColumnIdentifiers(columnsName);

            String line;
            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(",");
                if (dataRow.length >= 16) { 
                    String[] selectedData = {dataRow[1], dataRow[2], dataRow[3], dataRow[4], dataRow[5], dataRow[6], dataRow[7], dataRow[8], dataRow[9], dataRow[10], dataRow[11], dataRow[12], dataRow[13], dataRow[14], dataRow[15]}; 
                    model.addRow(selectedData); 
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadEmployerData(String filePath, javax.swing.JTable table) {
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String[] columnsName = {"Employee ID", "Employee Name", "Year", "Month", "EPF", "Sosco", "EIS", "Net Salary"};
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setColumnIdentifiers(columnsName);
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(",");
                if (dataRow.length >= 8) { 
                    String[] selectedData = {dataRow[1], dataRow[2], dataRow[3], dataRow[4], dataRow[16], dataRow[17], dataRow[18], dataRow[19]}; 
                    model.addRow(selectedData); 
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
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
        btnSearch = new javax.swing.JTextField();
        headerPanel = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        search = new javax.swing.JLabel();
        EmpTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        title2 = new javax.swing.JLabel();
        jYeeTNetSalary = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        title = new javax.swing.JLabel();
        jYerTNetSalary = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        title1 = new javax.swing.JLabel();
        btnExit1 = new javax.swing.JButton();
        searchPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setToolTipText("");
        mainPanel.setMinimumSize(new java.awt.Dimension(940, 600));
        mainPanel.setPreferredSize(new java.awt.Dimension(940, 600));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        mainPanel.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 250, -1));

        headerPanel.setBackground(new java.awt.Color(128, 128, 128));
        headerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("PAYROLL DETAILS");
        header.setToolTipText("");
        headerPanel.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 535, -1));

        mainPanel.add(headerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 50));

        search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search.setText("Search");
        mainPanel.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        EmpTab.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 51, 51), null, null));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(table);

        title2.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 0, 0));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("Employee Payroll Details");

        jYeeTNetSalary.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jYeeTNetSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jYeeTNetSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        EmpTab.addTab("Employee", jPanel1);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table1);

        title.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        title.setForeground(new java.awt.Color(255, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Employer Payroll Details");

        jYerTNetSalary.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jYerTNetSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jYerTNetSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        EmpTab.addTab("Employer", jPanel3);

        mainPanel.add(EmpTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 870, 380));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        mainPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Employee ID", "Employee Name", "Year", "Month", "Employee Basic Salary", "Employee Allowance", "Over Time", "Late Penalty", "Gross Salary", "Employee EPF", "Employee Sosco", "Employee EIS", "Employee PCB", "Total Deduction", "Employee Net Salary", "Employer EPF", "Employer Sosco", "Employer EIS", "Employer Net Salary" }));
        mainPanel.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        title1.setFont(new java.awt.Font("Sitka Text", 3, 20)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 0, 0));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        title1.setText("Table of Payroll Details");
        mainPanel.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 340, 50));

        btnExit1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        btnExit1.setText("Exit");
        btnExit1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit1ActionPerformed(evt);
            }
        });
        mainPanel.add(btnExit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, -1, 30));

        searchPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollManagement/Images/Search.png"))); // NOI18N
        mainPanel.add(searchPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 210, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String searchText = btnSearch.getText().trim().toLowerCase();
        String filePath = "payroll.txt";
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            DefaultTableModel model;
            br.readLine();
            String[] columnsName;
            int selectedTab = EmpTab.getSelectedIndex();
            String selectedCriteria = (String) jComboBox1.getSelectedItem(); 

            if (selectedTab == 0) {
                columnsName = new String[]{"EmpID", "Name", "Year", "Month", "BSalary", "Allowance", "OT", "Penalty", "GSalary", "EPF", "Sosco", "EIS", "Tax", "TDeduction", "NSalary"};
                model = (DefaultTableModel) table.getModel();
            } else {
                columnsName = new String[]{"Employee ID", "Employee Name", "Year", "Month", "EPF", "Sosco", "EIS", "Net Salary"};
                model = (DefaultTableModel) table1.getModel();
            }

            model.setColumnIdentifiers(columnsName);
            model.setRowCount(0);

            double totalNetSalary = 0; 
            String line;

            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(",");

                if (dataRow.length >= 18) { 
                    boolean match = false;

                    switch (selectedCriteria) {
                        case "Employee ID":
                            match = dataRow[1].toLowerCase().contains(searchText);
                            break;
                        case "Employee Name":
                            match = dataRow[2].toLowerCase().contains(searchText);
                            break;
                        case "Year":
                            if (dataRow[3].toLowerCase().contains(searchText)) {
                                match = true;
                                try {
                                    double netSalary = selectedTab == 0 ? Double.parseDouble(dataRow[15]) : Double.parseDouble(dataRow[19]);
                                    totalNetSalary += netSalary;
                                } catch (NumberFormatException e) {
                                    System.err.println("Error parsing net salary: " + (selectedTab == 0 ? dataRow[15] : dataRow[19]));
                                }
                            }
                            break;
                        case "Month":
                            if (dataRow[4].toLowerCase().contains(searchText)) {
                                match = true;
                                try {
                                    double netSalary = selectedTab == 0 ? Double.parseDouble(dataRow[15]) : Double.parseDouble(dataRow[19]);
                                    totalNetSalary += netSalary;
                                } catch (NumberFormatException e) {
                                    System.err.println("Error parsing net salary: " + (selectedTab == 0 ? dataRow[15] : dataRow[19]));
                                }
                            }
                            break;
                        case "Employee Basic Salary":
                            match = selectedTab == 0 && dataRow[5].toLowerCase().contains(searchText);
                            break;
                        case "Employee Allowance":
                            match = selectedTab == 0 && dataRow[6].toLowerCase().contains(searchText);
                            break;
                        case "Over Time":
                            match = selectedTab == 0 && dataRow[7].toLowerCase().contains(searchText);
                            break;
                        case "Late Penalty":
                            match = selectedTab == 0 && dataRow[8].toLowerCase().contains(searchText);
                            break;
                        case "Gross Salary":
                            match = selectedTab == 0 && dataRow[9].toLowerCase().contains(searchText);
                            break;
                        case "Employee EPF":
                            match = selectedTab == 0 && dataRow[10].toLowerCase().contains(searchText);
                            break;
                        case "Employee Sosco":
                            match = selectedTab == 0 && dataRow[11].toLowerCase().contains(searchText);
                            break;
                        case "Employee EIS":
                            match = selectedTab == 0 && dataRow[12].toLowerCase().contains(searchText);
                            break;
                        case "Employee PCB":
                            match = selectedTab == 0 && dataRow[13].toLowerCase().contains(searchText);
                            break;
                        case "Total Deduction":
                            match = selectedTab == 0 && dataRow[14].toLowerCase().contains(searchText);
                            break;
                        case "Employee Net Salary":
                            match = selectedTab == 0 && dataRow[15].toLowerCase().contains(searchText);
                            break;
                        case "Employer EPF":
                            match = selectedTab == 1 && dataRow[16].toLowerCase().contains(searchText);
                            break;
                        case "Employer Sosco":
                            match = selectedTab == 1 && dataRow[17].toLowerCase().contains(searchText);
                            break;
                        case "Employer EIS":
                            match = selectedTab == 1 && dataRow[18].toLowerCase().contains(searchText);
                            break;
                        case "Employer Net Salary":
                            match = selectedTab == 1 && dataRow[19].toLowerCase().contains(searchText);
                            break;
                    }

                    if (match) {
                        String[] selectedData = new String[columnsName.length];
                        if (selectedTab == 0) {
                            for (int i = 0; i < columnsName.length; i++) {
                                selectedData[i] = dataRow[i + 1]; 
                            }
                        } else {
                            selectedData[0] = dataRow[1];
                            selectedData[1] = dataRow[2];
                            selectedData[2] = dataRow[3];
                            selectedData[3] = dataRow[4];
                            selectedData[4] = dataRow[16];
                            selectedData[5] = dataRow[17];
                            selectedData[6] = dataRow[18];
                            selectedData[7] = dataRow[19];
                        }
                        model.addRow(selectedData);
                    }
                }
            }
            
            String formattedTotalNetSalary = String.format("%.2f", totalNetSalary);
            if (selectedTab == 0) {
                if (selectedCriteria.equals("Year") || selectedCriteria.equals("Month")) {
                    jYeeTNetSalary.setText("Total net salary for " + searchText + " : RM" + formattedTotalNetSalary);
                }
            } else {
                if (selectedCriteria.equals("Year") || selectedCriteria.equals("Month")) {
                    jYerTNetSalary.setText("Total net salary for " + searchText + " : RM" + formattedTotalNetSalary);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        ui.dashboard.BackButton backButton = new ui.dashboard.BackButton();
        backButton.navigateBasedOnRole();
        dispose();
    }//GEN-LAST:event_btnExit1ActionPerformed
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Record().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane EmpTab;
    private javax.swing.JButton btnExit1;
    private javax.swing.JTextField btnSearch;
    private javax.swing.JLabel header;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jYeeTNetSalary;
    private javax.swing.JLabel jYerTNetSalary;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel search;
    private javax.swing.JLabel searchPicture;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    // End of variables declaration//GEN-END:variables

    private static class TextFileDataToJTable {
        public TextFileDataToJTable() {
        }
    }
}