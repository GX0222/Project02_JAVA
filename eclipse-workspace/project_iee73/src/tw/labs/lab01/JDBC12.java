package tw.labs.lab01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC12 {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/brad";
	private static Connection sqlConn;
	private static final String SQL_QUERY = "SELECT * FROM member WHERE id =?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);

		try {
			sqlConn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = sqlConn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				InputStream in = rs.getBinaryStream("icon");
				FileOutputStream fout = new FileOutputStream("dir2/ball.png");
				byte[] buf = new byte[64*1024];
				int len = in.read(buf);
				fout.write(buf, 0, len);
				fout.flush();
				fout.close();
				System.out.println("OK");
				
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
