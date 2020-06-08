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
import uts.isd.model.Device;
import uts.isd.model.Order;
import uts.isd.model.dao.DeviceDBManager;
import uts.isd.model.dao.OrderDBManager;

/**
 *
 * @author diamo
 */
public class ViewAnOrderServlet extends HttpServlet {

      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int status = Integer.parseInt(request.getParameter("status"));
        OrderDBManager manager = (OrderDBManager) session.getAttribute("manager3");
        
        Order order = null;
        DeviceDBManager manager2 = (DeviceDBManager) session.getAttribute("manager2");  
        Device device = null;
        try {
            order = manager.findOrder(orderId);
            String id = String.valueOf(order.getDeviceId());
            device = manager2.findDevice(id);
            if (status == 0){
            session.setAttribute("device", device);
            session.setAttribute("order", order);    
            request.getRequestDispatcher("view_order.jsp").include(request, response);}
            if (status == 1){
            session.setAttribute("device", device);
            session.setAttribute("order", order);  
            request.getRequestDispatcher("view_order.jsp").include(request, response);} 
        } catch (SQLException ex) {
            Logger.getLogger(ReadOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }
}