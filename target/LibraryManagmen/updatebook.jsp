<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <table>
        <div align="center" style="vertical-align: bottom"></div>
        <caption><h2>Library record</h2></caption>
        <tr>
            <th>ID &nbsp;
            <th>
            <th>book_name&nbsp;</th>
            <th>book_auther&nbsp;</th>
            <th>book_quantity&nbsp;</th>

        </tr>
        <c:forEach items="${libraryList}" var="displayrecord">

        <table>
            <tr>
                <td><c:out value="${displayrecord.bookid}"></c:out> &nbsp;&nbsp;</td>
                <td><c:out value="${displayrecord.bookName}"></c:out> &nbsp;&nbsp;</td>
                <td><c:out value="${displayrecord.book_auther}"></c:out> &nbsp;&nbsp;</td>
                <td><c:out value="${displayrecord.book_quantity}"></c:out> &nbsp;&nbsp;</td>
                <td><a href="<c:url value="/IssueBook?id=" /><c:out value="${displayrecord.bookid}"/>">Issue Book</a>
                </td>

                <c:set var="id" value="${uid}" scope="session"/>
                <c:set var="bookid" value="${bookid}" scope="session"/>

            </tr>
        </table>
        </c:forEach>

</center>
</body>
</html>
