<%@page import="tw.ken.utils.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	String ans = "";
	try{
		int ix = Integer.parseInt(x);
		int iy = Integer.parseInt(y);
		int op = Integer.parseInt(request.getParameter("op"));

		switch(op){
		case 1: ans += (ix + iy); break;
		case 2: ans += (ix - iy); break;
		case 3: ans += (ix * iy); break;
		case 4: ans += (ix / iy) + "..." + (ix % iy); break;
		}
	}catch(Exception e){
		x = y = ans ="";
	}
	
%>
<!DOCTYPE html>
<html>
		<head>
				<meta charset="UTF-8">
				<title>Calc</title>
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
		</head>
		<body>
				<h1>Calculator</h1>
				<form action="">
					<input name="x" value="<%=x %>" />
					<select name="op">
						<option value="1" >+</option>
						<option value="2" >-</option>
						<option value="3" >x</option>
						<option value="4" >/</option>
					</select>
					<input name="y" value="<%=y %>" />
					<input type="submit" value="=" />
					<span><%=ans %></span>
				</form>
		</body>
</html>