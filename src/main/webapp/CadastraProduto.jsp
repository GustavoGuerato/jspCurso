<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Produto</title>
<style>
/* Adicione seus estilos CSS aqui */
</style>
</head>
<body>
	<h1>Adicionar Produto</h1>
	<form action="adicionarProduto" method="post">
		<label for="nome">Nome:</label> <input type="text" id="nome"
			name="nome" required><br>
		<br> <label for="codigo">Código:</label> <input type="text"
			id="codigo" name="codigo" required><br>
		<br> <label for="validade">Validade:</label> <input type="text"
			id="validade" name="validade" required><br>
		<br> <label for="quantidade">Quantidade:</label> <input
			type="text" id="quantidade" name="quantidade" required><br>
		<br> <label for="preco">Preço:</label> <input type="text"
			id="preco" name="preco" required><br>
		<br>

		<button type="submit">Adicionar Produto</button>
	</form>
	<form action="home.jsp" method="get">
		<button type="submit">Voltar</button>
	</form>

	<c:if test="${not empty mensagem}">
		<p>${mensagem}</p>
	</c:if>
</body>
</html>
