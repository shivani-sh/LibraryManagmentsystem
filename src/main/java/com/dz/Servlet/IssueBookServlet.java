package com.dz.Servlet;

import com.dz.Model.Library.Library;
import com.dz.Model.Library.LibraryOperation;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IssueBookServlet",urlPatterns = "/IssueBook")
public class IssueBookServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(IssueBookServlet.class.getName());
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibraryOperation libraryOperation = new LibraryOperation();
        int id = Integer.parseInt(request.getParameter("id"));
       logger.info(id);
        List<Library> list = new ArrayList<>();
        try {
            list = libraryOperation.getbookbyid(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        boolean check = Boolean.parseBoolean(request.getParameter("check"));
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/issuebook.jsp");
        requestDispatcher.forward(request, response);

    }
}
