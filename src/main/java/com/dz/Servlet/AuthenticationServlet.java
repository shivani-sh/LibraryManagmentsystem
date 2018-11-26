package com.dz.Servlet;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthenticationServlet",urlPatterns = "/authentication")
public class AuthenticationServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(AuthenticationServlet.class.getName());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String items = request.getParameter("item");
        logger.info(items);

        if (request.getParameter("items").equals("Admin")) {
            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/addbook.jsp");
            requestDispatcher.forward(request, response);
        } else if (request.getParameter("items").equals("User")) {

            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/displayrecord.jsp");
            requestDispatcher.forward(request, response);

        } else {
            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
