package uts.isd.controller.paymentDetailController;

import java.io.IOException;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import uts.isd.model.PaymentDetail;

import uts.isd.model.dao.PaymentDetailDBManager;

public class CreatePaymentDetailServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String id;
        id = request.getParameter("email");
        String bankCard = request.getParameter("bankCard");
        String cvv = request.getParameter("cvv");
        String expiryDate = request.getParameter("expiryDate");
        String permission = request.getParameter("permission");

        PaymentDetailDBManager paymentDetailDBmanager = (PaymentDetailDBManager) session.getAttribute(" paymentDetailDBmanager");

        try {
             paymentDetailDBmanager.addPaymentDetail(id, bankCard, cvv, expiryDate);
            request.getRequestDispatcher("main.jsp").include(request, response);
        }
            catch (SQLException ex) {
                Logger.getLogger(CreatePaymentDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

}


