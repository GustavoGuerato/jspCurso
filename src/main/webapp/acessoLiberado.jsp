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
	<h3>seja bem vindo!</h3>


	<a href="salvarUsuario?acao=listartodos"> <img
		style="height: 20px, width:20px" alt="Cadastro de usuarios"
		src="resources/img/cadastro.png" />
	</a>

</body>
</html>