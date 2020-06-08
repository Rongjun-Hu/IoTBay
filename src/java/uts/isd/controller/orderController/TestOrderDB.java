package uts.isd.controller.orderController;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.Order;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.OrderDBManager;


/**
 *
 * @author apple
 */
public class TestOrderDB {
    
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private OrderDBManager db;

        
    public static void main(String[] args) throws SQLException {
         (new TestOrderDB()).runQueries();
    }

    public TestOrderDB() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new OrderDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private char readChoice() {
        System.out.print("Operation CRUD or * to exit: ");
        return in.nextLine().charAt(0);    
    }
    
    private void runQueries() throws SQLException {      
        char c;
        while ((c = readChoice()) != '*') {
            switch (c) {
                case 'C':
                    testCreate();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;
                default:
                    System.out.println("Unknown Command");
                    break;
            }
        }
    }
     
    private void testCreate() {      
        System.out.print("UserEmail: ");
        String email = in.nextLine();
        System.out.print("Device ID: ");
        int deviceId = in.nextInt();
        in.nextLine(); 
        System.out.print("OrderDate: ");
        String orderDate = in.nextLine();
        System.out.print("Amount: ");
        int amount = in.nextInt();
        System.out.print("Status: ");
        int status = in.nextInt();
        in.nextLine(); 
        try {
            Order order = db.createOrder(email, deviceId, orderDate, amount, status);
            int id = order.getOrderId();
            System.out.println(id);
        } catch (SQLException ex) {
            Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Order is added to the database.");
    }
        
    private void testRead() throws SQLException {
        System.out.print("OrderID condition : ");
        String orderID = in.nextLine();
        System.out.print("OrderDate condition (yyyy-mm-dd) : ");
        String orderDate = in.nextLine();
        System.out.print("Email condition : ");
        String email = in.nextLine();
        System.out.print("Status: ");
        int status = in.nextInt();
       
        
        ArrayList<Order> orders = db.findOrders(orderID, email, orderDate, status);
        System.out.println(orders.size() + " order matches.");
    }
            
    private void testUpdate() {
        System.out.print("OrderID: ");
        int id = in.nextInt();
        System.out.print("UserEmail: ");
        String email = in.nextLine();
        in.nextLine(); 
        try {
            if (db.orderIdExist(id)) {
                System.out.print("OrderDate is set on: ");
                String orderDate = in.nextLine();
                System.out.print("Amount: ");
                int amount = in.nextInt();
                System.out.print("Status: ");
                int status = in.nextInt();
                in.nextLine(); 
                
                db.updateOrder(id, email, orderDate, amount, status);
                System.out.println("OrderID: " + id + " was updated.");
            } else {
                System.out.println("Order does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    private void testDelete() {       
        System.out.print("OrderID: ");
        int id = in.nextInt();
        in.nextLine(); 
        try {
            if (db.orderIdExist(id)) {
                db.deleteOrder(id);
                System.out.println("OrderID: " + id + " was deleted.");
            } else {
                System.out.println("Order does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
