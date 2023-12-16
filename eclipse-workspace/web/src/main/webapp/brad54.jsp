<%@page import="tw.ken.utils.BCrypt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<!DOCTYPE html>
<html>	
	<head>
		<meta charset="UTF-8">
		<title>AddNew</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	</head>
	
	<body>	
	
		<script>
			function checkAccount() {
				$('#mesg').load("checkAccount.jsp?account="+$('#account').val());
			}
			
			function checkData() {
				add();
			} 
			
			function add() {
				$.post("brad55.jsp",
						{
							account: $('#account').val(),
							password: $('#password').val(),
							cname: $('#cname').val()
						},
						function(data, status){
							if(status == 'success'){
								console.log('ajax success!'+ data);
								if(data.trim() != '0'){
									window.location.href='main.jsp';
								}
							}
						});
			}
		</script>
			
		Name: <input id="cname" name="cname">
		<br>
		Account: <input id="account" name="account" onblur="checkAccount()">
		<span id="mesg"></span>
		<br>
		Password: <input id="password" name="password" type="password">
		<hr>
		<input type="button" value="Add" onclick="checkData()">
		${err }
	</body>
</html>