package com.dz.Servlet;

import com.dz.Model.Library.Library;
import com.dz.Model.Library.LibraryOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ReturnSaveServlet", urlPatterns = "/ReturnSaveServlet")
public class ReturnSaveServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        int dbbookquantity = Integer.parseInt(request.getParameter("dbbookquantity"));
        int bookquantity = Integer.parseInt(request.getParameter("bookquantity"));
        LibraryOperation libraryOperation = new LibraryOperation();
        try {
            libraryOperation.returnbookquantity(uid, bookid, dbbookquantity, bookquantity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        request.setAttribute("uid", id);
        List<Library> libraryList = libraryOperation.display();
        request.setAttribute("libraryList", libraryList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/displayrecord.jsp");
        requestDispatcher.forward(request, response);

    }
}
