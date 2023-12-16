<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Properties"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
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
<c:set var="rpp" value="10"></c:set>
<c:set var="start" value="${(param.page-1)*rpp }"></c:set>

<sql:query var="rs">
	SELECT * FROM food LIMIT ${start }, ${rpp };
</sql:query>
<c:forEach items="${rs.rows}" var="food" varStatus="status">
</c:forEach>

<%

	//1. input p
	int p = Integer.parseInt(request.getParameter("page"));
	 
	//2. output json
	JSONObject root = new JSONObject();
	if(p <= 0){
		root.put("error", 1);
		root.put("page", p);
		out.print(root.toString());
		return;
	}else if( p > 10){
		root.put("error", 2);
		root.put("page", p);
		out.print(root.toString());
		return;
	}
	
	root.put("error", 0);
	root.put("page", p);
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		String sql = "SELECT * FROM food LIMIT ?, ?";
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/brad",prop);
		int start = (p-1)*10;
		int end = p*10;
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		ResultSet rs = pstmt.executeQuery();
	
		JSONArray arr = new JSONArray();
		while(rs.next()){
			JSONObject data = new JSONObject();
			data.put("name", rs.getString("name"));
			data.put("tel", rs.getString("tel"));
			data.put("addr", rs.getString("addr"));
			arr.put(data);
		}
		
		root.put("data", arr);
		out.print(root.toString());
	
	}catch(Exception e){
		out.print(e);
		return;
	}
	
	
%>