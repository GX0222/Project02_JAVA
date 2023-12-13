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
	<sql:query var="rs">SELECT * FROM member</sql:query>
	<c:if test="${!empty param.delid }">
		<sql:update>
			DELETE FROM member WHERE id = ?
			<sql:param>${param.delid }</sql:param>
		</sql:update>
		<c:redirect url="?"></c:redirect>
	</c:if>
	<head>
		<meta charset="UTF-8">
		<title>Main</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	</head>
	<body>
		<h1>Main</h1>
		<hr>
		<a href="addnew.jsp">AddNew</a>
		<table width="100%">
			<tr>
				<th class="border">id</th>
				<th class="border">Name</th>
				<th class="border">Icon</th>
				<th class="border">Bike</th>
				<th class="border">Del</th>
				<th class="border">Edit</th>
			</tr>
			<c:forEach items="${rs.rows }" var="cust">
				<tr>
					<td class="border">${cust.id }</td>
					<td class="border">${cust.cname }</td>
					<td class="border">${cust.icon }</td>
					<td class="border">${cust.bike }</td>
					<td class="border"><a href="?delid=${cust.id }" onclick="return delAlert('${cust.cname}')">Del</a></td>
					<td class="border"><a href="edit.jsp?editid=${cust.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<script>
			function delAlert(cname){
				var isDel = confirm("Delete " + cname + " ?");
				return isDel;
			}
		</script>
	</body>
</html>