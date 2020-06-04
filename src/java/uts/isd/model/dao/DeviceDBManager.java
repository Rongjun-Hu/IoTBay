package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Device;
/**
 *
 * @author apple
 */
public class DeviceDBManager {
    
    private Statement st;

    public DeviceDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    public void createDevice(String name, double price, String type, int stock) throws SQLException {                    
        st.executeUpdate("INSERT INTO IOTUSER.DEVICES(NAME, PRICE, TYPE, STOCK) VALUES('" + name + "'," + price + ",'" + type + "'," + stock + ")");
    }
    
    
    public ArrayList<Device> findDevices(String name, String type) throws SQLException {

        String fetch = "SELECT * FROM IOTUSER.DEVICES WHERE NAME ='" + name + "'" + "AND TYPE ='" + type + "'";
        if (name.equals("") && !type.equals("")) {
            fetch = "SELECT * FROM IOTUSER.DEVICES WHERE TYPE ='" + type + "'";
        } else if (!name.equals("") && type.equals("")) {
            fetch = "SELECT * FROM IOTUSER.DEVICES WHERE NAME ='" + name + "'";
        } else if (name.equals("") && type.equals("")) {
            fetch = "SELECT * FROM IOTUSER.DEVICES";
        }
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Device> temp = new ArrayList();
        
        while (rs.next()) {
            int id = rs.getInt(1);
            String nam = rs.getString(2);
            double price = rs.getDouble(3);
            String typ = rs.getString(4);
            int stock = rs.getInt(5);
            temp.add(new Device(id, nam, price, typ, stock));
        }
        return temp;
    }
    
//    public Device findDevice(String id) throws SQLException {
//        String fetch = "SELECT * FROM IOTUSER.DEVICES WHERE ID='" + id + "'";
//        ResultSet rs = st.executeQuery(fetch);
//        
//        while (rs.next()) {
//            String name = rs.getString(2);
//            double price = rs.getDouble(3);
//            String type = rs.getString(4);
//            int stock = rs.getInt(5);
//            return new Device(id, name, price, type, stock);
//        }
//        return null;
//    }
    
    public void updateDevice(int id, String name, double price, String type, int stock) throws SQLException { 
        st.executeUpdate("UPDATE IOTUSER.DEVICES SET NAME ='" +name+ "',PRICE =" +price+ ",TYPE ='" +type+ "',STOCK =" +stock+ "WHERE ID =" +id);
    }

    public void deleteDevice(int id) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.DEVICES WHERE ID =" + id);
    }
    
    public boolean idExist(int id) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT ID FROM DEVICES");
        while (rs.next()) {
            if (id == rs.getInt(1)) {
                return true;
            }
        }
        return false;
    }
    
}
