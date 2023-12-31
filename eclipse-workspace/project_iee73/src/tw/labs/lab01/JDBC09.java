package tw.labs.lab01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import org.json.JSONStringer;
import org.json.JSONWriter;

import com.mysql.cj.xdevapi.PreparableStatement;

import tw.lab.classes.BCrypt;
import tw.lab.classes.Member;

public class JDBC09 {
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/brad";
	private static final String SQL_LOGIN = "SELECT * FROM member WHERE account = ?";
	private static final String SQL_CHPASSWD = "UPDATE member SET passwd = ? WHERE id = ?";
	private static Connection sqlConn;

	public static void main(String[] args) {
		// User Input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.next();
		System.out.print("Password: ");
		String passwd = scanner.next();

		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);

		String hashPasswd = hashPW(passwd);

		try {
			sqlConn = DriverManager.getConnection(URL, prop);
			Member member;
			if ((member = login(account, passwd)) != null) {
				System.out.println("登入成功，歡迎 " + member.getCname());
				//產生 member JSON
				JSONStringer js = new JSONStringer();
				JSONWriter jw = js.object();
				jw.key("id").value(member.getId());
				jw.key("name").value(member.getCname());
				jw.key("Account").value(member.getAccount());
				jw.endObject();
				System.out.println(jw);
				
				System.out.println("變更密碼: ");
				String newPasswd = scanner.next();
				if (chPasswd(member, newPasswd)) {
					System.out.println("變更成功");
				} else {
					System.out.println("變更失敗");
				}
			} else {
				System.out.println("登入失敗");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	static Member login(String account, String passwd) {
		try {
			PreparedStatement pstmtC = sqlConn.prepareStatement(SQL_LOGIN);
			pstmtC.setString(1, account);
			ResultSet rs = pstmtC.executeQuery();
			if (rs.next()) {
				String hashPasswd = rs.getString("passwd");
				if (BCrypt.checkpw(passwd, hashPasswd)) {
					Member member = new Member(rs.getInt("id"), rs.getString("account"), rs.getString("cname"));
					return member;
				} else {
					return null;
				}
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}//

	static String hashPW(String passwd) {
		return BCrypt.hashpw(passwd, BCrypt.gensalt());
	}//

	static boolean chPasswd(Member member, String newPasswd) {
		int id = member.getId();
		try {
			PreparedStatement pstmtCP = sqlConn.prepareStatement(SQL_CHPASSWD);
			pstmtCP.setString(1, hashPW(newPasswd));
			pstmtCP.setInt(2, id);
			int num = pstmtCP.executeUpdate();
			if (num == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
