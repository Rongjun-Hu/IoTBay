<%-- 
    Document   : OrderList
    Created on : Jun 6, 2020, 3:02:36 PM
    Author     : diamo
--%>

<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saved Order List Page</title>
    </head>
    <body>
        <h1>Saved Order List</h1>
        <%

            User user = (User) session.getAttribute("user");
            String email = user.getEmail();

            ArrayList<Order> Orders = (ArrayList<Order>) session.getAttribute("orders");
        %>
        <table>
            <thead>
            <th>Order ID</th>
            <th>Order Date</th>
        </thead>
        <tbody>
            <% for (Order order : Orders) { %>
            <% if(order.getStatus() != 4 ) { %>
            <tr>
                <td><%=order.getOrderId()%></td>
                <td><%=order.getOrderDate()%></td>
                 <td>
              
                <form class="form" action="ViewAnOrderServlet" method="post">
                        <input type="hidden" value="<%=order.getOrderId()%>" name="orderId">
                        <input type="hidden" value="<%=order.getStatus()%>" name="status">
                        <input class="button" type="submit" value="View">
                    </form>
                              
                </td>
                 <td>
                       <% if(order.getStatus() == 0 ) { %>
                     <form class="form" action="DeleteOrderListServlet" method="get">
                        <input type="hidden" value="<%=order.getOrderId()%>" name="orderId">
                        <input class="button" type="submit" value="Delete">
                    </form>
                         <% }%>
                 </td>
            </tr>   
            <% }%>
            <% }%>
        </tbody>
    </table>
</body>
</html>
