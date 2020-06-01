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

public class UpdateServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1- retrieve the current session
        HttpSession session = request.getSession();
        //3- capture the posted email      
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String favcol = request.getParameter("favcol");
        String dob = request.getParameter("dob");
        String permission = request.getParameter("permission");
        User user = new User(email, name, password, gender, favcol, dob, permission);
        //5- retrieve the manager instance from session      
        UserDBManager manager = (UserDBManager) session.getAttribute("manager");
        try {
            if (user != null) {
                session.setAttribute("user", user);
                manager.updateUser(email, name, password, dob);
                session.setAttribute("update", "Update was successful");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else {
                session.setAttribute("update", "Update was not successful");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("edit.jsp");
    }
}
