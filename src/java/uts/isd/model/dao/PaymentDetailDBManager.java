package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import uts.isd.model.PaymentDetail;

public class PaymentDetailDBManager {

    private Statement st;

    public PaymentDetailDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    public void addPaymentDetail(String bankCard, String expiryDate, String cvv, String customerId) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.PAYMENTDETAIL (customerID, bankCard, cvv, expiryDate) VALUES ('" + customerId + "', '" + bankCard + "', '" + cvv + "', " + expiryDate + ")");
    }

    public void deletePaymentDetail(String customerId) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.PAYMENTDETAIL WHERE CUSTOMERID='" + customerId + "'");
    }

    public void updatePaymentDetail(String bankCard, String expiryDate, String cvv, String customerId) throws SQLException {
        st.executeUpdate("UPDATE IOTUSER.PAYMENTDETAIL SET BANKCARD = '" + bankCard + "',CVV = '" + cvv + "',EXPIRYDATE = '" + expiryDate + "' WHERE CUSTOMERID = '" + customerId + "'");
    }

    public ArrayList<PaymentDetail> fetchAll() throws SQLException {
        String fetch = "select * from PAYMENTDETAIL";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<PaymentDetail> temp = new ArrayList();

        while (rs.next()) {
            String customerId = rs.getString(1);
            String bankCard = rs.getString(2);
            String cvv = rs.getString(3);
            String expiryDate = rs.getString(4);
            temp.add(new PaymentDetail(customerId, bankCard, cvv, expiryDate));
        }
        return temp;
    }

    public PaymentDetail getPaymentDetail(String bankCard, String customerId) throws SQLException {
        try {
            ResultSet results = st.executeQuery("SELECT * FROM IOTUSER.PAYMENTDETAIL WHERE BANKCARD = '" + bankCard + "'");
            return new PaymentDetail(results.getString("customerId"), results.getString("bankcard"), results.getString("cvv"), results.getString("expiryDate"));
        } catch (Exception ex) {
            return null;
        }
    }
}
