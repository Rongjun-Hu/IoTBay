<%-- 
    Document   : device_customer
    Created on : 2020-6-2, 3:59:39
    Author     : apple
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Device"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>device management Page</title>
    </head>
    <body>
        <h1>Device Management</h1>
        <%
            ArrayList<Device> devices = (ArrayList<Device>) session.getAttribute("devices");
        %>
        <table>
            <thead>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Type</th>
                <th>In Stock</th>
                <th>   </th>
            </thead>
            <tbody>
                <% for(Device device : devices){ %>
                <tr>
                    <td>${device.id}</td>
                    <td>${device.name}</td>
                    <td>${device.price}</td>
                    <td>${device.type}</td>
                    <td>${device.stock}</td>
                    <td> 
                        <a href="update_device.jsp?device='${device}'">Update</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="DeleteDeviceServlet?id='${device.id}'">Delete</a>
                    </td>
                </tr>
                <% } %>
                <tr>
                    <a href="create_device.jsp">Create</a>
                </tr>
            </tbody>
        </table>
    </body>
</html>
