<%@page import="tw.ken.utils.BCrypt"%>
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
<c:catch var="err">
	<sql:update var="n">
		INSERT INTO member (account, cname, passwd) VALUES (?,?,?);
		<sql:param>${param.account }</sql:param>
		<sql:param>${param.cname }</sql:param>
		<sql:param>${BCrypt.hashpw(param.password, BCrypt.gensalt()) }</sql:param>
	</sql:update>
	${n}
</c:catch>
<c:if test="${!empty err }">0</c:if>