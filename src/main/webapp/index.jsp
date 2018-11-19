<html>
<body>
<form action="AddBook" method="post">

    <center>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Login Here</th>
            </tr>
            </thead>
            <tbody>
            <input type = "checkbox" name = "User"  /> User
            <input type = "checkbox" name = "Admin"  /> Admin
            <%--<select name="items">
                <input type = "checkbox" name = "User"  /> User
                <input type = "checkbox" name = "Admin"  /> Admin
                &lt;%&ndash;<option value="1">Admin</option>
                <option value="2">User</option>&ndash;%&gt;
            </select>--%>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="uname" value="" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="pass" value="" /></td>
            </tr>
            <form method="post" action="AddBook">
            <tr>
                <td><input type="submit" value="Login" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
             </form>
            <%--<tr>
                <td colspan="2">Yet Not Registered!! <a href="homepage.jsp">Register Here</a></td>
            </tr>--%>
            </tbody>
        </table>
    </center>




    <%--<select name="items">
        <option value="1">Admin</option>
        <option value="2">User</option>
    </select>
    <input type="submit" value="Submit">
    <c:redirect url="HomePage?action=HomePage"></c:redirect>--%>
</form>


<form action="loginpage.jsp"method="post">


    <center>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Login Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>first Name</td>
                <td><input type="text" name="uname" value="" /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastname" value="" /></td>
            </tr>
            <tr>
                <td>Mob number</td>
                <td><input type="number" name="number" value="" /></td>
            </tr>
            <tr>
                <td>email</td>
                <td><input type="email" name="email" value="" /></td>
            </tr>

            <tr>
                <td><input type="submit" value="Signup" /></td>

            </tr>
            <%--<tr>
                <td colspan="2">Yet Not Registered!! <a href="homepage.jsp">Register Here</a></td>
            </tr>--%>
            </tbody>
        </table>
    </center>





<%-- <table border="1" width="15%" cellpadding="3">
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
            &lt;%&ndash; <form method="post"action="homepage.jsp">
             <input type="submit"value="singup">

         </form>
     &ndash;%&gt;


        </tr>
        </tbody>
    </table>
    <form method="post"action="homepage.jsp">
        <input type="submit"value="singup">

    </form>
--%>

</form>





</body>
</html>
