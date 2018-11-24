<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-04
  Date: 24/11/18
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>issue book</title>
</head>
<body>
<form action="IssueServlet" method="get">
<table>
    <tr>
        <td>Book Id</td>
        <td>Book Name</td>
        <td>Book Quantity</td>
    </tr>
    <tr>
        <c:forEach items="${list}" var="list">
            <td>${list.bookid}</td>
            <td>${list.bookName}</td>
            <td>${list.book_quantity}</td>
            <input type="hidden" value="${list.bookid}" name="id">
        </c:forEach>
    </tr>

        <tr><td>Enter The Quantity</td>
        <td><input type="text" name="bookquantity"></td></tr>
        <tr><td><input type="submit" value="Submit" > </td></tr>
    </table>
</form>
</body>
</html>
