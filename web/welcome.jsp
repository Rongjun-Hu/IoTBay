<%-- 
    Document   : welcome
    Created on : 07/04/2020, 2:48:57 PM
    Author     : peter
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/demo.css">
        <title>Welcome Page</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String gender = request.getParameter("gender");
            String dob = request.getParameter("dob");
            String favcol = request.getParameter("favcol");

        %>
        <div class="wel_content">
            <h1>Welcome, <%= name %></h1>
            <p class="p">Your Email is: <%= email %></p>
            <p class="p">Your Password is: <%= password %></p>
            <p class="p">Your Gender is: <%= gender %></p>
            <p class="p">Your DOB is: <%= dob %></p>
            <p class="p">Your Favourite Color is: <%= favcol %></p>
            <div>
                <a  class="button" href="index.jsp">Cancel</a>
                <a class="button" href="main.jsp">Main</a>
            </div>
        </div>
        <%
            User user = new User(name, email, password, gender, dob, favcol);
            session.setAttribute ("user", user);
        %>
        
    </body>
</html>
