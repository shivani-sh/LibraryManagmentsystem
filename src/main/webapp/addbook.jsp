<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addd</title>
</head>
<body>
<form method="post" action="<c:url value="/AddBook"/>">
    <center>

        <table border="1" width="30%" cellpadding="5">
            <tbody>

            <h2>Please add data</h2>
            <table>
                <tr>
                    <td>Book Name</td>
                    <td><input type="text" name="book_name"/></td>
                </tr>
                <tr>
                    <td>Book Auther</td>
                    <td><input type="text" name="book_auther"/></td>
                </tr>
                <tr>
                    <td>Book quantity</td>
                    <td><input type="number" name="book_quantity"></td>
                </tr>
            </table>
            <input type="submit" name="addbook" value="addbook"/>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
