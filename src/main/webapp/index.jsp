<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Bem vindo ao curso de jsp</h2>
	<%="seu sucesso garantido"%>
	
	<form action="receber-nome.jsp">
		<input type="text" id="nome" name="nome">
		<input type="submit" value="Enviar"> 	
	</form>
	<%session.setAttribute("curso", "curso de jsp"); %>

</body>
</html>