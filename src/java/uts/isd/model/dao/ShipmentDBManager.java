package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;
import uts.isd.model.User;

/**
 *
 * @author webdevelopacc
 */
public class ShipmentDBManager {


    private Statement st;

    public ShipmentDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

//    public void addShipmentDetail(String addressLine, String suburb, String state, int postcode) throws SQLException {                    
//        st.executeUpdate("INSERT INTO IOTUSER.ShipmentDetail(addressLine2, suburb, state, postcode) VALUES('" + addressLine1 + "'," + addressLine2 + ",'" + suburb + "'," + state  + "'," + postcode + ")");
//    }
//    
//    

    
   

    }
    

