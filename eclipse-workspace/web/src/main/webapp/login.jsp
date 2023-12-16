<%@page import="tw.ken.utils.BCrypt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
	<c:choose>
		<c:when test="${!empty param.account }">
			<sql:setDataSource 
				driver="com.mysql.cj.jdbc.Driver" 
				url="jdbc:mysql://localhost/brad" 
				user="root"
				password="root"
			/>
			<sql:query var="rs">
				SELECT * FROM member WHERE account = ?
				<sql:param>${param.account }</sql:param>
			</sql:query>
			<c:choose>
				<c:when test="${rs.rowCount > 0 }">
					<c:set var="password" value="${rs.rows[0].passwd }"></c:set>
					<c:choose>
						<c:when test="${BCrypt.checkpw(param.password, password)}">
							<jsp:useBean id="member" class="tw.ken.utils.Member"></jsp:useBean>
							<jsp:setProperty property="id" value="${rs.rows[0].id }" name="member"/>
							<jsp:setProperty property="account" value="${rs.rows[0].account }" name="member"/>
							<jsp:setProperty property="name" value="${rs.rows[0].cname }" name="member"/>
							<c:set var="member" value="${member}" scope="session"></c:set>
							<c:redirect url="main.jsp"></c:redirect>
						</c:when>
						<c:otherwise>
							<c:set var="msg">密碼錯誤</c:set>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:set var="msg">帳號不存在</c:set>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:set var="msg">請輸入帳號</c:set>
		</c:otherwise>
	</c:choose>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	</head>
	<body>
		<h1>Login</h1>
		<form action="">
		Account: <input name="account">
		<br>
		Password: <input name="password" type="password">
		<hr>
		<input type="submit" value="Submit">
		</form>
		${msg}
	</body>
</html>