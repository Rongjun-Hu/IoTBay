<%-- 
    Document   : update_device
    Created on : 2020-6-3, 4:59:40
    Author     : apple
--%>

<%@page import="uts.isd.model.Device"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Update the Device</title>
    </head>
    <body>
        <h1 class="pro_h1">Update the Device</h1>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String type = request.getParameter("type");
            int stock = Integer.parseInt(request.getParameter("stock"));
        %>
        <form class="form" action="UpdateDeviceServlet" method="post">
            <table>
                <!-- EL dosen't works, use JSP instead -->
                <tr><td><input type="hidden" name="id" value="<%=id%>"></td></tr>
                <tr><td>Name:</td><td><input type="text" name="name" value="<%=name%>" required></td></tr>
                <tr><td>Price:</td><td><input type="number" name="price" value="<%=price%>" min="1" step="0.01"></td></tr>
                <tr><td>Type:</td><td><input type="text" name="type" value="<%=type%>" required></td></tr>
                <tr><td>Stock:</td><td><input type="number" name="stock" value="<%=stock%>" min="1"></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Update"></td></tr>
            </table>
        </form>


    </body>
</html>
