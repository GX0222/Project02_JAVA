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

import org.json.JSONArray;
import org.json.JSONObject;

public class JDBC05 {

	public static void main(String[] args) {

		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		try {
			// 連接 mysql
			Connection sqlConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/brad", prop);
			System.out.println("資料庫連接成功");
			Statement stmt = sqlConn.createStatement();
			String sql = "SELECT * FROM food";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String lat = rs.getString("lat");
				String lng = rs.getString("lng");
				System.out.printf("%s : %s : %s : %s\n", id, name, lat, lng);
			}

			sqlConn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
