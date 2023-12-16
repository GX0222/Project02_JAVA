<%@page import="tw.ken.utils.Bike"%>
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
<%
	int a = 10;
	session.setAttribute("a", a);
	a++;
	int[] b = {1,2,3,4};
	session.setAttribute("b", b);
	b[2] = 33;
	
	Bike b1 = new Bike();
	session.setAttribute("b1", b1);
	b1.upSpeed();b1.upSpeed();
	
	session.setMaxInactiveInterval(3);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	</head>
	<body>
		a = ${a }<br>
		a = <%=a %><br>
		<a href="brad63.jsp">Go To 63</a>
	</body>
</html>