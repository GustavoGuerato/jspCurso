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
