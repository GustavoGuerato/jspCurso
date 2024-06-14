<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=
	request.getParameter("nome")
	%>
	<br>
	<%response.sendRedirect("https://www.youtube.com/watch?v=yqZ8rZ2lrXA&t=31s"); %>
	
</body>
</html>