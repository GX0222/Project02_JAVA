<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String[] names = {"Brad","Kirito", "Asuna", "Shadow"};
	pageContext.setAttribute("names", names);
%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1" width="100%">
			<tr>
				<th>count</th>
				<th>index</th>
				<th>Name</th>
				<th>first</th>
				<th>last</th>
			</tr>
			<c:forEach items="${names }" var="name" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${status.index }</td>
					<td>${name }</td>
					<td>${status.first }</td>
					<td>${status.last }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>