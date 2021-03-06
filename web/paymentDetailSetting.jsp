
<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.PaymentDetail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="css/demo.css">
            <title>Payment Setting Page</title>
        </head>

        <%
            User user = (User) session.getAttribute("user");
            String email = user.getEmail();
            String pass = user.getPassword();
            String perm = user.getPermission();
        %>

        <h1>Payment Setting</h1>
        <hr>
        <div class="main_btn">
            <a class="button" href="EditServlet?email='<%=email%>'&password='<%=pass%>'&permission='<%=perm%>'">Account</a>
            <a class="button" href="LogoutServlet">Logout</a>
        </div>

        <p style="text-align: right; color: yellow; "> 
            <i>You are logged in as ${user.name} &lt; ${user.email} &gt; &lt; ${user.permission} &gt;</i>
        </p>
        <div><span class="time" id="time" ></span></div>

        <h1 class="reg_h1">Setting Payment Detail<span class="message"> </span></h1>
        <%
            String emailErr = (String) session.getAttribute("Email Error");
            String cvvErr = (String) session.getAttribute("Cvv Error");
            String cardErr = (String) session.getAttribute("Card Error");
        %>
        <form class="form" action="CreatePaymentSettingServlet" method="post">
            <table>
                
                <tr><td>Card Number:</td><td><input type="text" placeholder="<%=(cardErr != null ? cardErr : "Enter Card Number")%>"name="bankCard" required></td></tr>

                <tr><td>CVV:</td><td><input type="text" placeholder="<%=(cvvErr != null ? cvvErr : "Enter CVV")%>" name="cvv" required></td></tr>

                <tr><td>Expiry Date:</td><td><input type="date" name="expiryDate" required></td></tr>                

                <tr>
                    <td><a class="button" href="main.jsp">Cancel</a>
                        <input class="button" type="submit" value="Confirm">
                    </td>
                <a class="button" href="paymentDetail.jsp"  <form action="ViewPaymentDetailServlet" method="post">View Current Payment Detail</a>
                </tr>
            </table>
        </form>

    </html>
