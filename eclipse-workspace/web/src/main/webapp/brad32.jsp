<%@page import="tw.ken.utils.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	Member member1 = new Member();
 	member1.setId("1");
 	member1.setAccount("brad");
 	member1.setName("Brad");
%>
<jsp:useBean id="member2" class="tw.ken.utils.Member"></jsp:useBean>
<jsp:setProperty property="id" value="2" name="member2"/>
<jsp:setProperty property="account" value="amy" name="member2"/>
<jsp:setProperty property="name" value="Amy" name="member2"/>
 
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Member1:
		<%=member1.getId() %> : <%=member1.getName() %>
		<hr>
		Member2:
		<jsp:getProperty property="id" name="member2"/> : <jsp:getProperty property="name" name="member2"/>
		<hr>
		Member2:
		<%=member2.getId() %> : <%=member2.getName() %>
	</body>
</html>