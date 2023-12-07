package tw.ken;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/Brad07")
@MultipartConfig(
		location = "D:\\資展_EEIT73\\MyGit\\Project02_JAVA\\eclipse-workspace\\web\\src\\upload"
		)
public class Brad07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Part> parts = request.getParts();
		for(Part part:parts) {
			String type = part.getContentType();
			long size = part.getSize();
			if(type != null && size>0) {
				part.write(part.getSubmittedFileName());
			}

		}
	}

}
