package tw.ken;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad16")
public class Brad16 extends HttpServlet {

	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/brad";
	private Connection conn;
	private static final String SQL_QUERY = "SELECT * FROM food";

	public Brad16() {

		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
			conn = DriverManager.getConnection(URL, prop);
			System.out.println("OK2");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_QUERY);
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<table border='1' width='100%'>");
			while(rs.next()) {
				out.write("<tr>");
				out.printf("<td>%s</td>", rs.getString("id"));
				out.printf("<td>%s</td>", rs.getString("name"));
				out.printf("<td><img src='%s' width='160px' height='90px' /></td>", rs.getString("pic"));
				out.print("</tr>");
			}
			out.write("</table>");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
