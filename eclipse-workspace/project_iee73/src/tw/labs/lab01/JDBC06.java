package tw.labs.lab01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class JDBC06 {

	public static void main(String[] args) {

		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try {
			Scanner scanner = new Scanner(System.in);
			String key = scanner.next();
			// 連接 mysql
			Connection sqlConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/brad", prop);
			System.out.println("資料庫連接成功");
			String sql = "SELECT name,addr,tel FROM food WHERE name LIKE ? OR addr LIKE ? OR tel LIKE ?";
			String mykey ="%"+key+"%";
			PreparedStatement pstmt = sqlConn.prepareStatement(sql);
			pstmt.setString(1, mykey);
			pstmt.setString(2, mykey);
			pstmt.setString(3, mykey);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				String addr =rs.getString("addr");
				String tel = rs.getString("tel");
				System.out.printf("%s : %s : %s\n", name, addr, tel);
			}

			sqlConn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
