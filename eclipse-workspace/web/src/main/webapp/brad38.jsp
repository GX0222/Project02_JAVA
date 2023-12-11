<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] name1 = {"Brad", "Kirit", "Asuna", "MHW"};
	//pageContext.setAttribute("nameArr", name1);
	
	String[] name2 = {"Brad2", "Kirit2", "Asuna2", "MHW2"};
	//request.setAttribute("nameArr", name2);
	
	String[] name3 = {"Brad3", "Kirit3", "Asuna3", "MHW3"};
	//session.setAttribute("nameArr", name3);
	
	String[] name4 = {"Brad4", "Kirit4", "Asuna4", "MHW4"};
	application.setAttribute("nameArr", name4);
	
	LinkedList<String> list = new LinkedList<>();
	list.add("aa"); list.add("bb"); list.add("cc");
	pageContext.setAttribute("list", list);
	
	HashMap<String,Object> map =new HashMap<>();
	map.put("name","Brad");
	map.put("gender",true);
	map.put("age",18);
	pageContext.setAttribute("map", map);
	
%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		name1[1] => ${nameArr[1]}<br>
		name1[1] => ${pageScope.nameArr[1]}<br>
		name2[1] => ${requestScope.nameArr[1]}<br>
		name3[1] => ${sessionScope.nameArr[1]}<br>
		name4[1] => ${applicationScope.nameArr[1]}<br>
		<hr>
		list[2] => ${list[param.i] }<br>
		map[name] => ${map["name"] }<br>
		map.name => ${map.name }<br>
		${param.x == 10 }
	</body>
</html>