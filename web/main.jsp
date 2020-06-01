<%-- 
    Document   : main.jsp
    Created on : 28/04/2020, 2:17:35 PM
    Author     : peter
--%>

<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <!--<a class="button" href="edit.jsp"> Account</a>-->
            <a class="button" href="LogoutServlet">Logout</a>
        </div>

        <p style="text-align: right; color: yellow; "> 
            <i>You are logged in as ${user.name} &lt; ${user.email} &gt; &lt; ${user.permission} &gt;</i>
        </p>

        <div>
            <jsp:include page="profile.jsp" flush="true" />
            <% if (perm.equals("staff")) { %>
                <jsp:include page="deviceMGMT.jsp" flush="true" />
            <% } %>
        </div>

    </body>
</html>
