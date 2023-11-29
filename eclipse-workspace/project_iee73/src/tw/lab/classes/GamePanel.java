package tw.lab.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private BallImg[] ballImg;
	private int viewW, viewH;
	private Timer timer;
	private LinkedList<BallTask> balls;

	public GamePanel() {
		setBackground(Color.YELLOW);

		try {
			ballImg = new BallImg[3];
			ballImg[0] = new BallImg(ImageIO.read(new File("dir1/去背螺旋丸.png")));
			ballImg[1] = new BallImg(ImageIO.read(new File("dir1/去背月球.png")));
			ballImg[2] = new BallImg(ImageIO.read(new File("dir1/去背寶貝球.png")));

		} catch (IOException e) {
			System.out.println(e);
			System.exit(0);
		}
		balls = new LinkedList<>();

		addMouseListener(new MyListener());

		timer = new Timer();
//		timer.schedule(new BallTask(), 1 * 1000, 10);
		timer.schedule(new RefreshTask(), 0, 1);

	}

	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			creatBall(e.getX(), e.getY());
		}
	}

	private void creatBall(int x, int y) {
		int ballIndex = (int) (Math.random() * 3);
		BallTask ball = new BallTask(x - (int) (ballImg[ballIndex].w / 2.0), y - (int) (ballImg[ballIndex].h / 2.0),
				(int) (Math.random() * 6), (int) (Math.random() * 6), ballIndex);

		timer.schedule(ball, 500, 10);
		balls.add(ball);
	}

	private class RefreshTask extends TimerTask {
		@Override
		public void run() {
			repaint();

		}
	}

	private class BallTask extends TimerTask {
		int x, y, dx, dy, ballIndex;

//		BallImg img;
		public BallTask(int x, int y, int dx, int dy, int ballIndex) {
			this.x = x;
			this.y = y;
			this.dx = dx;
			this.dy = dy;
			this.ballIndex = ballIndex;
		}

		@Override
		public void run() {
			if (x <= 0 || x + ballImg[ballIndex].w >= viewW) {
				dx *= -1;
			} else if (y <= 0 || y + ballImg[ballIndex].h >= viewH) {
				dy *= -1;
			}

			x += dx;
			y += dy;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		viewW = getWidth();
		viewH = getHeight();

		Graphics2D g2d = (Graphics2D) g;

		for (BallTask ball : balls) {
			g2d.drawImage(ballImg[ball.ballIndex].img, ball.x, ball.y, null);
		}

//		

	}

}
//------------------------------------------------------

class BallImg {
	BufferedImage img;
	int w, h;

	public BallImg(BufferedImage img) {
		this.img = img;
		w = img.getWidth();
		h = img.getHeight();
	}
}
