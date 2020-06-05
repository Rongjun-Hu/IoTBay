package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.PaymentDetail;


public class PaymentDetailDBManager {
    
    private Statement st;

    public PaymentDetailDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    public void createPaymentDetail(String id, String bankCard, String cvv, String expiryDate) throws SQLException {                    
        st.executeUpdate("INSERT INTO IOTUSER.PATMENTDETAIL(ID, BANKCARD, CVV, EXPIRYDATE) VALUES('" + id + "'," + bankCard + ",'" + cvv + "'," + expiryDate + ")");
    }
    
    
    public ArrayList<PaymentDetail> findPaymentDetail(String id, String bankCard) throws SQLException {

        String fetch = "SELECT * FROM IOTUSER.PAYMENTDETAIL WHERE NAME ='" + id + "'" + "AND TYPE ='" + bankCard + "'";
        if (id.equals("") && !bankCard.equals("")) {
            fetch = "SELECT * FROM IOTUSER.PAYMENTDETAIL WHERE BANKCARD ='" + bankCard + "'";
        } else if (!id.equals("") && bankCard.equals("")) {
            fetch = "SELECT * FROM IOTUSER.PAYMENTDETAIL WHERE ID ='" + id + "'";
        } else if (id.equals("") && bankCard.equals("")) {
            fetch = "SELECT * FROM IOTUSER.PAYMENTDETAIL";
        }
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<PaymentDetail> temp = new ArrayList();
        
        while (rs.next()) {
            int iD = rs.getInt(1);
            String bankCardNum = rs.getString(2);
            String cvv = rs.getString(3);
            String expiryDate = rs.getString(4);
            temp.add(new PaymentDetail(iD, bankCardNum, cvv, expiryDate));
        }
        return temp;
    }
 
    
    public void updatePaymentDetail(String id, String bankCard, String cvv, String expiryDate) throws SQLException { 
        st.executeUpdate("UPDATE IOTUSER.PAYMENTDETAIL SET id ='" +id+ "',BANKCARD =" +bankCard+ ",cvv ='" +cvv+ "',EXPIRYDATE =" +expiryDate+ "WHERE ID =" +id);
    }

    public void deletePaymentDetail(int id) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.PAYMENTDETAIL WHERE ID =" + id);
    }
    
    public boolean idExist(int id) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT ID FROM PAYMENTDETAIL");
        while (rs.next()) {
            if (id == rs.getInt(1)) {
                return true;
            }
        }
        return false;
    }
}
    
