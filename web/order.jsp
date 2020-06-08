<%-- 
    Document   : Order
    Created on : Jun 6, 2020, 2:58:37 PM
    Author     : diamo
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Order Management Page</title>
    </head>
    <body>
        <h1>Order Management</h1>
        <div class="main_btn">

            <a class="button" href="main.jsp">Main</a>
            <a class="button" href="LogoutServlet">Logout</a>
        </div>
         <%
                User user = (User) session.getAttribute("user");
                String email = user.getEmail();
            %>
        <h2>Saved Order List</h2>
        <div>
        <form action="ReadOrderServlet" method="post">
            <table>
                <tr><td>Search Save Order</td></tr>
                <tr><td>Email:</td><input type="text" value="<%=email%>" name="email" readonly="true"></td></tr>
                <tr><td>Order ID:</td><td><input type="text" placeholder="Search by Order ID" name="orderId"></td></tr>
                <tr><td>Order Date:</td><td><input type="date" placeholder="Search by Order Date" name="orderDate"></td></tr>
                 <td><input type="radio" id="save" name="status" value="0" checked>
                        <lable for="save">Saved Orders</lable>
                    </td>
                    <td><input type="radio" id="submit" name="status" value="1" >
                        <lable for="submit">Submitted Orders</lable>
                    </td>
                <tr><td><input class="button" type="submit" value="Search"><td></tr>
                <tr><td>Click Search to Refresh<td></tr>
            </table>
            </form>
            <div>
         <jsp:include page="orderList.jsp" flush="true" />
         
    </body>
</html>
