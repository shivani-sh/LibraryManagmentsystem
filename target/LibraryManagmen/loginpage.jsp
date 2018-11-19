<%--
  Created by IntelliJ IDEA.
  User: dz-gg-04
  Date: 19/11/18
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<form action="loginpage.jsp"method="post">

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
       <%-- <form method="post"action="homepage.jsp">
        <input type="submit"value="singup">

    </form>
--%>


</tr>
        </tbody>
    </table>
    <form method="post"action="homepage.jsp">
        <input type="submit"value="singup">

    </form>


</form>





<form action="/Login" method="Post">
    User Name: <input type="text" name="lastName" size="20">
    User Passward: <input type="password" name="pass" size="20">

    <br><br>
    <input type="submit" value="login">
</form>
<form action="homepage.jsp" method="Post">
    <input type="submit"value="home">
</form>



</body>
</html>
