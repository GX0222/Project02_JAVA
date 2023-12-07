package tw.ken;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.ken.utils.BradUtils;
import tw.ken.utils.MyCalc;

//View
@WebServlet("/Brad13")
public class Brad13 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String x = request.getParameter("x");
		String y = request.getParameter("y");

		String web = "";
		try {
			MyCalc myCalc = (MyCalc) request.getAttribute("myCalc");
			String view = (String) request.getAttribute("view");
			web = BradUtils.loadView(view);
			String op = request.getParameter("op");
			String[] ops = { "", "", "", "" };
			String cal = myCalc.calcu(op);
			if (op != null) {
				switch (op) {
				case "2": {
					ops[1] = "selected";
					break;
				}
				case "3": {
					ops[2] = "selected";
					break;
				}
				case "4": {
					ops[3] = "selected";
					break;
				}
				default: {
					ops[0] = "selected";
					break;
				}
				}
			}
			out.printf(web, x, ops[0], ops[1], ops[2], ops[3], y, cal);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("B13");
			out.printf(web, "", "selected", "", "", "", "", "");
		}

	}

}
