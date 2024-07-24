<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Cadastro De Usuario</title>
<link rel="stylesheet" type="text/css" href="resources/css/cadastro.css" />

<!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

<style>
.form-group-row {
	display: flex;
	justify-content: space-between;
}

.form-group-row .u-form-group {
	flex: 1;
	margin-right: 10px;
}

.form-group-row .u-form-group:last-child {
	margin-right: 0;
}

.input-field {
	width: 100%;
}
</style>

</head>
<body>
	<a href="acessoliberado.jsp">Inicio</a>
	<a href="index.jsp">Sair</a>

	<div class="login-box">
		<div class="lb-header">
			<h2>Cadastro De telefones</h2>
		</div>
		<h3 style="color: red">${msg}</h3>
		<form action="salvarUsuario" method="post" class="email-login"
			id="form-user" onsubmit="return validarCampos()">
			<div class="form-group-row">
				<div class="u-form-group">
					<label for="id">User:</label> <input type="text" id="id" name="id"
						class="input-field" value="${userEscolhido}" readonly> <label
						for="nome">Nome:</label> <input type="text" id="nome" name="nome"
						class="input-field" value="${userEscolhidoNome}" readonly>

					<label for="numero">Numero:</label> <input type="text" id="numero"
						name="numero" class="input-field"> <label for="tipo">Tipo:</label>
					<select id="tipo" name="tipo">
						<option value="">Selecione o tipo</option>
						<option value="Casa">Casa</option>
						<option value="Fixo">Fixo</option>
						<option value="Celular">Celular</option>
					</select>
				</div>
			</div>
			<div class="u-form-group">
				<button type="submit">Salvar</button>
				<button type="button"
					onclick="document.getElementById('form-user').action='salvarUsuario?acao=reset'; document.getElementById('form-user').submit();">Cancelar</button>
			</div>
		</form>

		<div class="email-login">
			<table>
				<c:forEach items="${telefones}" var="fone">
					<tr>
						<td style="width: 150px"><c:out value="${fone.id}"></c:out> <c:out
								value="${fone.numero}"></c:out></td>
						<td><c:out value="${fone.tipo}"></c:out></td>
						<td><a href="salvarTelefones?acao=delete&phone=${fone.id}"><img
								src="resources/img/excluir.png" width="20px" height="20px"></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function validarCampos() {
			if (document.getElementById("numero").value == '') {
				alert("Informe o n�mero");
				return false;
			} else if (document.getElementById("tipo").value == '') {
				alert("Informe o tipo");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>
