package com.dz.Servlet;
import com.dz.Model.Library.LibraryOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "LibraryOperationServlet",urlPatterns = "/LibraryOperation")
public class LibraryOperationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String items=request.getParameter("item");
       System.out.println(items);
        if(request.getParameter("items").equals("AddBook"))
        {

            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/addbook.jsp");
            requestDispatcher.forward(request, response);
            System.out.println(" add");
        }
     if(request.getParameter("items").equals("DeleteBook"))
     {
         RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/delete.jsp");
         requestDispatcher.forward(request, response);

     }
     if(request.getParameter("items").equals("UpdateBook"))
     {
         RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/updatebook.jsp");
         requestDispatcher.forward(request, response);
     }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
