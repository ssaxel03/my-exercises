package io.codeforall.fanstatics;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginCustomerMVC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/LoginCustomerMVC.jsp");
        dispatcher.forward(request, response);

    }
}
