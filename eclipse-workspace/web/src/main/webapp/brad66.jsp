<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
		<%
			Locale locale = request.getLocale();
			String lang = locale.getLanguage();
			String country = locale.getCountry();
			out.print(lang + "_" + country);
			String langCountry = lang + "_" + country;
			pageContext.setAttribute("langCountry", langCountry);
			
			Date now = new Date();
			pageContext.setAttribute("now", now);
		%>
		<hr>
		Language: ${pageContext.request.locale.language }<br>
		Country: ${pageContext.request.locale.country }<br>
		<fmt:setLocale value="${langCountry}"/>
		<fmt:setBundle basename="res"/>
		<hr>
		<h1><fmt:message key="companyName"/></h1>
		<hr>
		<h4><fmt:message key="hello"/> <fmt:message key="world"/></h4>
		<hr>
		<fmt:setTimeZone value="Asia/Taipei"/>
		<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss"/>
		<hr>
		<fmt:setTimeZone value="Asia/Tokyo"/>
		<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss"/>
		<hr>

		<fmt:formatNumber value="1234567.7654321"
			type="currency" currencyCode="EUR"/>
	</body>
</html>