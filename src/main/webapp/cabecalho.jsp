<jsp:useBean id="calcula" class="beans.BeansCursoJsp"
	type="beans.BeansCursoJsp" scope="page" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:setProperty property="*" name="calcula" />
	<h3>cabeçalho</h3>
	<jsp:setProperty property="nome" name="calcula" />
	<br>
	<jsp:setProperty property="ano" name="calcula" />
	<br>
	<jsp:setProperty property="sexo" name="calcula" />
</body>
</html>