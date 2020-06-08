<%-- 
    Document   : orderlist
    Created on : Jun 4, 2020, 7:16:11 PM
    Author     : diamo
--%>

<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.Device"%>
<%@page import="uts.isd.model.Order"%>
<%@page import="uts.isd.model.OrderLine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Create Order</title>
    </head>
    <body>
        <h1>Create an Order</h1>
                <div class="main_btn">

            <a class="button" href="main.jsp">Main</a>
            <a class="button" href="LogoutServlet">Logout</a>
        </div>
          <%
            User user = (User) session.getAttribute("user");
            String email = user.getEmail();
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String type = request.getParameter("type");
            int stock = Integer.parseInt(request.getParameter("stock"));
        %>
        <form class="form" action="CreateOrderServlet" method="post">
            <table>
                <tr><td>Email:</td><td><input type="text" name="email" value="<%=email%>" required="yes"></td></tr>
                <tr><td>Device Name:</td><td><input type="text" name="name" value="<%=name%>" readonly="true"></td></tr>
                <tr><td>Price:</td><td><input type="number" name="price" value="<%=price%>" readonly="true"></td></tr>
                <tr><td>Type:</td><td><input type="text" name="type"  value="<%=type%>" readonly="true"></td></tr>
                <tr><td>Order Date:</td><td><input type="date" name="orderDate" required="yes"></td></tr>
                <tr><td>Amount:</td><td><input type="number" name="amount" min="1" max="<%=stock%>" required="yes"></td></tr>
                <tr><td><input type="hidden" value="<%=id%>" name="deviceId"></td></tr>
                <td><input type="radio" id="save" name="status" value="0">
                        <lable for="save">Save Order</lable>
                    </td>
                    <td><input type="radio" id="submit" name="status" value="1" checked>
                        <lable for="submit">Submit Order (No turning back!)</lable>
                    </td>
                <tr><td><a class="button" href="main.jsp">Cancel</td><td><input class="button" type="submit" value="Create"></td></tr>
            </table>
        </form>


    </body>
</html>
