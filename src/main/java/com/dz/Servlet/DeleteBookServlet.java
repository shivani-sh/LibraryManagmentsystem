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
import java.util.List;

@WebServlet(name = "DeleteBookServlet",urlPatterns = "/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        LibraryOperation libraryOperation = new LibraryOperation();
        System.out.println(id);
        libraryOperation.deletedata(id);
        System.out.println("from delete servlet");
        List<Library> libraryList = libraryOperation.display();
        request.setAttribute("libraryList", libraryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/librarymenu.jsp");
        requestDispatcher.forward(request, response);


    }

}
