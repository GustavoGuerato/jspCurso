<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Produto</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.form-container {
	max-width: 400px;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	background-color: #fff;
}

.form-container input[type=text], .form-container input[type=number],
	.form-container select {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.form-container button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	width: 100%;
}

.form-container button:hover {
	background-color: #45a049;
}

.form-container h2 {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

.form-container .message {
	text-align: center;
	margin-top: 20px;
	color: red;
}

.back-container {
	display: flex;
	justify-content: space-between;
	margin-top: 20px;
}

.back-container button {
	background-color: #f44336;
}

.back-container button:hover {
	background-color: #d32f2f;
}
</style>
</head>
<body>
	<div class="form-container">
		<h2>Adicionar Produto</h2>
		<form action="adicionarProduto" method="post">
			<label for="nome">Nome:</label> <input type="text" id="nome"
				name="nome" required><br> <label for="codigo">Código:</label>
			<input type="text" id="codigo" name="codigo" required><br>

			<label for="validade">Validade:</label> <input type="text"
				id="validade" name="validade" required><br> <label
				for="quantidade">Quantidade:</label> <input type="text"
				id="quantidade" name="quantidade" required><br> <label
				for="preco">Preço:</label> <input type="text" id="preco"
				name="preco" required><br>

			<button type="submit">Adicionar Produto</button>
		</form>
		<div class="back-container">
			<form action="home.jsp" method="get">
				<button type="submit">Voltar</button>
			</form>
		</div>
		<c:if test="${not empty mensagem}">
			<p class="message">${mensagem}</p>
		</c:if>
	</div>
</body>
</html>
