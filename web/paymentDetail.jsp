<%-- 
    Document   : paymentDetail
    Created on : 04/06/2020, 4:34:17 PM
    Author     : lantianxiang
--%>

<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.PaymentDetail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="css/demo.css">
            <title>Main Page</title>
        </head>
        <body>
            <%
                User user = (User) session.getAttribute("user");
                String email = user.getEmail();
                String pass = user.getPassword();
                String perm = user.getPermission();
            %>

            <h1>User Dashboard</h1>
            <hr>
            <div class="main_btn">
                <a class="button" href="EditServlet?email='<%=email%>'&password='<%=pass%>'&permission='<%=perm%>'">Account</a>
                <a class="button" href="LogoutServlet">Logout</a>
            </div>

            <p style="text-align: right; color: yellow; "> 
                <i>You are logged in as ${user.name} &lt; ${user.email} &gt; &lt; ${user.permission} &gt;</i>
            </p>
            <h1 class="pro_h1">Payment Deatail</h1>
            <%
                PaymentDetail paymentDetail = (PaymentDetail) session.getAttribute("paymentDetail");

                String customerId = paymentDetail.getCustomerId();
                String bankCard = paymentDetail.getBankCard();
                String cvv = paymentDetail.getCvv();
                String expiryDate = paymentDetail.getExpiryDate();

            %>
            <form action="" method="post">
                <table id="profile_table">
                    <thead>
                    <th>Id</th>
                    <th>Bank Card</th>
                    <th>CVV</th>
                    <th>Expiry Date</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${paymentDetail.customerId}</td>
                            <td>${paymentDetail.bankCard}</td>
                            <td>${paymentDetail.cvv}</td>
                            <td>${paymentDetail.expiryDate}</td>
                        </tr>
                    </tbody>
                </table>
    </html>