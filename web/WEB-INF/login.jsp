<%-- 
    Document   : login
    Created on : Sep 27, 2018, 12:07:52 PM
    Author     : 672762
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Login</title>
    </head>
    <body>
        <h1>Remember Me Log In Page</h1>
        
        <form  method="post">
            Username: <input type="text" value="${username}" name="username"> <br>
            Password: <input type="password" value="${password}" name="password"> <br>
            
            <input type="submit" value="login"> <br>
            <input type="checkbox" name="remeberMe" value="rememberMe">Remember me?<br>
        </form>
        
            <div display="hidden">
                {$message}
            </div>
        
        
    </body>
</html>
