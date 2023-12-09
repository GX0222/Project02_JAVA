<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String start = request.getParameter("start");
	String rows = request.getParameter("rows");
	String cols = request.getParameter("cols");
	
	final int Start = (start == null || start.isEmpty()) ? 2 : Integer.parseInt( start );
	final int Rows = (rows == null || rows.isEmpty()) ? 2 : Integer.parseInt( rows );
	final int Cols = (cols == null || cols.isEmpty()) ? 4 : Integer.parseInt( cols );
%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>9981</title>
		<style type="text/css">
			table{
				width:100%;
				text-align: center;
			}
		</style>
	</head>
	<body>
	
		<form action="">
		Start: <input type="number" name="start">
			<input type="number" name="rows">
			x
			<input type="number" name="cols">
			<input type="submit" name="change">
		</form>
		
		<table border="1">
			<%
				for(int y=0 ; y<Rows ; y++){
					out.print("<tr>");
					int k = Start+(y*Cols);
					for( ; k < Start + (Cols*(y+1))&&k<10 ; k++){
						out.print("<td>");
						for(int i=1;i<10;i++){
							out.print(String.format("%d x %d = %d<br />", k, i, k*i));
						}	
						out.print("</td>");
					}
					out.print("</tr>");
				}
			%>	
		</table>
	</body>
</html>