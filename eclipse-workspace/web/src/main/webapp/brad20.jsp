<%@ page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="brad21.jsp" %>
<%
	String name = request.getParameter("name");
	if(name == null){
		name="Kirito";
	}
%>

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>	
	<body>
		<h1>SAO</h1>
		<hr />
		<div>
			<%=name %>
			星爆氣流斬, <%out.print("16連擊"); %>
			<hr />
			Lottery: <%=(int)(Math.random()*49+1) %>
		</div>
		<hr />
			Lottery: <%
							HashSet<Integer> set = new HashSet<>();
							while(set.size()<6){
								set.add((int)(Math.random()*49+1));
							}
							out.print(set);
						%>
	</body>	
</html>