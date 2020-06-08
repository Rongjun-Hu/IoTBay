/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller.orderController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.OrderDBManager;

/**
 *
 * @author diamo
 */
public class DeleteOrderListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();  
        
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        
        OrderDBManager manager = (OrderDBManager) session.getAttribute("manager3");
        try {
            manager.deleteOrder(orderId);
            request.getRequestDispatcher("order.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }
}
