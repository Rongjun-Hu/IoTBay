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
import uts.isd.model.Device;
import uts.isd.model.Order;
import uts.isd.model.dao.DeviceDBManager;

import uts.isd.model.dao.OrderDBManager;

/**
 *
 * @author apple
 */
public class UpdateOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();  
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String email = request.getParameter("email");
        String orderDate = request.getParameter("orderDate");
        int amount = Integer.parseInt(request.getParameter("amount"));
        int status = Integer.parseInt(request.getParameter("status"));
        
        Order order = null;
        Device device = null;
        OrderDBManager manager = (OrderDBManager) session.getAttribute("manager3"); 
        DeviceDBManager manager2 = (DeviceDBManager) session.getAttribute("manager2");     
        try {
            order = manager.findOrder(orderId);
            String id = String. valueOf(order.getDeviceId());
            device = manager2.findDevice(id);
            manager.updateOrder(orderId, email, orderDate, amount, status);
            session.setAttribute("device", device);
            session.setAttribute("order", order); 
            request.getRequestDispatcher("view_order.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReadOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }
}
