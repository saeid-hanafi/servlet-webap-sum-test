package com.yasertebat.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        if (isNum(num1) && isNum(num2)) {
            double newNum1 = Double.parseDouble(num1);
            double newNum2 = Double.parseDouble(num2);
            double sum = newNum1 + newNum2;

            req.setAttribute("SUM", sum);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("square");
            requestDispatcher.forward(req, resp);
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
}
