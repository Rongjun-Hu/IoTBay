package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Order;
/**
 *
 * @author apple
 */
public class OrderDBManager {
    
    private Statement st;

    public OrderDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    public Order createOrder(String email, int deviceId, String orderDate, int amount, int status) throws SQLException {                    
        st.executeUpdate("INSERT INTO IOTUSER.ORDERS(EMAIL, DEVICEID, ORDERDATE, AMOUNT, STATUS) VALUES('" + email + "'," + deviceId + ",'" + orderDate + "'," + amount + "," + status + ")");
        String fetch = "SELECT MAX(ORDERID) FROM IOTUSER.ORDERS";
        ResultSet rs = st.executeQuery(fetch);
         while (rs.next()) {
            int orderId = rs.getInt(1);
            return new Order(orderId, email, deviceId, orderDate, amount, status);
        }
        return null;
    }
    
    
    public ArrayList<Order> findOrders(String order, String eMail, String orderdate, int orderstatus) throws SQLException {
        int orderID = 1;
        if (!order.equals("")){
            orderID = Integer.parseInt(order);}
        else {
            orderID = 0;
        }
        if (orderstatus == 0){
        String fetch = "SELECT * FROM IOTUSER.ORDERS WHERE ORDERID =" + orderID + " AND ORDERDATE ='" + orderdate + "' AND STATUS =" + orderstatus;
        if (order.equals("") && orderdate.equals("")) {
            fetch = "SELECT * FROM IOTUSER.ORDERS WHERE EMAIL ='" + eMail + "' AND STATUS =" + orderstatus;
        }
        else if (!order.equals("") && orderdate.equals("")){
            fetch = "SELECT * FROM IOTUSER.ORDERS WHERE ORDERID =" + orderID + " AND STATUS =" + orderstatus; 
        }
        else if (order.equals("") && !orderdate.equals("")){
            fetch = "SELECT * FROM IOTUSER.ORDERS WHERE ORDERID ='" + orderdate + "' AND STATUS =" + orderstatus;  
        } 
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()) {
            int orderId = rs.getInt(1);
            String email = rs.getString(2);
            int deviceId = rs.getInt(3);
            String orderDate = rs.getString(4);
            int amount = rs.getInt(5);
            int status = rs.getInt(6);
            temp.add(new Order(orderId, email, deviceId, orderDate, amount, status));
        }
        return temp;
        } else { 
            String fetch = "SELECT * FROM IOTUSER.ORDERS WHERE ORDERID =" + orderID + " AND ORDERDATE ='" + orderdate + "' AND STATUS =" + orderstatus;
        if (order.equals("") && orderdate.equals("")) {
            fetch = "SELECT * FROM IOTUSER.ORDERS  WHERE EMAIL ='" + eMail + "' AND STATUS =" + orderstatus;
        }
        else if (!order.equals("") && orderdate.equals("")){
            fetch = "SELECT * FROM IOTUSER.ORDERS WHERE ORDERID =" + orderID + " AND STATUS =" + orderstatus; 
        }
        else if (order.equals("") && !orderdate.equals("")){
            fetch = "SELECT * FROM IOTUSER.ORDERS WHERE ORDERID ='" + orderdate + "' AND STATUS =" + orderstatus;  
        } 
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Order> temp = new ArrayList();
        
        while (rs.next()) {
            int orderId = rs.getInt(1);
            String email = rs.getString(2);
            int deviceId = rs.getInt(3);
            String orderDate = rs.getString(4);
            int amount = rs.getInt(5);
            int status = rs.getInt(6);
            temp.add(new Order(orderId, email, deviceId, orderDate, amount, status));
        }
        return temp;
    }
    }
     public Order findOrder(int orderID) throws SQLException {
        String order = Integer.toString(orderID);
        String fetch = "SELECT * FROM IOTUSER.ORDERS WHERE ORDERID =" + orderID;
        ResultSet rs = st.executeQuery(fetch);
         while (rs.next()) {
            int orderId = rs.getInt(1);
            String email = rs.getString(2);
            int deviceId = rs.getInt(3);
            String orderDate = rs.getString(4);
            int amount = rs.getInt(5);
            int status = rs.getInt(6);
            return new Order(orderId, email, deviceId, orderDate, amount, status);
        }
        return null;
     }
    
    public void updateOrder(int orderId, String email, String orderDate, int amount, int status) throws SQLException { 
        st.executeUpdate("UPDATE IOTUSER.ORDERS SET EMAIL ='" + email + "',ORDERDATE ='" + orderDate + "',AMOUNT =" + amount + ",STATUS ="  + status + " WHERE ORDERID =" +orderId);
    }

    public void deleteOrder(int orderId) throws SQLException {
        int status = 4;
        st.executeUpdate("UPDATE FROM IOTUSER.ORDERS SET STATUS=" + status + " WHERE ORDERID =" + orderId);
    }
    
    public boolean orderIdExist(int orderId) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT ORDERID FROM ORDERS");
        while (rs.next()) {
            if (orderId == rs.getInt(1)) {
                return true;
            }
        }
        return false;
    }
}
