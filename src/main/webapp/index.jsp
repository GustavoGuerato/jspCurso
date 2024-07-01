<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="myprefix" uri="/WEB-INF/testetag.tld" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de Login</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
</head>
<body>
    <form action="LoginServlet" method="post">
        <label for="login">Login:</label>
        <input type="text" id="login" name="login"> <br>
        
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha"> <br>
        
        <input type="submit" value="Logar">
    </form>
</body>
</html>
