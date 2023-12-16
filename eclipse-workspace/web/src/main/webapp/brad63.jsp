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
	//Integer a = (Integer)session.getAttribute("a");
	int[] b = (int[])session.getAttribute("b");
	if(b == null){
		response.sendRedirect("brad62.jsp");
	}
		int bb = b[2];
	Bike b1 = (Bike)session.getAttribute("b1");
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
		b = ${b }<br>
		bb = <%=bb %><br>
		b1 = <%=b1.getSpeed() %><br>
		<a href="brad62.jsp">Go To 62</a>
		<a href="brad64.jsp">Go To 64</a>
	</body>
</html>