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
    
//    public ArrayList<Device> fetchAll() throws SQLException {
//        
//        String fetch = "select * from Devices";
//        ResultSet rs = st.executeQuery(fetch);
//        ArrayList<Device> temp = new ArrayList();
//
//        while (rs.next()) {
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            double price = rs.getDouble(3);
//            String type = rs.getString(4);
//            int stock = rs.getInt(5);
//            temp.add(new Device(id, name, price, type, stock));
//        }
//        return temp;
//    }
    
    
    public ArrayList<Device> findDevices(String name, String type) throws SQLException {

        String fetch = "SELECT * FROM IOTUSER.DEVICES WHERE NAME ='" + name + "'" + "AND TYPE ='" + type + "'";
        
//        if (name == null && type != null) {
//            fetch = "SELECT * FROM IOTUSER.DEVICES WHERE TYPE ='" + type + "'";
//        } else if (name != null && type == null) {
//            fetch = "SELECT * FROM IOTUSER.DEVICES WHERE NAME ='" + name + "'";
//        } else if (name == null && type == null) {
//            fetch = "SELECT * FROM IOTUSER.DEVICES";
//        }
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
}
