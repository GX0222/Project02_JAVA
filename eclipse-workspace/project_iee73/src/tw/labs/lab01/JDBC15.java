package tw.labs.lab01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC15 {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/brad";
	private static Connection sqlConn;
	private static final String SQL_QUERY = "SELECT * FROM cust";

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);

		try {
			sqlConn = DriverManager.getConnection(URL,prop);
			//定義可移動指標
			PreparedStatement pstmt = sqlConn.prepareStatement(
					SQL_QUERY,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE
					);

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String cname = rs.getString("cname");
				System.out.printf("%s : %s\n", id, cname);
			}
			System.out.println("-----");
			
			if (rs.first()) {
				System.out.println("Move Ok");
				String id = rs.getString("id");
				String cname = rs.getString("cname");
				System.out.printf("%s : %s\n", id, cname);
				
				rs.absolute(4);
				id = rs.getString("id");
				cname = rs.getString("cname");
				System.out.printf("%s : %s\n", id, cname);
				
				rs.updateString("cname", "Tony");
				rs.updateString("tel", "2344");
				//rs.updateRow();
				id = rs.getString("id");
				cname = rs.getString("cname");
				System.out.printf("%s : %s\n", id, cname);
				
				System.out.println("-----");
				
				rs.absolute(2);
				//rs.deleteRow();
				
				System.out.println("-----");
				
				rs.moveToInsertRow();
				rs.updateString("cname", "Keria");
				rs.updateString("tel", "8888");
				rs.updateString("birthday", "1999-02-22");
				rs.insertRow();
				
			}else {
				System.out.println("Move Fail");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
