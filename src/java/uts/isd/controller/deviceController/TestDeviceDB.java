package uts.isd.controller.deviceController;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import uts.isd.model.Device;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DeviceDBManager;


/**
 *
 * @author apple
 */
public class TestDeviceDB {
    
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DeviceDBManager db;

        
    public static void main(String[] args) throws SQLException {
         (new TestDeviceDB()).runQueries();
    }

    public TestDeviceDB() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DeviceDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDeviceDB.class.getName()).log(Level.SEVERE, null, ex);
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
        System.out.print("Device name: ");
        String name = in.nextLine();
        System.out.print("Device price: ");
        double price = in.nextDouble();
        in.nextLine();
        System.out.print("Device type: ");
        String type = in.nextLine();
        System.out.print("Device stock: ");
        int stock = in.nextInt();
        in.nextLine(); 
        try {
            db.createDevice(name, price, type, stock);
        } catch (SQLException ex) {
            Logger.getLogger(TestDeviceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Device is added to the database.");
    }
        
    private void testRead() throws SQLException {
        System.out.print("Device name condition (not composory): ");
        String deviceName = in.nextLine();
        System.out.print("Device type condition (not composory): ");
        String type = in.nextLine();
        
        ArrayList<Device> devices = db.findDevices(deviceName, type);
        System.out.println(devices.size() + " device matches.");
    }
            
    private void testUpdate() {
        System.out.print("Device id: ");
        int id = in.nextInt();
        in.nextLine(); 
        try {
            if (db.idExist(id)) {
                System.out.print("Device new name: ");
                String name = in.nextLine();
                System.out.print("Device new price: ");
                double price = in.nextDouble();
                in.nextLine();
                System.out.print("Device new type: ");
                String type = in.nextLine();
                System.out.print("Device new stock: ");
                int stock = in.nextInt();
                in.nextLine(); 
                
                db.updateDevice(id, name, price, type, stock);
                System.out.println("Device Id: " + id + " was updated.");
            } else {
                System.out.println("Device does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDeviceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    private void testDelete() {       
        System.out.print("Device id: ");
        int id = in.nextInt();
        in.nextLine(); 
        try {
            if (db.idExist(id)) {
                db.deleteDevice(id);
                System.out.println("Device Id: " + id + " was deleted.");
            } else {
                System.out.println("Device does not exist.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestDeviceDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
