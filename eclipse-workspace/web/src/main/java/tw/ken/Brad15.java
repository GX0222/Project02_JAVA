package tw.ken;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.FocusAdapter;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad15")
public class Brad15 extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedImage img = ImageIO.read(new File("G:\\我的雲端硬碟\\圖片\\桌布\\魔物獵人_世界_01.png"));
		Graphics2D g2d = img.createGraphics();
		
		AffineTransform tran = new AffineTransform();
		tran.rotate(Math.toRadians(87));
		Font font1 =new Font(null, Font.BOLD, 50);
		Font font2 = font1.deriveFont(tran);
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(font2);
		g2d.drawString("星爆氣流斬", 700, 700);
		
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		ImageIO.write(img, "png", os);
		
		//ImageIO.write(img, "png", new File(null)); 另存新檔
		
	}

}
