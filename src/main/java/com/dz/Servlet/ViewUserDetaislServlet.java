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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewUserDetaislServlet",urlPatterns = "/ViewUserDetaislServlet")
public class ViewUserDetaislServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int uid= (int) session.getAttribute("id");
        LibraryOperation libraryOperation=new LibraryOperation();
        List<User> list =libraryOperation.getbookbyuserid(uid);
request.setAttribute("list",list);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/viewdetails.jsp");
        requestDispatcher.forward(request,response);
    }
}
