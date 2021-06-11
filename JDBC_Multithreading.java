package com.bridgelabz.multithreading;

import java.sql.*;

    class JDBC_PracticeProblem extends Thread {
        public static void main(String[] args) {
            long start = System.currentTimeMillis();


            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver Loaded");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "mysql");
                System.out.println("Connection eastablished");
                PreparedStatement stmt = connection.prepareStatement("update payroll set basic_pay = ? where Emp_ref_id = ?");
                stmt.setDouble(1, 3000000);
                stmt.setInt(2, 2);
                stmt.executeUpdate();
                Statement stmt1 = connection.createStatement();
                ResultSet resultSet = stmt1.executeQuery("select * from employee");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("Emp_id") + " " + resultSet.getString("name") + " " + resultSet.getString("phone_number")
                            + " " + resultSet.getString("address") + " " + resultSet.getString("gender") + " " + resultSet.getDate("start"));
                }


            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);

            }
            JDBC_PracticeProblem jdbc = new JDBC_PracticeProblem();
           // mutlithreading_in_jdbc jdbc1 = new mutlithreading_in_jdbc();
            System.out.println( start = System.currentTimeMillis());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long stop = System.currentTimeMillis();
            System.out.println("Star to End of the Main Function takes :  " +
                    (stop - start) + "ms");
        }

        public void run() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "mysql");
                Statement stmt2 = connection.createStatement();
                ResultSet rs = stmt2.executeQuery("select * from employee");
                System.out.println("data for employee");
                while (rs.next()) {
                    System.out.println(rs.getInt("Emp_id") + rs.getString("name"));
                }

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

        }

    }


