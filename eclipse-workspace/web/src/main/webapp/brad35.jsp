<%@page import="tw.ken.utils.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
			<input name="x" value="${param.x }" />
			<select name="op">
				<option value="1" ${param.op == 1 ? "selected" : ""}>+</option>
				<option value="2" ${param.op == 2 ? "selected" : ""} >-</option>
				<option value="3" ${param.op == 3 ? "selected" : ""}>x</option>
				<option value="4" ${param.op == 4 ? "selected" : ""}>/</option>
			</select>
			<input name="y" value="${param.y }" />
			<input type="submit" value="=" />
			<span>${BradUtils.calc(param.x, param.y, param.op)}</span>
		</form>
	</body>
</html>