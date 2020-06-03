package uts.isd.controller.deviceController;

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
import uts.isd.model.dao.DeviceDBManager;

/**
 *
 * @author apple
 */
public class CreateDeviceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();  
        
        String name = request.getParameter("name");
        double price = (double) request.getAttribute("price");
        String type = request.getParameter("type");
        int stock = (int) request.getAttribute("stock");
        
        DeviceDBManager manager = (DeviceDBManager) session.getAttribute("manager2");
        
        Device device = null;
        try {
            manager.createDevice(name, price, type, stock);
            // session.setAttribute("device", device);
            request.getRequestDispatcher("main.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReadDeviceServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }
}
