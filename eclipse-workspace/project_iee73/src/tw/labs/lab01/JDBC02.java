package tw.labs.lab01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class JDBC02 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/brad", prop);
			System.out.println("資料庫連接成功");
			String name = "Kirito";
			String tel = "48763";
			String birthday = "1999-02-22";
			String sql = "INSERT INTO cust(cname,tel,birthday) VALUES (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, birthday);
			pstmt.executeUpdate();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
