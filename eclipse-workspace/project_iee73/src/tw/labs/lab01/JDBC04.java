package tw.labs.lab01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class JDBC04 {

	public static void main(String[] args) {

		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			// 連接目標網站
			System.out.println("開始連接..");
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx?&UnitId=193");
			URLConnection urlConn = url.openConnection();
			System.out.println("目標網站連接成功");

			// 連接 mysql
			Connection sqlConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/brad", prop);
			System.out.println("資料庫連接成功");
			Statement stmt = sqlConn.createStatement();
			//砍全部
			stmt.execute("DELETE FROM food");
			//歸零
			stmt.execute("ALTER TABLE food AUTO_INCREMENT =1");
			//撈資料
			String sql = "INSERT INTO food (name,addr,tel,pic,lat,lng) VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt = sqlConn.prepareStatement(sql);

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));) {
				String line;
				StringBuffer sb = new StringBuffer();
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				JSONArray root = new JSONArray(sb.toString());
				//test
				for (Object row : root) {
					JSONObject data = (JSONObject) row;
					String name = data.getString("Name");
					String addr = data.getString("Address");
					String tel = data.getString("Tel");
					String pic = data.getString("PicURL");
					String lat = data.getString("Latitude");
					lat = lat.replaceAll("\\s", "");
					if (lat == null || lat.isEmpty()) {
						lat = "0.0";
					}
					String lng = data.getString("Longitude");
					lng = lng.replaceAll("\\s", "");
					if (lng == null || lng.isEmpty()) {
						lng = "0.0";
					}
					// -----------
					pstmt.setString(1, name);
					pstmt.setString(2, addr);
					pstmt.setString(3, tel);
					pstmt.setString(4, pic);
					pstmt.setDouble(5, Double.parseDouble(lat));
					pstmt.setDouble(6, Double.parseDouble(lng));
					pstmt.executeUpdate();
				}
			}
			System.out.println("Done");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
