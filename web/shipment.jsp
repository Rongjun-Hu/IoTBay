<%-- 
    Document   : shipment
    Created on : 2020-6-7, 23:58:25
    Author     : wangyifan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Shipment detail</title>
    </head>
    <body>
        <h1 class="pro_h1">Add your shipment detail</h1>

        <form class="form" action="ShipmentServlet" method="post">
            <table>
                <tr><td>addressLine1</td><td><input type="text" name="address" required></td></tr>
                <tr><td>addressLine2</td><td><input type="text" name="address"></td></tr>
                <tr><td>suburb:</td><td><input type="text" name="suburb" required></td></tr>
                <tr><td>state</td><td><input type="text" name="state" required></td></tr>
                <tr><td>postcode</td><td><input type="number" name="postcode" required></td></tr>
                <tr><td></td><td><input class="button" type="submit" value="Submit"></td></tr>
            </table>
        </form>


    </body>
</html>

