<%--
  Created by IntelliJ IDEA.
  User: dz-gg-04
  Date: 19/11/18
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addd</title>
</head>
<body>
<form>
    <center>

        <table border="1" width="30%"cellpadding="5">
            <tbody>
           <%-- <input type = "checkbox" name = "AddBook"  />AddBook
            <input type = "checkbox" name = "DeleteBook"  /> DeleteBook
            <input type = "checkbox" name = "UpdateBook"  /> UpdateBook--%>


            <select name="items">
                <option value="1">AddBook</option>
                <option value="2">DeleteBook</option>
                <option value="3">UpdateBook</option>
            </select>
            <input type="submit" value="Submit">



            </tbody>
        </table>
    </center>





</form>
</body>
</html>
