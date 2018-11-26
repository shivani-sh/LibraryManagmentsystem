package com.dz.Servlet;

import com.dz.Model.Library.Library;
import com.dz.Model.Library.LibraryOperation;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "DisplayrecordServlet",urlPatterns = "/displayrecord")
public class DisplayrecordServlet extends HttpServlet {

    private final Logger logger= LogManager.getLogger(DisplayrecordServlet.class.getName());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibraryOperation libraryOperation=new LibraryOperation();
        List<Library> libraryList =    libraryOperation.display();
        logger.info(libraryList.get(1));
        request.setAttribute("librarylist",libraryList);
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/displayrecord.jsp");
        requestDispatcher.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
