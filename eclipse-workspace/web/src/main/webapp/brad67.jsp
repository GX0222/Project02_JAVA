<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="brad" %>
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
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	</head>
	<body>
		<h1>S A O</h1>
		<hr>
		<brad:test1 />
		<hr>
		<brad:test2 />
		<hr>
		<brad:sayHello user="Josh" />
		<hr>
		<brad:calc x="10" y="3">
			10 + 3 = ${plus }<br>
			10 - 3 = ${minus }<br>
			10 x 3 = ${multi }<br>
			10 / 3 = ${divide }<br>	
		</brad:calc>
		<hr>
		<table border="1" width="100%">
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<brad:test3 name="JAVA" price="2222"></brad:test3>
		</table>
	</body>
</html>