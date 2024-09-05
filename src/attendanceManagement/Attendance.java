/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package attendanceManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import auth.Session;
import java.time.LocalDateTime;
/**
 *
 * @author leopa
 */
public class Attendance extends javax.swing.JFrame {
   
    private DefaultTableModel tableModel;
    private JLabel runningClockLabel = new javax.swing.JLabel();
    private String userId;
    private Map<String, String[]> attendanceData;
    
    /**
     * Creates new form Attendance
     */
    public Attendance() {
        initComponents();
        String username = Session.getUsername();
        String role = Session.getRole();
        
        empName6.setText(username);
        roleLabel.setText(role);
        
        customInitComponents(); // Custom method to initialize additional components
        this.setVisible(true);
        this.pack();
        System.out.println("Attendance system initialized");
    }
    
    
    private void customInitComponents() {
        if (Session.isLoggedIn()) {
            userId = Session.getUserId();
            System.out.println("User ID from Session: " + userId);
        } else {
            System.out.println("User is not logged in.");
        }

        // Initialize attendance data map
        attendanceData = new HashMap<>();
        loadAttendanceData();

        // Setup table model
        String[] columnNames = {"AttendanceId", "UserId", "ClockIn", "ClockOut", "TotalTime", "Overtime", "Undertime", "Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        jTable1.setModel(tableModel);

        runningClockLabel = new javax.swing.JLabel();
        runningClockLabel.setFont(new Font("Arial", Font.BOLD, 35));
        runningClockLabel.setForeground(new Color(255, 192, 203)); 
        runningClockLabel.setText("00:00:00"); // Set initial text to a default value
        jPanel3.add(runningClockLabel); // Add runningClockLabel to jPanel4
        jPanel3.setLayout(new FlowLayout()); // Set the layout of jPanel4 to FlowLayout

        // Add action listeners for buttons
        ClockIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClockIn();
            }
        });

        ClockOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClockOut();
            }
        });

        // Show initial data
        displayUserAttendance();

        // Update running clock every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRunningClock();
            }
        });
        timer.start();
    }

    private void updateRunningClock() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"); 
    // Use "MM/dd/yyyy" for the date, "hh" for 12-hour format, and "a" for AM/PM
    String currentTime = LocalDateTime.now().format(formatter);
    runningClockLabel.setText(currentTime); // Update the text of runningClockLabel
}

    private void handleClockIn() {
        String today = LocalDate.now().toString();

        // Check if already clocked in today
        if (attendanceData.containsKey(userId) && attendanceData.get(userId)[6].equals(today)) {
            JOptionPane.showMessageDialog(this, "Already clocked in today.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String clockInTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        String attendanceId = generateAttendanceId();
        attendanceData.put(userId, new String[]{attendanceId, clockInTime, "", "", "", "", today});

        saveAttendanceData();
        displayUserAttendance();
        ClockIn.setEnabled(false); // Disable clock-in button after clocking in
        ClockOut.setEnabled(true);
    }

    private void handleClockOut() {
        String today = LocalDate.now().toString();

        // Check if already clocked out today
        if (attendanceData.containsKey(userId) && attendanceData.get(userId)[6].equals(today) && !attendanceData.get(userId)[2].isEmpty()) {
            JOptionPane.showMessageDialog(this, "Already clocked out today.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String clockOutTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
            String[] data = attendanceData.get(userId);

            if (data != null && data.length >= 4) {
                data[2] = clockOutTime;
                String totalTime = calculateTotalTime(data[1], clockOutTime);
                String overtime = calculateOvertime(totalTime);
                String undertime = calculateUndertime(totalTime);
                data[3] = totalTime;
                data[4] = overtime;
                data[5] = undertime;
                saveAttendanceData();
                displayUserAttendance();
                ClockIn.setEnabled(true);
                ClockOut.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid data for user. Please check attendance data.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayUserAttendance() {
    SwingUtilities.invokeLater(() -> {
        // Clear existing data
        tableModel.setRowCount(0);

        // Loop through all entries in attendanceData and display data for the current user only
        if (attendanceData.containsKey(userId)) {
            String[] data = attendanceData.get(userId);
            tableModel.addRow(new Object[]{data[0], userId, data[1], data[2], data[3], data[4], data[5], data[6]});
        } else {
            System.out.println("No attendance data found for user:" + userId);
        }
    });
}




    private String calculateTotalTime(String clockIn, String clockOut) {
        if (clockIn.isEmpty() || clockOut.isEmpty()) {
            return "00:00";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime clockInTime = LocalTime.parse(clockIn, formatter);
        LocalTime clockOutTime = LocalTime.parse(clockOut, formatter);
        Duration duration = Duration.between(clockInTime, clockOutTime);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        return String.format("%02d:%02d", hours, minutes);
    }

    private String calculateOvertime(String totalTime) {
        String[] parts = totalTime.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        int totalMinutesWorked = (hours * 60) + minutes;
        int standardWorkMinutes = 8 * 60;

        if (totalMinutesWorked > standardWorkMinutes) {
            int overtimeMinutes = totalMinutesWorked - standardWorkMinutes;
            return String.format("%02d:%02d", overtimeMinutes / 60, overtimeMinutes % 60);
        } else {
            return "00:00";
        }
    }

    private String calculateUndertime(String totalTime) {
        String[] parts = totalTime.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        int totalMinutesWorked = (hours * 60) + minutes;
        int standardWorkMinutes = 8 * 60;

        if (totalMinutesWorked < standardWorkMinutes) {
            int undertimeMinutes = standardWorkMinutes - totalMinutesWorked;
            return String.format("%02d:%02d", undertimeMinutes / 60, undertimeMinutes % 60);
        } else {
            return "00:00";
        }
    }

    private String generateAttendanceId() {
        int maxId = 0;

        for (String[] data : attendanceData.values()) {
            String id = data[0];
            if (id.startsWith("AT")) {
                int num = Integer.parseInt(id.substring(2));
                if (num > maxId) {
                    maxId = num;
                }
            }
        }

        maxId++;
        return String.format("AT%04d", maxId);
    }

    private void loadAttendanceData() {
        try (BufferedReader br = new BufferedReader(new FileReader("attendance.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    attendanceData.put(data[1], new String[]{data[0], data[2], data[3], data[4], data[5], data[6], data[7]});
                } else {
                    System.out.println("Invalid data format in attendance.txt: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAttendanceData() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("attendance.txt"))) {
        for (Map.Entry<String, String[]> entry : attendanceData.entrySet()) {
            String userId = entry.getKey();
            String[] data = entry.getValue();
            // Write data in the correct order
            bw.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                data[0], // AttendanceId
                userId,  // UserId
                data[1], // ClockIn
                data[2], // ClockOut
                data[3], // TotalTime
                data[4], // Overtime
                data[5], // Undertime
                data[6]  // Date
            ));
            bw.newLine();
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

        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ClockIn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ClockOut = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Monthly = new javax.swing.JButton();
        Annual = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TimeIn = new javax.swing.JLabel();
        empName6 = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnProfile = new javax.swing.JButton();
        roleLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(128, 128, 128));

        header.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        header.setText("Attendance");
        header.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(header)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(header)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 810, 50));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        ClockIn.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        ClockIn.setText("CLOCK IN");
        ClockIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClockInActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "AttendanceId", "UserId", "ClockIn", "ClockOut", "TotalTime", "Overtime", "Undertime", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        ClockOut.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        ClockOut.setText("CLOCK OUT");
        ClockOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClockOutActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        Monthly.setText("Monthly Report");
        Monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthlyActionPerformed(evt);
            }
        });

        Annual.setText("Annual Report");
        Annual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnualActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setText("Today's Attendance Information");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(ClockIn, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ClockOut, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(Monthly)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Annual)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(191, 191, 191))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClockIn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClockOut, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Monthly, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Annual, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 690, 460));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 450, -1));

        empName6.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        empName6.setForeground(new java.awt.Color(255, 255, 255));
        empName6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empName6.setText("EmpName");
        empName6.setToolTipText("");
        getContentPane().add(empName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

        sidePanel.setBackground(new java.awt.Color(128, 128, 128));
        sidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        sidePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 100));

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
        roleLabel.setForeground(new java.awt.Color(255, 255, 255));
        roleLabel.setText("Admin");
        sidePanel.add(roleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jButton1.setText("Dashboard");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 130, 50));

        jButton2.setText("Attendance");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 130, 50));

        jButton3.setText("Log Out");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 130, 50));

        jButton4.setText("Leave");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 130, 50));

        jButton5.setText("Annoucement");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        sidePanel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 130, 50));

        getContentPane().add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 600));

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
        ui.dashboard.BackButton backbutton= new ui.dashboard.BackButton();
        backbutton.navigateBasedOnRole();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        leaveManagement.ApplyLeave leave = new leaveManagement.ApplyLeave();
leave.setVisible(true);
this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ClockInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClockInActionPerformed
        // TODO add your handling code here:
       

    }//GEN-LAST:event_ClockInActionPerformed

    private void ClockOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClockOutActionPerformed
        // TODO add your handling code here:
       

    }//GEN-LAST:event_ClockOutActionPerformed

    private void MonthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthlyActionPerformed
        
   
    attendanceManagement.Monthly monthly = new attendanceManagement.Monthly();
monthly.setVisible(true);
this.dispose();
    }//GEN-LAST:event_MonthlyActionPerformed

    private void AnnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnualActionPerformed
        // TODO add your handling code here:

        attendanceManagement.Annual frame = new attendanceManagement.Annual();
frame.setVisible(true);
this.dispose();
    }//GEN-LAST:event_AnnualActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        adminManagement.DisplayA.DisplayAnnoucement diplayAnnoucement = new adminManagement.DisplayA.DisplayAnnoucement();
diplayAnnoucement.setVisible(true);
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
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annual;
    private javax.swing.JButton ClockIn;
    private javax.swing.JButton ClockOut;
    private javax.swing.JButton Monthly;
    private javax.swing.JLabel TimeIn;
    private javax.swing.JButton btnProfile;
    private javax.swing.JLabel empName6;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
