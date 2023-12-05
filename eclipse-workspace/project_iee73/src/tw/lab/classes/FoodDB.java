package tw.lab.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class FoodDB {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/brad";
	private static final String SQL_QUERY = "SELECT * FROM food";

	private Connection sqlConn;
	private ResultSet rs;
	String[] fieldNames;

	public FoodDB() throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);

		sqlConn = DriverManager.getConnection(URL, prop);
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
			fieldNames[i] = rsmd.getColumnName(i+1);
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
	
	//傳入的 row、col => 從0開始
	public String getData(int row, int col) {
		try {
			rs.absolute(row+1); //sql從1開始
			return rs.getString(fieldNames[col]);
		} catch (SQLException e) {
			return "Error";
		}
	}
	
	public String[] getHeader() {
		return fieldNames;
	}
	
	public void delRow() throws Exception{
		rs.deleteRow();
	}
	
	public void moveNewRow() {
		try {
			rs.moveToInsertRow();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void updateDB(int row,int col,String value) {
		try {
			rs.absolute(row+1);
			rs.updateString(col+1, value);
			rs.updateRow();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
