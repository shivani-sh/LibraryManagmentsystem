<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-04
  Date: 24/11/18
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ReturnSaveServlet" method="get">
    <table>
        <tr>
            <td>User Id</td>
            <td>Book Id</td>
            <td>Book Name</td>
            <td>Book Quantity</td>
        </tr>
        <tr>
                <td>${uid}</td>
                 <td>${bookid}</td>
                <td>${bookname}</td>
                <td>${bookquantity}</td>
                <input type="hidden" value="${bookid}" name="bookid">
            <input type="hidden" name="uid" value="${uid}">
            <input type="hidden" name="dbbookquantity" value="${bookquantity}">
        </tr>

        <tr><td>Enter The Quantity You want To return</td>
            <td><input type="text" name="bookquantity"></td></tr>
        <tr><td><input type="submit" value="Submit" > </td></tr>
    </table>
</form>
</body>
</html>
