package uts.isd.controller.userController;

import java.io.IOException;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import uts.isd.model.User;

import uts.isd.model.dao.UserDBManager;

public class LoginServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class    
        Validator validator = new Validator();
        //3- capture the posted email      
        String email = request.getParameter("email");
        //4- capture the posted password    
        String password = request.getParameter("password");
        //5- retrieve the manager instance from session      
        UserDBManager manager = (UserDBManager) session.getAttribute("manager");
        User user = null;
        validator.clear(session);

        if (!validator.validateEmail(email)) {
            //8-set incorrect email error to the session     
            session.setAttribute("emailErr", "Error: Email format incorrect");
            //9- redirect user back to the login.jsp     
            request.getRequestDispatcher("login.jsp").include(request, response);

        } else if (!validator.validatePassword(password)) {
            //11-set incorrect password error to the session           
            session.setAttribute("passErr", "Error: Password format incorrect");
            //12- redirect user back to the login.jsp          
            request.getRequestDispatcher("login.jsp").include(request, response);

        } else {

            try {

                //6- find user by email and password
                user = manager.findUser(email, password);
                if (user != null) {
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                } else {
                    session.setAttribute("existErr", "User does ont exist in the Database");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                }

            } catch (SQLException | NullPointerException ex) {
                    System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
            }

        }
    }
}
