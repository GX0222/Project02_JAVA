package tw.labs.lab01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

import tw.lab.classes.BCrypt;

public class JDBC08 {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/brad";
	private static final String SQL_INSERT = "INSERT INTO member (account,passwd,cname) VALUES (?,?,?)";
	private static final String SQL_CHECK = "SELECT COUNT(*) count FROM member WHERE account = ?";
	private static Connection sqlConn;

	public static void main(String[] args) {
		// User Input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.next();
		System.out.print("Password: ");
		String passwd = scanner.next();
		System.out.print("Name: ");
		String name = scanner.next();

		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);

		String hashPasswd = hashPW(passwd);

		try {
			sqlConn = DriverManager.getConnection(URL, prop);
			// Check Account
			if(!checkAccount(account)) {
				System.out.println("帳號已存在");
			}else {
				// Insert Into member
				addMember(account, hashPasswd, name);
				System.out.println("新增會員成功");
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	static boolean checkAccount(String account) {
		try {
			PreparedStatement pstmtC = sqlConn.prepareStatement(SQL_CHECK);
			pstmtC.setString(1, account);
			ResultSet rs = pstmtC.executeQuery();
			rs.next();
			int num = rs.getInt("count");
			if(num == 0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return true;
	}//

	static boolean addMember(String account, String passwd, String name) {
		PreparedStatement pstmt;
		try {
			pstmt = sqlConn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, account);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}//

	static String hashPW(String passwd) {
		return BCrypt.hashpw(passwd, BCrypt.gensalt());
	}//
}
