<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 02.08.23
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page
        contentType="text/html;charset=UTF-8"
        language="java"
        import="java.io.PrintWriter"
%>
<html>
<head>
    <title>Sum Numbers</title>
</head>
<body>
    <% double num1 = Double.parseDouble(request.getParameter("num1"));
    double num2 = Double.parseDouble(request.getParameter("num2"));
    double sum  = num1 + num2;

//    ServletContext context  = request.getServletContext();
//    String additionalNum    = context.getInitParameter("additionalNum");

    String additionalNum    = application.getInitParameter("additionalNum");
    double result           = sum * Double.parseDouble(additionalNum); %>

    <h1> <%="Result is :" + result%> </h1>
</body>
</html>
