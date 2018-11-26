<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Libary Menu</title>
</head>
<body>
<form method="post"action="<c:url value="/LibraryOperation"/>">
    <center>

        <table border="1" width="30%" cellpadding="5">
            <tbody>
            <select name="items">
                <option value="AddBook">AddBook</option>


            </select>
            <input type="submit" value="Submit">



            </tbody>
        </table>
    </center>
</form>
<center>
<table>
<div align="center" style="vertical-align: bottom"></div>
<caption><h2>Library record</h2></caption>
<th>
   <tr> <td>ID &nbsp;</td>
    <td>book_name&nbsp;</td>
    <td>book_auther&nbsp;</td>
       <td>book_quantity&nbsp;</td></tr>

</th>
<c:forEach items="${libraryList}" var="displayrecord">


    <tr>
    <td><c:out value="${displayrecord.bookid}"></c:out> &nbsp;&nbsp;</td>
    <td><c:out value="${displayrecord.bookName}"></c:out> &nbsp;&nbsp;</td>
    <td><c:out value="${displayrecord.book_auther}"></c:out> &nbsp;&nbsp;</td>
    <td><c:out value="${displayrecord.book_quantity}"></c:out> &nbsp;&nbsp;</td>
        <td><a href="<c:url value="/DeleteBookServlet?id="/><c:out value="${displayrecord.bookid}"/>">Delete Book</a> </td>
    </tr>
    </c:forEach>
</table>
</center>

</body>
</html>
