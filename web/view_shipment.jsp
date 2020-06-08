<%-- 
    Document   : view_shipment
    Created on : 08/06/2020, 9:06:46 PM
    Author     : wangyifan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/demo.css">
        <title>Shipment Information</title>
    </head>
    <body>
        <h1>Shipment Information</h1>
        
        <h1 class="pro_h1">User Profile</h1>
        <%
            ShipmentInformation setShipmentInformation = (ShipmentInformation) session.getAttribute("user");
         %>
         <table id="profile_table">
            <thead>
                <th>Email</th>
                <th>Full Name</th>
                <th>Password</th>
                <th>Gender</th>
                <th>Date of Birth</th>
                <th>Favourite Color</th>
            </thead>
            <tbody>
            <tr>
                <td>${user.email}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td>${user.gender}</td>
                <td>${user.dob}</td>   
                <td>${user.favcol}</td>
            </tr>
            </tbody>
        </table>
    </body>
</html>

        
        
        
    </body>
</html>
