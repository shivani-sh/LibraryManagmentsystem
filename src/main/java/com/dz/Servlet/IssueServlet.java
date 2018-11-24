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

@WebServlet(name = "IssueServlet",urlPatterns = "/IssueServlet")
public class IssueServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  int issuebookquantity=Integer.parseInt(request.getParameter("bookquantity"));
  int id=Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        int uid= (int) session.getAttribute("id");
        LibraryOperation libraryOperation=new LibraryOperation();
        libraryOperation.updatebookquantity(issuebookquantity,id,uid);


        List<Library> libraryList= libraryOperation.display();
        request.setAttribute("libraryList",libraryList);
        request.setAttribute("uid",uid);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/displayrecord.jsp");
        requestDispatcher.forward(request, response);

    }
}
