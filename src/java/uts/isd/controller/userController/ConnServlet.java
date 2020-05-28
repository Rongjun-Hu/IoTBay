package uts.isd.controller.userController;

import java.io.IOException;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import uts.isd.model.dao.*;

public class ConnServlet extends HttpServlet {

    private DBConnector db;

    private UserDBManager manager;

    private Connection conn;

    @Override //Create and instance of DBConnector for the deployment session

    public void init() {

        try {

            db = new DBConnector();  //Create a database connection when the application starts

        } catch (ClassNotFoundException | SQLException ex) {

            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Override //Add the DBConnector, DBManager, Connection instances to the session

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        conn = db.openConnection();       // Create a DB connection

        try {

            manager = new UserDBManager(conn);  //Create a DB manager

        } catch (SQLException ex) {

            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

        //export the DB manager to the view-session (JSPs)
        session.setAttribute("manager", manager);   //Add the manager to the session         

    }

    @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)

    public void destroy() {

        try {

            db.closeConnection();  //Close the DB connection once the session is terminated

        } catch (SQLException ex) {

            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}