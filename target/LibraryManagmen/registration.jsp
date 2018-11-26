<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-04
  Date: 21/11/18
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<center>
    <form method="post" action="<c:url value="/registration"/>">
    <table border="1" width="15%" cellpadding="3">
        <thead>

        <tr>
            <th colspan="2">Enter Information Here</th>
        </tr>
        </thead>
        <tbody>

        <tr>
            <td>
                First name<input type="text"name="firstname"size="20">
            </td>
            <td>
                Last name<input type="text"name="lastname"size="20">
            </td>

            <td>
                Mob Number <input type="number"name="number"size="20">
            </td>
            <td>
                Email<input type="email"name="email"size="20">
            </td>
            <td>
                Passward<input type="password"name="password"size="20">
            </td>
            <td><input type="submit" value="Signup"></td>
        </tr>
         </table>


</tbody>
</form>
    </center>
</body>
</html>
