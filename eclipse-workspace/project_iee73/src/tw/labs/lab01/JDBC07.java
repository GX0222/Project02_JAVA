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

public class JDBC07 {

	public static void main(String[] args) {
		System.out.print("Page: ");
		Scanner scanner = new Scanner(System.in);
		int page = scanner.nextInt();
		System.out.println("-----");

		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		final int rpp = 10;
		int start = (page - 1) * rpp;

		try {
			// 連接 mysql
			Connection sqlConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/brad", prop);
			System.out.println("資料庫連接成功");

			String check = "SELECT COUNT(*) count FROM food";
			Statement stmt = sqlConn.createStatement();
			ResultSet rscheck = stmt.executeQuery(check);
			rscheck.next();
			int count = rscheck.getInt("count");
			int pages = (int) Math.ceil(count * 1.0 / rpp);
			if (page <= 0 || page > pages) {
				throw new MyException("Page Error");
			}

			String sql = "SELECT * FROM food ORDER BY id LIMIT ?, ?";
			PreparedStatement pstmt = sqlConn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, rpp);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				System.out.printf("%s : %s : %s : %s\n", id, name, addr, tel);
			}

			sqlConn.close();
		} catch (MyException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

class MyException extends Exception {
	private String mesg;

	public MyException(String mesg) {
		this.mesg = mesg;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return mesg;
	}
}
