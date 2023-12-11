package tw.ken;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.ken.utils.MemberDB;
import tw.ken.utils.BCrypt;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private MemberDB memberDB;

	public Register() {
		try {
			memberDB = new MemberDB();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String cname = request.getParameter("cname");

		try {
			memberDB.addNew(account, password, cname);
			response.sendRedirect("brad24.jsp");
			// throw new SQLException();
		} catch (Exception e) {
			System.out.println(e);
			response.sendError(500, "Server Busy");
		}

	}

}
