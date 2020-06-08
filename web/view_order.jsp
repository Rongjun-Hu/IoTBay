<%-- 
    Document   : viewOrder
    Created on : Jun 8, 2020, 4:17:34 PM
    Author     : diamo
--%>

<%@page import="uts.isd.model.Device"%>
<%@page import="uts.isd.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>View Order Page</title>
    </head>
    <body>
        <h1>View Order</h1>
                <div class="main_btn">

            <a class="button" href="main.jsp">Main</a>
            <a class="button" href="LogoutServlet">Logout</a>
        </div>
        <%
            Order order = (Order) session.getAttribute("order");
            int orderId = order.getOrderId();
            String email = order.getEmail();
            String orderDate = order.getOrderDate();
            Device device = (Device) session.getAttribute("device");
            int deviceId = device.getId();
            String name = device.getName();
            double price = device.getPrice();
            String type = device.getType();
            int amount = order.getAmount();
            int status = order.getStatus();
            double total = price*(double)amount;
        %>
        
            <table>
                <tr><td>Order ID:</td><td><%=orderId%></td></tr>
                <tr><td>Email:</td><td><%=email%></td></tr>
                <tr><td>Device Name:</td><td><%=name%></td></tr>
                <tr><td>Price:</td><td><%=price%></td></tr>
                <tr><td>Type:</td><td><%=type%></td></tr>
                <tr><td>Order Date:</td><td><%=orderDate%></td></tr>
                <tr><td>Amount:</td><td><%=amount%></td></tr>
                <tr><td>Total:</td><td><%=total%></td></tr>
                <tr><td><input type="hidden" value="<%=deviceId%>" name="deviceId"></td></tr>
                <tr><td><input type="hidden" value="<%=status%>" name="status"></td></tr>
                
                        <% if (status == 0) {%> <%-- saved order  --%>
                <tr><td>Status:</td><td>Saved</td></tr>
            </table>
      
        <jsp:include page="updateOrder.jsp" flush="true" />
    </body>
</html>  
<% } else if (status == 1) { %> <%-- submitted order  Payment feature start here--%>
<tr><td>Status:</td><td>Submitted</td></tr>
<tr><td><a class="button" href="main.jsp">Back</td><td><input class="button" type="submit" value="Pay"></td></tr>
</table>
</body>
</html>

<% } else if (status == 2) { %> <%-- payed order  --%>
<tr><td>Status:</td><td>Payed</td></tr>
<tr><td><a class="button" href="main.jsp">Back</td></tr>
<% }%>
</table>
</body>
</html>
