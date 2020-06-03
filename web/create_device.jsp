<%-- 
    Document   : create_device.jsp
    Created on : 2020-6-3, 21:30:10
    Author     : apple
--%>

<%@page import="uts.isd.model.Device"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Create a Device</title>
    </head>
    <body>
        <h1 class="pro_h1">Create a Device</h1>

        <form class="form" action="CreateDeviceServlet" method="post">
            <table>
                <!-- EL dosen't works, use JSP instead -->
                <tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
                <tr><td>Price:</td><td><input type="text" name="price" required></td></tr>
                <tr><td>Type:</td><td><input type="text" name="type" required></td></tr>
                <tr><td>Stock:</td><td><input type="text" name="stock" required></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Update"></td></tr>
            </table>
        </form>


    </body>
</html>
