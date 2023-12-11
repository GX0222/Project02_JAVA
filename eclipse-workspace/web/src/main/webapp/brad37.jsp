<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		1. ${paramValues.hobby[0]}<br>
		2. ${paramValues.hobby[1]}<br>
		3. ${paramValues.hobby[2]}<br>
		4. ${paramValues.hobby[3]}<br>
		5. ${paramValues.hobby[4]}<br>
		6. ${paramValues.hobby[5]}<br>
		<hr>
		Method: ${pageContext.request.method} : <%=request.getMethod()%>
		<hr>
		IP: ${pageContext.request.remoteAddr} : <%=request.getRemoteAddr()%>
		<hr>
		Locale: ${pageContext.request.locale} : <%=request.getLocale()%>
		<hr>
		Language: ${pageContext.request.locale.displayLanguage} : <%=request.getLocale().getDisplayLanguage() %>
		
	</body>
</html>