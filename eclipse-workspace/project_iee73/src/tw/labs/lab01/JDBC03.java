package tw.labs.lab01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class JDBC03 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/brad", prop);
			System.out.println("資料庫連接成功");
			String name = "Asuna";
			int id = 3;
			String sql = "UPDATE cust SET cname = ? WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, id);

			pstmt.executeUpdate();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
