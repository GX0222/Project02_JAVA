package tw.ken;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad14")
public class Brad14 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int w = 400, h = 24;
		double rate = 0;
		try {
			rate = Double.parseDouble(request.getParameter("rate"))*0.01;
		}catch(Exception e){
			rate = 0;
		}

		response.setContentType("image/jpeg");

		BufferedImage img = new BufferedImage(400, 24, BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = img.createGraphics();

		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0, 0, w, h);
		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, (int)(w*rate), h);

		OutputStream os = response.getOutputStream();
		ImageIO.write(img, "jpeg", os);

		response.flushBuffer();
	}

}
