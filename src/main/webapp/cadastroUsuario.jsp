<!DOCTYPE html>
<html lang="pt-BR">
<head>
<<<<<<< HEAD
<meta charset="UTF-8">
<title>Cadastro de Usu·rio</title>
<link rel="stylesheet" type="text/css" href="resources/css/cadastro.css" />
=======
    <meta charset="UTF-8">
    <title>Cadastro De Usu√°rio</title>
    <link rel="stylesheet" type="text/css" href="resources/css/cadastro.css" />
>>>>>>> 2bc5ae40bc6f47bb9e8638bb9dd1634d3812d8f4

<!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

nav {
	background-color: #333;
	padding: 10px;
}

nav a {
	color: #fff;
	text-decoration: none;
	margin-right: 15px;
}

<<<<<<< HEAD
.login-box {
	margin: 50px auto;
	width: 50%;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	background-color: #f9f9f9;
}

.lb-header {
	text-align: center;
	margin-bottom: 20px;
}

.u-form-group {
	margin-bottom: 15px;
}

.input-field {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

button {
	padding: 10px 15px;
	margin-right: 10px;
	border: none;
	border-radius: 5px;
	background-color: #4CAF50;
	color: white;
	cursor: pointer;
}

button:last-child {
	background-color: #f44336;
	margin-right: 0;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

td {
	padding: 10px;
	border: 1px solid #ccc;
	text-align: center;
}

img {
	cursor: pointer;
	width: 20px;
	height: 20px;
}
</style>
</head>
<body>
	<nav>
		<a href="acessoliberado.jsp">InÌcio</a> <a href="index.jsp">Sair</a>
	</nav>

	<div class="login-box">
		<div class="lb-header">
			<h2>Cadastro de Usu·rio</h2>
		</div>
		<h3 style="color: red">${msg}</h3>
		<form action="salvarUsuario" method="post" class="email-login"
			id="form-user" onsubmit="return validarCampos();"
			enctype="multipart/form-data">
			<div class="form-group-row">
				<div class="u-form-group">
					<label for="id">CÛdigo:</label> <input type="text" id="id"
						name="id" class="input-field" value="${user.id}">
				</div>
				<div class="u-form-group">
					<label for="cep">CEP:</label> <input type="text" id="cep"
						name="cep" class="input-field" value="${user.cep}"
						onblur="consultaCep();">
				</div>
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
				<label for="nome">Nome:</label> <input type="text" id="nome"
					name="nome" class="input-field" value="${user.nome}">
			</div>
			<div class="u-form-group">
				<label for="telefone">Telefone:</label> <input type="text"
					id="telefone" name="telefone" class="input-field"
					value="${user.telefone}">
			</div>
			<div class="u-form-group">
				<label for="rua">Rua:</label> <input type="text" id="rua" name="rua"
					class="input-field" value="${user.rua}">
			</div>
			<div class="u-form-group">
				<label for="bairro">Bairro:</label> <input type="text" id="bairro"
					name="bairro" class="input-field" value="${user.bairro}">
			</div>
			<div class="u-form-group">
				<label for="cidade">Cidade:</label> <input type="text" id="cidade"
					name="cidade" class="input-field" value="${user.cidade}">
			</div>
			<div class="u-form-group">
				<label for="estado">Estado:</label> <input type="text" id="estado"
					name="estado" class="input-field" value="${user.estado}">
			</div>
			<div class="u-form-group">
				<label for="ibge">IBGE:</label> <input type="text" id="ibge"
					name="ibge" class="input-field" value="${user.ibge}">
			</div>
			<div class="u-form-group">
				<label for="foto">Foto:</label> <input type="file" id="foto"
					name="foto">
			</div>
			<div class="u-form-group">
				<label for="pdf">PDF:</label> <input type="file" id="pdf" name="pdf">
			</div>
			<div class="u-form-group">
				<button type="submit">Salvar</button>
				<button type="button"
					onclick="document.getElementById('form-user').action='salvarUsuario?acao=reset'; document.getElementById('form-user').submit();">Cancelar</button>
			</div>
		</form>
		<div class="email-login">
			<table>
				<c:forEach items="${usuarios}" var="user">
					<tr>
						<td style="width: 150px"><c:out value="${user.id}"></c:out><br>
							<c:out value="${user.login}"></c:out></td>
						<td><c:out value="${user.senha}"></c:out></td>
						<td><c:out value="${user.nome}"></c:out></td>
						<td><a href="salvarUsuario?acao=delete&user=${user.id}">
								<img src="resources/img/excluir.png" alt="Excluir">
						</a></td>
						<td><a href="salvarUsuario?acao=edit&user=${user.id}"> <img
								src="resources/img/editar.png" alt="Editar">
						</a></td>
						<td><a href="SalvarTelefone?user=${user.id}"> <img
								alt="Telefones" title="Telefones"
								src="resources/img/telefone.png">
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function validarCampos() {
			var camposObrigatorios = [ {
				id : 'id',
				nome : 'CÛdigo'
			}, {
				id : 'cep',
				nome : 'CEP'
			}, {
				id : 'login',
				nome : 'Login'
			}, {
				id : 'senha',
				nome : 'Senha'
			}, {
				id : 'nome',
				nome : 'Nome'
			}, {
				id : 'telefone',
				nome : 'Telefone'
			}, {
				id : 'rua',
				nome : 'Rua'
			}, {
				id : 'bairro',
				nome : 'Bairro'
			}, {
				id : 'cidade',
				nome : 'Cidade'
			}, {
				id : 'estado',
				nome : 'Estado'
			}, {
				id : 'ibge',
				nome : 'IBGE'
			} ];

			for (var i = 0; i < camposObrigatorios.length; i++) {
				var campo = camposObrigatorios[i];
				if (document.getElementById(campo.id).value.trim() === "") {
					alert("O campo " + campo.nome + " È obrigatÛrio.");
					document.getElementById(campo.id).focus();
					return false;
				}
			}
			return true;
		}

		function consultaCep() {
			var cep = $("#cep").val().replace(/\D/g, '');
			if (cep !== "") {
				var validacep = /^[0-9]{8}$/;
				if (validacep.test(cep)) {
					$.getJSON("https://viacep.com.br/ws/" + cep
							+ "/json/?callback=?", function(dados) {
						if (!("erro" in dados)) {
							$("#rua").val(dados.logradouro);
							$("#bairro").val(dados.bairro);
							$("#cidade").val(dados.localidade);
							$("#estado").val(dados.uf);
							$("#ibge").val(dados.ibge);
						} else {
							alert("CEP n„o encontrado.");
						}
					});
				} else {
					alert("Formato de CEP inv·lido.");
				}
			} else {
				alert("CEP n„o pode estar vazio.");
			}
		}
	</script>
=======
        .input-field {
            width: 100%;
        }

        .login-box {
            margin: 0 auto;
            width: 50%;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .lb-header {
            text-align: center;
            margin-bottom: 20px;
        }

        .u-form-group {
            margin-bottom: 15px;
        }

        button {
            padding: 10px 15px;
            margin-right: 10px;
        }

        button:last-child {
            margin-right: 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        img {
            cursor: pointer;
        }
    </style>
</head>
<body>
    <nav>
        <a href="acessoliberado.jsp">In√≠cio</a>
        <a href="index.jsp">Sair</a>
    </nav>

    <div class="login-box">
        <div class="lb-header">
            <h2>Cadastro De Usu√°rio</h2>
        </div>
        <h3 style="color: red">${msg}</h3>
        <form action="salvarUsuario" method="post" class="email-login" id="form-user" onsubmit="return validarCampos();" enctype="multipart/form-data">
            <div class="form-group-row">
                <div class="u-form-group">
                    <label for="id">C√≥digo:</label>
                    <input type="text" id="id" name="id" class="input-field" value="${user.id}">
                </div>
                <div class="u-form-group">
                    <label for="cep">CEP:</label>
                    <input type="text" id="cep" name="cep" class="input-field" value="${user.cep}" onblur="consultaCep();">
                </div>
            </div>
            <div class="u-form-group">
                <label for="login">Login:</label>
                <input type="text" id="login" name="login" class="input-field" value="${user.login}">
            </div>
            <div class="u-form-group">
                <label for="senha">Senha:</label>
                <input type="password" id="senha" name="senha" class="input-field" value="${user.senha}">
            </div>
            <div class="u-form-group">
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" class="input-field" value="${user.nome}">
            </div>
            <div class="u-form-group">
                <label for="telefone">Telefone:</label>
                <input type="text" id="telefone" name="telefone" class="input-field" value="${user.telefone}">
            </div>
            <div class="u-form-group">
                <label for="rua">Rua:</label>
                <input type="text" id="rua" name="rua" class="input-field" value="${user.rua}">
            </div>
            <div class="u-form-group">
                <label for="bairro">Bairro:</label>
                <input type="text" id="bairro" name="bairro" class="input-field" value="${user.bairro}">
            </div>
            <div class="u-form-group">
                <label for="cidade">Cidade:</label>
                <input type="text" id="cidade" name="cidade" class="input-field" value="${user.cidade}">
            </div>
            <div class="u-form-group">
                <label for="estado">Estado:</label>
                <input type="text" id="estado" name="estado" class="input-field" value="${user.estado}">
            </div>
            <div class="u-form-group">
                <label for="ibge">IBGE:</label>
                <input type="text" id="ibge" name="ibge" class="input-field" value="${user.ibge}">
            </div>
            <div class="u-form-group">
                <label for="foto">Foto:</label>
                <input type="file" id="foto" name="foto">
            </div>
            <div class="u-form-group">
                <label for="pdf">PDF:</label>
                <input type="file" id="pdf" name="pdf">
            </div>
            <div class="u-form-group">
                <button type="submit">Salvar</button>
                <button type="button" onclick="document.getElementById('form-user').action='salvarUsuario?acao=reset'; document.getElementById('form-user').submit();">Cancelar</button>
            </div>
        </form>
        <div class="email-login">
            <table>
                <c:forEach items="${usuarios}" var="user">
                    <tr>
                        <td style="width: 150px">
                            <c:out value="${user.id}"></c:out>
                            <br>
                            <c:out value="${user.login}"></c:out>
                        </td>
                        <td><c:out value="${user.senha}"></c:out></td>
                        <td><c:out value="${user.nome}"></c:out></td>
                        <td>
                            <a href="salvarUsuario?acao=delete&user=${user.id}">
                                <img src="resources/img/excluir.png" width="20px" height="20px" alt="Excluir">
                            </a>
                        </td>
                        <td>
                            <a href="salvarUsuario?acao=edit&user=${user.id}">
                                <img src="resources/img/editar.png" width="20px" height="20px" alt="Editar">
                            </a>
                        </td>
                        <td>
                            <a href="SalvarTelefone?user=${user.id}">
                                <img alt="Telefones" title="Telefones" src="resources/img/telefone.png" width="20px" height="20px">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        function validarCampos() {
            var camposObrigatorios = [
                { id: 'id', nome: 'C√≥digo' },
                { id: 'cep', nome: 'CEP' },
                { id: 'login', nome: 'Login' },
                { id: 'senha', nome: 'Senha' },
                { id: 'nome', nome: 'Nome' },
                { id: 'telefone', nome: 'Telefone' },
                { id: 'rua', nome: 'Rua' },
                { id: 'bairro', nome: 'Bairro' },
                { id: 'cidade', nome: 'Cidade' },
                { id: 'estado', nome: 'Estado' },
                { id: 'ibge', nome: 'IBGE' }
            ];

            for (var i = 0; i < camposObrigatorios.length; i++) {
                var campo = camposObrigatorios[i];
                if (document.getElementById(campo.id).value.trim() === "") {
                    alert("O campo " + campo.nome + " √© obrigat√≥rio.");
                    document.getElementById(campo.id).focus();
                    return false;
                }
            }
            return true;
        }

        function consultaCep() {
            var cep = $("#cep").val().replace(/\D/g, '');
            if (cep != "") {
                var validacep = /^[0-9]{8}$/;
                if(validacep.test(cep)) {
                    $.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?", function(dados) {
                        if (!("erro" in dados)) {
                            $("#rua").val(dados.logradouro);
                            $("#bairro").val(dados.bairro);
                            $("#cidade").val(dados.localidade);
                            $("#estado").val(dados.uf);
                            $("#ibge").val(dados.ibge);
                        } else {
                            alert("CEP n√£o encontrado.");
                        }
                    });
                } else {
                    alert("Formato de CEP inv√°lido.");
                }
            } else {
                alert("CEP n√£o pode estar vazio.");
            }
        }
    </script>
>>>>>>> 2bc5ae40bc6f47bb9e8638bb9dd1634d3812d8f4
</body>
</html
