package tw.labs.lab01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONStringer;
import org.json.JSONWriter;

public class JDBC10 {

	public static void main(String[] args) {
		String sql = "SELECT e.LastName, e.FirstName, sum(od.UnitPrice * od.Quantity) sum " + "FROM orders o "
				+ "JOIN employees e ON (e.EmployeeID = o.EmployeeID) "
				+ "JOIN orderdetails od ON (od.OrderID = o.OrderID) " + "GROUP BY e.LastName, e.FirstName "
				+ "ORDER BY sum DESC";
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		String URL = "jdbc:mysql://127.0.0.1/northwind";
		
		//JSON化工具
		JSONStringer js = new JSONStringer();
		JSONWriter jw = js.array();
		
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			System.out.println("Link Start");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String last = rs.getString("LastName");
				String first = rs.getString("FirstName");
				String sum = rs.getString("sum");
//				System.out.printf("%s %s : %s\n", last, first, sum);
				
				jw.object();
				jw.key("LastName").value(last);
				jw.key("FirstName").value(first);
				jw.key("sum").value(sum);
				jw.endObject();
			}
			jw.endArray();
			System.out.println(jw.toString());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
