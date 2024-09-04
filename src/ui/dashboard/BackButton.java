package ui.dashboard;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import auth.Session;

/**
 *
 * @author Hui Nan
 */

public class BackButton {
    public void navigateBasedOnRole() {
        if (Session.isLoggedIn()) {
            String role = Session.getRole(); 
            System.out.println("User Role: " + role);

            switch (role) {
                case "Admin":
                    AdminDashboard adminDashboard = new AdminDashboard();
                    adminDashboard.setVisible(true);
                    break;
                case "HR Officer":
                    HRDashboard hrDashboard = new HRDashboard();
                    hrDashboard.setVisible(true);
                    break;
                case "Payroll Officer":
                    PayrollDashboard payrollDashboard = new PayrollDashboard();
                    payrollDashboard.setVisible(true);
                    break;
                case "Department Manager":
                    ManagerDashboard managerDashboard = new ManagerDashboard();
                    managerDashboard.setVisible(true);
                    break;
                case "Employee":
                    EmployeeDashboard employeeDashboard = new EmployeeDashboard();
                    employeeDashboard.setVisible(true);
                    break;
                default:
                    System.out.println("Unknown role: " + role);
                    break;
            }
        } else {
            System.out.println("User is not logged in.");
        }
    }
}