package tw.ken.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MemberDB {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/brad";
	private static final String SQL_QUERY = "SELECT * FROM food";
	private static final String SQL_INSERT = "INSERT INTO member (account,passwd,cname) VALUES (?,?,?)";
	private static final String SQL_LOGIN = "SELECT * FROM member WHERE account = ?";

	private Connection sqlConn;
	private ResultSet rs;
	String[] fieldNames;

	public MemberDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);

		Class.forName("com.mysql.cj.jdbc.Driver");
		sqlConn = DriverManager.getConnection(URL, prop);
	}
	
	public boolean login(String account, String password) throws Exception {
		PreparedStatement pstmt = sqlConn.prepareStatement(SQL_LOGIN);
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			if (BCrypt.checkpw(password, rs.getString("passwd"))) {
				System.out.println("PASSWORD YES");
				return true;
			}else {
				System.out.println("PASSWORD ERR");
				return false;
			}
		}else {
			System.out.println("ACCOUNT ERR");
			return false;
		}

	}
	
	public int addNew(String account, String password, String cname) throws Exception {
		PreparedStatement pstmt = sqlConn.prepareStatement(SQL_INSERT);
		String hashPW = BCrypt.hashpw(password, BCrypt.gensalt());
		pstmt.setString(1, account);
		pstmt.setString(2, hashPW);
		pstmt.setString(3, cname);
		
		return pstmt.executeUpdate();
	}

	public void queryDB() throws Exception {
		queryDB(SQL_QUERY);
	}

	public void queryDB(String sql) throws Exception {
		Statement stmt = sqlConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		fieldNames = new String[rsmd.getColumnCount()];
		for (int i = 0; i < fieldNames.length; i++) {
			fieldNames[i] = rsmd.getColumnName(i + 1);
		}
	}

	public int getRows() {
		try {
			rs.last();
			return rs.getRow(); // getRow為游標目前指到第幾筆
		} catch (Exception e) {
			return 0;
		}
	}

	public int getCols() {
		return fieldNames.length;
	}

	// 傳入的 row、col => 從0開始
	public String getData(int row, int col) {
		try {
			rs.absolute(row + 1); // sql從1開始
			return rs.getString(fieldNames[col]);
		} catch (SQLException e) {
			return "Error";
		}
	}

	public String[] getHeader() {
		return fieldNames;
	}

	public void delRow() throws Exception {
		rs.deleteRow();
	}

	public void moveNewRow() {
		try {
			rs.moveToInsertRow();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void updateDB(int row, int col, String value) {
		try {
			rs.absolute(row + 1);
			rs.updateString(col + 1, value);
			rs.updateRow();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
