package uts.isd.controller.orderController;

import java.io.IOException;
import java.sql.SQLException;
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
public class CreateOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        int deviceId = Integer.parseInt(request.getParameter("deviceId"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String orderDate = request.getParameter("orderDate");
        int status = Integer.parseInt(request.getParameter("status"));

        Device device = null;
        OrderDBManager manager = (OrderDBManager) session.getAttribute("manager3");
        DeviceDBManager manager2 = (DeviceDBManager) session.getAttribute("manager2");

        try {
            String id = String.valueOf(deviceId);
            device = manager2.findDevice(id);
            Order order = manager.createOrder(email, deviceId, orderDate, amount, status);
            manager2.updateStock(deviceId, amount);
            if (status == 0) {
                session.setAttribute("device", device);
                session.setAttribute("order", order);
                request.getRequestDispatcher("view_order.jsp").include(request, response);
            }
            if (status == 1) {
                session.setAttribute("device", device);
                session.setAttribute("order", order);
                request.getRequestDispatcher("view_order.jsp").include(request, response);
            }
            if (status == 4) {
                session.setAttribute("device", device);
                session.setAttribute("order", order);
                request.getRequestDispatcher("main.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
    }
}
