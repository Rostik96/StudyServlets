<%--
  Created by IntelliJ IDEA.
  User: rost
  Date: 02.01.2023
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show cart</title>
</head>
<body>
<%@ page import="com.rost.study.servlet.logic.Cart" %>
<% Cart cart = (Cart) session.getAttribute("cart"); %>
<p>Наименование: <%= cart.getName() %> </p>
<p>Количество: <%= cart.getQuantity() %> </p>
</body>
</html>
