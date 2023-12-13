<%@page import="tw.ken.utils.BCrypt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<!DOCTYPE html>
<html>
	<c:catch var="err">
		<c:if test="${!empty param.account }">
			<c:if test="${pageContext.request.method == 'GET' }">
				<c:redirect url="main.jsp"></c:redirect>
			</c:if>
			<sql:setDataSource 
				driver="com.mysql.cj.jdbc.Driver" 
				url="jdbc:mysql://localhost/brad" 
				user="root"
				password="root"
			/>
			<sql:update>
				INSERT INTO member (account, cname, passwd) VALUES (?,?,?);
				<sql:param>${param.account }</sql:param>
				<sql:param>${param.cname }</sql:param>
				<sql:param>${BCrypt.hashpw(param.password, BCrypt.gensalt()) }</sql:param>
			</sql:update>
			<c:redirect url="main.jsp"></c:redirect>
		</c:if>
	</c:catch>
	
	<head>
		<meta charset="UTF-8">
		<title>AddNew</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
		<script>
			function checkAccount() {
				$('#mesg').load("checkAccount.jsp?account="+$('#account').val());
			}
		</script>
	</head>
	<body>
		<form action="" method="post">
		Name: <input name="cname">
		<br>
		Account: <input id="account" name="account" onblur="checkAccount()">
		<span id="mesg"></span>
		<br>
		Password: <input name="password" type="password">
		<hr>
		<input type="submit" value="Submit">
		</form>
		${err }
	</body>
</html>