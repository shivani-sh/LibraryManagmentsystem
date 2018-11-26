package com.dz.Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ReturnBookServlet", urlPatterns = "/ReturnBook")
public class ReturnBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        int bookid = Integer.parseInt(request.getParameter("bookid"));
        int bookquantity = Integer.parseInt(request.getParameter("bookquantity"));
        String bookname = request.getParameter("bookname");
        request.setAttribute("uid", uid);
        request.setAttribute("bookid", bookid);
        request.setAttribute("bookquantity", bookquantity);
        request.setAttribute("bookname", bookname);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/returnbook.jsp");
        requestDispatcher.forward(request, response);

    }
}
