package tw.labs.lab01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC01 {

	public static void main(String[] args) {
		// 1. Load Driver 可以省略
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驅動載入成功");
		} catch (Exception e) {
			System.out.println(e);
		}
		//---------------------------------------------------
		
		// 2. 連接sql
		try {
//			Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://127.0.0.1:3306/brad?user=root&password=root");
			
//			Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://127.0.0.1:3306/brad","root","root");
			
			Properties prop = new Properties();
			prop.put("user","root" );
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/brad",prop);
			System.out.println("資料庫連接成功");
			
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM cust";
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
