<%@page import="javax.servlet.jsp.jstl.sql.Result"%>
<%@page import="java.util.SortedMap"%>
<%@page import="java.sql.ResultSet"%>
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
	<sql:query var="rs">
		SELECT * FROM food;
	</sql:query>
	<%
		Object obj = new Object();
		obj = pageContext.getAttribute("rs");
		Result rs = (Result)obj;
		SortedMap[] rows = rs.getRows();
		for (SortedMap row : rows){
			out.print(row.get("name")+" : "+row.get("tel"));
		}
	%>
	
	
	
	
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	</head>
	<body>
		
	</body>
</html>