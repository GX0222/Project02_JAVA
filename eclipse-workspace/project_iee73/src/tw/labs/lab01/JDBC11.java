package tw.labs.lab01;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC11 {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/brad";
	private static Connection sqlConn;
	private static final String SQL_UPDATE = 
			"UPDATE member SET icon = ? WHERE id = ?";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		try {
			sqlConn = DriverManager.getConnection(URL,prop);
			PreparedStatement pstmt = sqlConn.prepareStatement(SQL_UPDATE);
			FileInputStream fin = new FileInputStream("dir1/去背寶貝球.png");
			pstmt.setBinaryStream(1, fin);
			pstmt.setInt(2, 1);
			
			if(pstmt.executeUpdate()>0) {
				System.out.println("Update Success");
			}else {
				System.out.println("Fail");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
