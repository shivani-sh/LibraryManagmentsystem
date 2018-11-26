<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<form method="get" action="<c:url value="/login"/>">
    <center>
        <select name="item">
            <option value="User">User</option>
            <option value="Admin">Admin</option>
        </select>
    </center>
    <center>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Login Here</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td>User Name</td>
                <td><input type="text" name="uname" value=""/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="pass" value=""/></td>
            <tr>
                <td><input type="submit" value="Login"/></td>

            </tr>
            </tr>


            </tbody>
        </table>
    </center>
</form>
<center>
    <form method="post" action="<c:url value="/login"/>">
        <table>
            <tr>
                <td><input type="submit" name="registration" value="registration"></td>
            </tr>
        </table>
    </form>


</center>
</body>
</html>


