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
}
