<%@page import="tw.ken.utils.BCrypt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource 
	driver="com.mysql.cj.jdbc.Driver" 
	url="jdbc:mysql://localhost/brad" 
	user="root"
	password="root"
/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<c:if test="${!empty param.editid }">
			<sql:query var="rs">
				SELECT * FROM member WHERE id = ?;
				<sql:param>${param.editid }</sql:param>
			</sql:query>
		</c:if>
		<c:if test="${!empty param.updateid }">
			<sql:update>
				UPDATE member SET account = ?, cname = ?, passwd = ? WHERE id = ?;
				<sql:param>${param.account }</sql:param>
				<sql:param>${param.cname }</sql:param>
				<sql:param>${BCrypt.hashpw(param.password, BCrypt.gensalt()) }</sql:param>
				<sql:param>${param.updateid }</sql:param>
			</sql:update>
			<c:redirect url="main.jsp"></c:redirect>
		</c:if>
	</head>
	<body>
		<h1>Edit</h1>
		<hr>
		<form action="?updateid=${rs.rows[0].id }" method="post">
		Name: <input name="cname" value="${rs.rows[0].cname}">
		<br>
		Account: <input id="account" name="account" value="${rs.rows[0].account}">
		<br>
		Password: <input name="password" type="password">
		<hr>
		<input type="submit" value="Update">
		</form>
	</body>
</html>