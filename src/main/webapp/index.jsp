<jsp:useBean id="calcula" class="beans.BeansCursoJsp" type="beans.BeansCursoJsp" scope="page"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index</h1>
   <%=
   calcula.calcula(60)
   %>
   
</body>
</html>
