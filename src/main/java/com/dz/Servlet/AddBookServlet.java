package com.dz.Servlet;

import com.dz.Model.Library.Library;
import com.dz.Model.Library.LibraryOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * in this we add book data
 */

@WebServlet(name = "AddBookServlet",urlPatterns = "/AddBook")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibraryOperation libraryOperation=new LibraryOperation();
        Library library=new Library();


        library.setBookName(request.getParameter("book_name"));
        library.setBook_auther(request.getParameter("book_auther"));
        library.setBook_quantity(Integer.parseInt(request.getParameter("book_quantity")));
        libraryOperation.addbook( library);

        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
