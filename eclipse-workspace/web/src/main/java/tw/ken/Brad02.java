package tw.ken;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Brad02
 */
@WebServlet("/Brad02")
public class Brad02 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			String value = request.getHeader(name)+"\n";
			System.out.printf("%s : %s", name, value);
			response.getWriter().append(name).append(":").append(value);
		}
		System.out.println("------");
	}

}
