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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setName("Afonso Gunão");
        user.setEmail("afonsosexo@gmail.com");
        user.setPhone("912345678");

        req.setAttribute("user", user);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/CustomerMVC.jsp");
        dispatcher.forward(req, resp);
    }
}
