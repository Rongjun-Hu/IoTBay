<%-- 
    Document   : updateOrder
    Created on : Jun 4, 2020, 7:19:07 PM
    Author     : diamo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.Device"%>
<%@page import="uts.isd.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Update Order</title>
    </head>
    <body>
        <h1>Update Order</h1>
        <%
            Order order = (Order) session.getAttribute("order");
            int orderId = order.getOrderId();
            String email = order.getEmail();
            String orderDate = order.getOrderDate();
            Device device = (Device) session.getAttribute("device");
            int id = device.getId();
            String name = device.getName();
            double price = device.getPrice();
            String type = device.getType();
            int amount = order.getAmount();
            int stock  = device.getStock();
            int status = order.getStatus();
            
        %>
         <form class="form" action="UpdateOrderServlet" method="post">
            <table>
                <tr><td>Order ID:</td><td><input type="text" name="orderId" value="<%=orderId%>" readonly="true"></td></tr>
                <tr><td>Email:</td><td><input type="text" name="email" value="<%=email%>" required="yes"></td></tr>
                <tr><td>Device Name:</td><td><input type="text" name="name" value="<%=name%>" readonly="true"></td></tr>
                <tr><td>Price:</td><td><input type="number" name="price" value="<%=price%>" readonly="true"></td></tr>
                <tr><td>Type:</td><td><input type="text" name="type"  value="<%=type%>" readonly="true"></td></tr>
                <tr><td>Order Date:</td><td><input type="date" name="orderDate" value="<%=orderDate%>" required="yes"</td></tr>
                <tr><td>Amount:</td><td><input type="number" name="amount" min="1" max="<%=stock%>" value="<%=amount%>" required="yes"></td></tr>
                <tr><td><input type="hidden" value="<%=id%>" name="deviceId"></td></tr>
                  <td><input type="radio" id="save" name="status" value="0" checked>
                        <lable for="save">Save Order</lable>
                    </td>
                    <td><input type="radio" id="submit" name="status" value="1" >
                        <lable for="submit">Submit Order (No turning back!)</lable>
                    </td>
                <tr><td><a class="button" href="main.jsp">Cancel</td><td><a class="button" href="DeleteOrderServlet?orderId=<%=orderId%>">Delete</a></td>
                   <td><input class="button" type="submit" value="Update"></td></tr>
            </table>
        </form>


    </body>
</html>
