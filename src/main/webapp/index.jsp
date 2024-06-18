<jsp:useBean id="calcula" class="beans.BeansCursoJsp"
	type="beans.BeansCursoJsp" scope="page" />


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<br>
	<form action="cabecalho.jsp" method="post">
		
		<input type="text" id="nome" name="nome"> <br> <input
			type="text" id="ano" name="ano"><input
			type="submit" value="testar">
	</form>
	<br>
	<% session.setAttribute("user", "javaavancado"); %>
	<a href="cabecalho.jsp">Ver Teste</a>

</body>
</html>
