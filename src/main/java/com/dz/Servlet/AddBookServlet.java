package com.dz.Servlet;

import com.dz.Model.Library.LibraryOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddBookServlet",urlPatterns = "/AddBook")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibraryOperation libraryOperation=new LibraryOperation();
        libraryOperation.Addbook();

        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/addbook.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
