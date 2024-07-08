<head>
<meta charset="UTF-8">
<title>Cadastro De Usuario</title>
<link rel="stylesheet" type="text/css" href="resources/css/cadastro.css" />
</head>
<body>
	<a href="acessoliberado.jsp">Inicio</a>

	<div class="login-box">
		<div class="lb-header">
			<h2>Cadastro De Usuario</h2>
		</div>
		<h3 style="color: red">${msg}</h3>
		<form action="salvarUsuario" method="post" class="email-login"
			id="form-user">
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
			<div>
				<label for="senha">nome:</label> <input type="password" id="senha"
					name="senha" class="input-field" value="${user.nome}">
			</div>
			<div>
				<label for="senha">telefone:</label> <input type="password"
					id="senha" name="senha" class="input-field"
					value="${user.telefone}">
			</div>
			<div class="u-form-group">
				<button type="submit">Salvar</button>
				<button type="submit"
					onclick="document.getElementById('formUser').action='salvarUsuario?acao=reset'">Cancelar</button>
			</div>
		</form>

		<div class="email-login">
			<table>
				<c:forEach items="${usuarios}" var="user">
					<tr>
						<td style="width: 150px"><c:out value="${user.id}"></c:out> <c:out
								value="${user.login}"></c:out></td>
						<td><c:out value="${user.senha}"></c:out></td>
						<td><c:out value="${user.nome}"></c:out></td>
						<td><a href="salvarUsuario?acao=delete&user=${user.id}"><img
								src="resources/img/excluir.png"></a></td>
						<td><a href="salvarUsuario?acao=edit&user=${user.id}"><img
								src="resources/img/editar.png"></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>