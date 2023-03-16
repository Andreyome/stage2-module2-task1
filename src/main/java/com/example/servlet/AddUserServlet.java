package com.example.servlet;
import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//String url = req.getRequestURL().toString();
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/add.jsp");
        requestDispatcher.forward(req, resp);
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    User user = new User(firstName,lastName);
    Warehouse base = Warehouse.getInstance();
    base.addUser(user);
    req.setAttribute("user",user);
    resp.sendRedirect("/add");
    }
}

    //write your code here!
