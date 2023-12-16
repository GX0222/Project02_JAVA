<%@tag import="java.util.HashMap"%>

<%@ tag language="java" pageEncoding="UTF-8"%>
<%@tag dynamic-attributes="product" %>

<%
	HashMap<String,String> detail = 
		(HashMap<String,String>)jspContext.getAttribute("product");
	String html = 
			"<tr><td>"+detail.get("name")+"</td><td>"+detail.get("price")+"</td></tr>";
	out.print(html);
%>