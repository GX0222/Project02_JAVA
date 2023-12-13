<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:set var="x" value="123"></c:set>
		<c:set var="x" value="345" scope="request"></c:set>
		x = ${x }<br>
		x = ${requestScope.x }
		<hr>
		<c:out value="Hello World"></c:out><br>
		<c:out value="${x }"></c:out><br>
		<c:out value="${param.i }"></c:out>
		<hr>
		<jsp:useBean id="member" class="tw.ken.utils.Member"></jsp:useBean>
		<c:set target="${member }" property="id">4</c:set>
		<c:set target="${member }" property="account">48763</c:set>
		<c:set target="${member }" property="name">Kirito</c:set>
		${member.id } : ${member.account } : ${member.name }
		<hr>
		${member }
		<hr>
		
		
	</body>
</html>