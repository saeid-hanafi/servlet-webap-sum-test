package com.yasertebat.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/square")
public class SquareServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        // Forward Servlet By Request Dispatcher By Equal URL
        /* double sum = (double) req.getAttribute("SUM"); */

        // Redirect To Another Servlet And Send Value By Get Method
        /** double sum = Double.parseDouble(req.getParameter("sum")); */

        // Redirect To Another Servlet And Send Value By Session
        /** HttpSession session = req.getSession();
        double sum = (double) session.getAttribute("sum"); */

        // Redirect To Another Servlet And Send Value By Cookies
        Cookie[] cookies = req.getCookies();
        double sum = 0;
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("sum")) {
                sum = Double.parseDouble(cookie.getValue());
            }
        }

        double square = sum * sum;

        ServletContext context = getServletContext();
        String addNum = context.getInitParameter("additionalNum");

        square *= Double.parseDouble(addNum);

        writer.print("Square Servlet Result is: " + square);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
