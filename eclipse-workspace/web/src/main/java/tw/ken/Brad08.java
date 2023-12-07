package tw.ken;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad08")
public class Brad08 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Brad09");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<h1>C8763</h1>");
		out.print("<hr />");
		
		request.setAttribute("x", "10");
		request.setAttribute("y", "16");
		
		dispatcher.include(request, response);
		
		out.print("SBS");
		
		response.flushBuffer();
		
	}


}
