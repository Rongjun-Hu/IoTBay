package uts.isd.controller.orderController;

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
import uts.isd.model.Order;
import uts.isd.model.dao.OrderDBManager;

/**
 *
 * @author apple
 */
public class ReadOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();   
        String orderID = request.getParameter("orderId");
        String email = request.getParameter("email");
        String orderDate = request.getParameter("orderDate");
        int status = Integer.parseInt(request.getParameter("status"));
        OrderDBManager manager = (OrderDBManager) session.getAttribute("manager3");
        
        ArrayList<Order> orders = null;
        try {
            orders = manager.findOrders(orderID, email, orderDate, status);
            session.setAttribute("orders", orders);
            request.getRequestDispatcher("order.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReadOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }
}