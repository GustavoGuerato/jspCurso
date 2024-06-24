<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro De Usuario</title>
</head>
<body>
	<h1>Cadastro</h1>

	<form action="salvarUsuario" method="post">
		<table>
			<tr>
				<td>Login:</td>
				<td><input type="text" id="Login" name="login"></td>
			</tr>
			<tr>
				<td>senha:</td>
				<td><input type="password" id="senha" name="senha"></td>
			</tr>
		</table>

		<c:forEach items="${usuarios}" var="user">
			<tr>
				<td style="width: 150px"><c:out value="${user.login}"></c:out></td>
				<td><c:out value="${user.senha}"></c:out></td>
			</tr>
		</c:forEach>
		<input type="submit" value="Salvar">
	</form>
</body>
</html>