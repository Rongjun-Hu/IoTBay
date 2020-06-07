package uts.isd.model.dao;

import java.sql.*;
import uts.isd.model.PaymentDetail;

public class PaymentDetailDBManager {

    private Statement st;

    public PaymentDetailDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    public void addPaymentDetail(String bankCard, String expiryDate, String cvv, String customerId) throws SQLException {
        st.executeUpdate("INSERT INTO IOTUSER.PAYMENTDETAIL (customerID, bankCard, cvv, expiryDate) VALUES ('" + customerId + "', '" + bankCard + "', '" + cvv + "', " + expiryDate + ")");
    }

    public void deletePaymentDetail(String id) throws SQLException {
        st.executeUpdate("DELETE FROM IOTUSER.PAYMENTDETAIL WHERE BANKCARD='" + id + "'");
    }

    public void updatePaymentDetail() throws SQLException {

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
