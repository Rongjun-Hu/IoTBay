<%-- 
    Document   : profile
    Created on : 01/05/2020, 11:48:55 AM
    Author     : peter
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Profile Page</title>
    </head>
    <body>
        <h1 class="pro_h1">User Profile</h1>
        <%
            User user = (User) session.getAttribute("user");
         %>
         <table id="profile_table">
            <thead>
                <th>Eamil</th>
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
