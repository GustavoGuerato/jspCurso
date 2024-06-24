<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<input type="submit" value="Salvar">
	</form>
</body>
</html>