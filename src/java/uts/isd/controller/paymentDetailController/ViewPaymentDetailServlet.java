
package uts.isd.controller.paymentDetailController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

import uts.isd.model.PaymentDetail;
import uts.isd.model.dao.PaymentDetailDBManager;

public class ViewPaymentDetailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();   
        String id = request.getParameter("id");
        String bankCard = request.getParameter("bankCard");
        PaymentDetailDBManager manager = (PaymentDetailDBManager) session.getAttribute("manager2");
        
        ArrayList<PaymentDetail> paymentDetail = null;
        try {
            paymentDetail = manager.findPaymentDetail(id, bankCard);
            session.setAttribute("paymentDetail", paymentDetail);
            request.getRequestDispatcher("main.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ViewPaymentDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }
}