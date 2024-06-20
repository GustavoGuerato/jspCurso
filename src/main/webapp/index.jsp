<jsp:useBean id="calcula" class="beans.BeansCursoJsp"
	type="beans.BeansCursoJsp" scope="page" />


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="get">
		Login: 
		<input type="text" id="login" name="login"> 
		<br>
		Senha: 
		<input type="text" id="senha" name="senha"> 
		<br> 
		<input type="submit" value="logar">

	</form>
</body>
</html>
