package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.User;

/**
 *
 * @author webdevelopacc
 */
public class UserDBManager {

    private Statement st;

    public UserDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    // Find user by email and password in the database - Read one row in the database table
    public User findUser(String email, String password) throws SQLException {
        //setup the select sql query string       
        String fetch = "Select * FROM IOTUSER.USERS WHERE EMAIL =  " + email + " AND PASSWORD = " + password;
        //execute this query using the statement field     
        ResultSet rs = st.executeQuery(fetch);
        //add the results to a ResultSet       
        while (rs.next()) {
            String userEmail = rs.getString(1);
            String userPass = rs.getString(3);
            if (userEmail.equals(email) && userPass.equals(password)) {
                String userName = rs.getString(2);
                String userGender = rs.getString(4);
                String userFavcol = rs.getString(6);
                String userDOB = rs.getString(5);
                return new User(userEmail, userName, password, userGender, userFavcol, userDOB);
            }
        }
        //search the ResultSet for a user using the parameters               
        return null;
    }

    //Add a user-data into the database   
    public void addUser(String email, String name, String password, String gender, String favcol, String dob) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO IOTUSER.USERS " + "VALUES ('" + email + "','" + name + "','" + password + "','" + gender + "','" + favcol + "','" + dob + "')");

    }

    //update a user details in the database   
    public void updateUser(String email, String name, String password, String dob) throws SQLException {
        //code for update-operation   
        st.executeUpdate("UPDATE IOTUSER.USERS SET NAME = '" + name + "',PASSWORD = '" + password + "',DOB = '" + dob + "' WHERE EMAIL = '" + email + "'");

    }

    //delete a user from the database   
    public void deleteUser(String email) throws SQLException {
        //code for delete-operation   
        st.executeUpdate("DELECT FROM IOTUSER.USERS WHERE EMAIL = '" + email + "'");

    }
    
    //Fetch all
    public ArrayList<User> fetchAll() throws SQLException {
        String fetch = "select * from USERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList();
        
        while (rs.next()) {
            String email = rs.getString(1);
            String name = rs.getString(2);
            String password = rs.getString(3);
            String gender = rs.getString(4);
            String favcol = rs.getString(6);
            String dob = rs.getString(5);
            temp.add(new User(email, name, password, gender, favcol, dob));
        }
         return temp;
    }
    
    public boolean checkUser(String email, String password) throws SQLException {
        String fetch = "select * from IOTUSER.USERS where EMAIL = '" + email + "' and PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String userEmail = rs.getString(1);
            String userPass = rs.getString(3);
            if(userEmail.equals(email) && userPass.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
