package io.codeforall.fanstatics;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerMVC extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setName(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(req.getParameter("phone"));

        req.setAttribute("user", user);



        System.out.println(user.getName() + " " + user.getEmail() + " " + user.getPhone());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/CustomerMVC.jsp");
        dispatcher.forward(req, resp);

    }
}
