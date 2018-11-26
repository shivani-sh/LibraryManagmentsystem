package com.dz.Servlet;

import com.dz.Model.Library.Library;
import com.dz.Model.Library.LibraryOperation;
import com.dz.Model.Library.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibraryOperation libraryOperation = new LibraryOperation();
        Library library = new Library();
        User user = new User();

        library.setFirstname(request.getParameter("firstname"));
        library.setLastname(request.getParameter("lastname"));
        library.setPhoneNumber((request.getParameter("number")));
        library.setEmail(request.getParameter("email"));
        library.setPassword(request.getParameter("password"));
        user.setUsername(request.getParameter("firstname") + request.getParameter("lastname"));
        user.setPassword(request.getParameter("password"));
        libraryOperation.userdatainsert(user);
        libraryOperation.registration(library);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
