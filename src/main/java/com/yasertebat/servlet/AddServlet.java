package com.yasertebat.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/add")
public class AddServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        if (isNum(num1) && isNum(num2)) {
            double newNum1 = Double.parseDouble(num1);
            double newNum2 = Double.parseDouble(num2);
            double sum = newNum1 + newNum2;

            // Redirect To Another Servlet And Send Value By Cookies
            Cookie cookie = new Cookie("sum", sum+"");
            resp.addCookie(cookie);
            resp.sendRedirect("square");

            // Redirect To Another Servlet And Send Value By Session
            /** HttpSession session = req.getSession();
            session.setAttribute("sum", sum);
            resp.sendRedirect("square"); */

            // Redirect To Another Servlet And Send Value By Get Method
            /** resp.sendRedirect("square?sum=" + sum); **/

            // Forward Servlet By Request Dispatcher By Equal URL
            /** req.setAttribute("SUM", sum);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("square");
            requestDispatcher.forward(req, resp); **/
        }else{
            writer.print("Enter Valid Numbers, Please.");
        }
    }

    public static boolean isNum(String num) {
        if (num == null) {
            return false;
        }

        try {
            double newNum = Double.parseDouble(num);
        }catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
