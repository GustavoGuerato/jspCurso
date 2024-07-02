<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro De Usuario</title>
<link rel="stylesheet" type="text/css" href="resources/css/cadastro.css" />
<link rel="stylesheet" type="text/css" href="resources/css/table.css" />


</head>
<body>
	<div class="login-box">
		<div class="lb-header">
			<h2>Cadastro De Usuario</h2>
		</div>
		<form action="salvarUsuario" method="post" class="email-login">
			<div class="u-form-group">
				<label for="id">Codigo:</label> <input type="text" id="id" name="id"
					class="input-field" value="${user.id}">
			</div>
			<div class="u-form-group">
				<label for="login">Login:</label> <input type="text" id="login"
					name="login" class="input-field" value="${user.login}">
			</div>
			<div class="u-form-group">
				<label for="senha">Senha:</label> <input type="password" id="senha"
					name="senha" class="input-field" value="${user.senha}">
			</div>
			<div class="u-form-group">
				<button type="submit">Salvar</button>
			</div>
		</form>

		<div class="email-login">
			<section>
				<h1>Lista de Usuários</h1>
				<div class="tbl-header">
					<table>
						<thead>
							<tr>
								<th>ID & Login</th>
								<th>Senha</th>
								<th>Ação</th>
								<th>Ação</th>
							</tr>
						</thead>
					</table>
				</div>
				<div class="tbl-content">
					<table>
						<tbody>
							<c:forEach items="${usuarios}" var="user">
								<tr>
									<td style="width: 150px"><c:out value="${user.id}"></c:out>
										<c:out value="${user.login}"></c:out></td>
									<td><c:out value="${user.senha}"></c:out></td>
									<td><a href="salvarUsuario?acao=delete&user=${user.login}"><img
											src="resources/img/excluir.png"></a></td>
									<td><a href="salvarUsuario?acao=edit&user=${user.login}"><img
											src="resources/img/editar.png"></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</section>
		</div>
	</div>
</body>
</html>
