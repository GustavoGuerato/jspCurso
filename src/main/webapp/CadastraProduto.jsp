<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Produto</title>
<style>
.form-container {
    max-width: 400px;
    margin: 20px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    background-color: #f9f9f9;
}

.form-container input[type=text], 
.form-container input[type=number], 
.form-container select {
    width: 100%;
    padding: 10px;
    margin: 8px 0;
    display: inline-block;
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
</style>
</head>
<body>
	<h1>Adicionar Produto</h1>
	<form action="adicionarProduto" method="post" class="form-container">
		<label for="nome">Nome:</label> <input type="text" id="nome"
			name="nome" required><br> <br> <label for="codigo">Código:</label>
		<input type="text" id="codigo" name="codigo" required><br>
		<br> <label for="validade">Validade:</label> <input type="text"
			id="validade" name="validade" required><br> <br> <label
			for="quantidade">Quantidade:</label> <input type="text"
			id="quantidade" name="quantidade" required><br> <br>
		<label for="preco">Preço:</label> <input type="text" id="preco"
			name="preco" required><br> <br>

		<button type="submit">Adicionar Produto</button>
	</form>
	<form action="home.jsp" method="get">
		<button type="submit">Voltar</button>
		<button type="submit" value="confirmar"></button>
	</form>

	<c:if test="${not empty mensagem}">
		<p>${mensagem}</p>
	</c:if>
</body>
</html>