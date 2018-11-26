package com.dz.Servlet;

import com.dz.Model.Library.Library;
import com.dz.Model.Library.LibraryOperation;
import com.dz.Model.Library.User;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(LoginServlet.class.getName());
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if (request.getParameter("registration").equals("registration")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registration.jsp");
            requestDispatcher.forward(request, response);

        }
    }

    /**
     * @param request to admin and user
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

        LibraryOperation libraryOperation = new LibraryOperation();
        Library library = new Library();
        String item = request.getParameter("item");
        logger.info(item);
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        if (uname.equals("mona") && pass.equals("sona") && request.getParameter("item").equals("Admin")) {

            HttpSession session = request.getSession();
            session.setAttribute("username", uname);
            List<Library> libraryList = libraryOperation.display();
            request.setAttribute("libraryList", libraryList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/librarymenu.jsp");
            requestDispatcher.forward(request, response);


        } else if (request.getParameter("item").equals("User")) {
            List<User> userList = libraryOperation.showUserList();


            for (User user : userList) {
                if (uname.equals(user.getUsername())) {
                    if (pass.equals(user.getPassword())) {
                        List<Library> libraryList = libraryOperation.display();
                        request.setAttribute("libraryList", libraryList);
                        request.setAttribute("uid", user.getUid());
                        request.setAttribute("bookid", library.getBookid());
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/displayrecord.jsp");
                        requestDispatcher.forward(request, response);
                    }
                }
            }

        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        }




        }


    }

