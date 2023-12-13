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
		<title>Insert title here</title>
	</head>
	<body>
		<sql:update>
			INSERT INTO cust(cname,tel,birthday) VALUES ("K","0988","1999-02-22")
		</sql:update>
	</body>
</html>