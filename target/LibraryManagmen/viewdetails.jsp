<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-04
  Date: 24/11/18
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <table>
        <div align="center" style="vertical-align: bottom"></div>
        <caption><h2>User Library record</h2></caption>
        <tr>
            <th>USER ID</th>
            <th>Bookid</th>
            <th>book_name</th>
            <th>book_QUANTITY</th>
            <th>book_ISSUEDATE</th>

        </tr>
        <c:forEach items="${list}" var="list">

        <table>
            <tr>
                <td><c:out value="${list.uid}"></c:out> &nbsp;&nbsp;</td>
                <td><c:out value="${list.bookid}"></c:out> &nbsp;&nbsp;</td>
                <td><c:out value="${list.bookName}"></c:out> &nbsp;&nbsp;</td>
                <td><c:out value="${list.quantity}"></c:out> &nbsp;&nbsp;</td>
                <td><c:out value="${list.issue_date}"></c:out> &nbsp;&nbsp;</td>
                <td><a href="<c:url value="/ReturnBook?uid=" /><c:out value="${list.uid}"/>&bookid=<c:out value="${list.bookid}"/>&bookquantity=<c:out value="${list.quantity}"/>&bookname=<c:out value="${list.bookName}"/>">Return Book</a> </td>

            </tr>
        </table>
        </c:forEach>
        <a href="/ViewUserDetaislServlet"><input type="button" value="View Student details"></a>
</center>
</body>
</html>
