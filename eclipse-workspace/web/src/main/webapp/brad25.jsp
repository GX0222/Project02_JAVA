<%@page import="tw.ken.utils.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = "";
	request.setCharacterEncoding("UTF-8");
	String account = request.getParameter("account");
	String password = request.getParameter("password");
	
	if(account != null && password != null){
		String USER = "root";
		String PASSWD = "root";
		String URL = "jdbc:mysql://127.0.0.1/brad";
		String SQL_QUERY = "SELECT * FROM food";
		String SQL_INSERT = "INSERT INTO member (account,passwd,cname) VALUES (?,?,?)";
		String SQL_LOGIN = "SELECT * FROM member WHERE account = ?";
		
		Connection sqlConn;
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		sqlConn = DriverManager.getConnection(URL, prop);
		
		PreparedStatement pstmt = sqlConn.prepareStatement(SQL_LOGIN);
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			if (BCrypt.checkpw(password, rs.getString("passwd"))) {
				response.sendRedirect("main.jsp");
			}else {
				msg = "Login Failure";
			}
		}else {
			msg = "Login Failure";
		}
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
		<hr>
		<h2>Login</h2>
		<form>
			Account: <input name="account"><br>
			Password: <input type="password" name="password"><br>
			<input type="submit" value="Login">
		</form>
		<hr>
		<div><%=msg %></div>
	</body>
</html>