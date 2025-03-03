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
@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/add.jsp");
    try {
        requestDispatcher.forward(req, resp);
    }
    catch (ServletException | IOException e){
        e.printStackTrace();
    }
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        User user = new User(firstName, lastName);
        Warehouse base = Warehouse.getInstance();
        base.addUser(user);
        req.setAttribute("user", user);
        try {
            resp.sendRedirect("/add");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

    //write your code here!
