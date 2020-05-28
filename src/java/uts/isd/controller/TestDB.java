//package uts.isd.controller;
//
//import java.sql.*;
//
//import java.util.*;
//
//import java.util.logging.*;
//import uts.isd.model.User;
//import uts.isd.model.dao.DBConnector;
//import uts.isd.model.dao.DBManager;
//
//public class TestDB {
//
//    private static Scanner in = new Scanner(System.in);
//    private DBConnector connector;
//    private Connection conn;
//    private DBManager db;
//
//    public static void main(String[] args) throws SQLException {
//        (new TestDB()).runQueries();
//    }
//
//    public TestDB() {
//
//        try {
//            connector = new DBConnector();
//            conn = connector.openConnection();
//            db = new DBManager(conn);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private char readChoice() {
//        System.out.print("Operation CRUDS or * to exit: ");
//        return in.nextLine().charAt(0);
//    }
//
//    private void runQueries() throws SQLException {
//        char c;
//
//        while ((c = readChoice()) != '*') {
//            switch (c) {
//                case 'C':
//                    testAdd();
//                    break;
//                case 'R':
//                    testRead();
//                    break;
//                case 'U':
//                    testUpdate();
//                    break;
//                case 'D':
//                    testDelete();
//                    break;
//                case 'S':
//                    showAll();
//                    break;
//                default:
//                    System.out.println("Unknown Command");
//                    break;
//            }
//        }
//    }
//
//
//    private void testAdd() {
//        System.out.print("User email: ");
//        String email = in.nextLine();
//        System.out.print("User name: ");
//        String name = in.nextLine();
//        System.out.print("User password: ");
//        String password = in.nextLine();
//        System.out.print("User gender: ");
//        String gender = in.nextLine();
//        System.out.print("User favorite color: ");
//        String favcol = in.nextLine();
//        System.out.print("User date of birth: ");
//        String dob = in.nextLine();
//        try {
//            db.addUser(email, name, password, gender, favcol, dob);
//        } catch (SQLException ex) {
//            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("User is added to the database");
//    }
//
//    private void testRead() throws SQLException {
//        System.out.print("User email: ");
//        String email = in.nextLine();
//        System.out.print("User password: ");
//        String password = in.nextLine();
//        User user = db.findUser(email, password);
//        if (user != null) {
//            System.out.println("User " + user.getName() + " exists in the database");
//        } else {
//            System.out.println("User does not exist.");
//        }
//    }
//
//    private void testUpdate() {
//        System.out.print("User email: ");
//        String email = in.nextLine();
//        System.out.print("User password: ");
//        String password = in.nextLine();
//
//        try {
//            if (db.checkUser(email, password)) {
//                System.out.print("User name: ");
//                String name = in.nextLine();
//                System.out.print("User date of birth: ");
//                String dob = in.nextLine();
//                db.updateUser(email, name, password,dob);
//            } else {
//                System.out.println("User does not exist.");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private void testDelete() {
//        System.out.print("User email: ");
//        String email = in.nextLine();
//        System.out.print("User password: ");
//        String password = in.nextLine();
//
//        try {
//            if (db.checkUser(email, password)) {
//                db.deleteUser(email);
//            } else {
//                System.out.println("User does not exist.");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private void showAll() {
//        try {
//            ArrayList<User> users = db.fetchAll();
//            System.out.println("USERS TABLE: ");
//            users.stream().forEach((user) -> {
//                System.out.printf("%-10s %-20s %-10s %-10s %-10s %-10s \n", user.getEmail(), user.getName(), user.getPassword(), user.getGender(),user.getFavcol(),user.getDob());
//            });
//            System.out.println();
//        } catch (SQLException ex) {
//            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//}