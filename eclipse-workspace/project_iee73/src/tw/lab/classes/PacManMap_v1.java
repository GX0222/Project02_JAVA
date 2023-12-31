package tw.lab.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import javax.swing.JPanel;

public class PacManMap_v1 extends JPanel {

	private int uniLong = 50;
	private LinkedList<Wall> wallList;

	// 建構式
	public PacManMap_v1() {
		wallList = new LinkedList<>();
	}//

	// 畫布
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);

		int startx, starty, startx2, starty2, endx, endy;

		for (int i = 0; i < 5; i++) {
			Point point1 = new Point();
			Point point2 = new Point();
			startx = uniLong * (int) (Math.random() * 15 + 1);
			starty = uniLong * (int) (Math.random() * 13 + 1);
			endx = uniLong * (int) (Math.random() * 15 + 1);

			while (startx == endx || isCover(startx, endx, 0)) {
				startx = uniLong * (int) (Math.random() * 15 + 1);
				starty = uniLong * (int) (Math.random() * 13 + 1);
				endx = uniLong * (int) (Math.random() * 15 + 1);
			}

			getPoints(startx, endx, starty, 0);
			g2d.drawLine(startx, starty, endx, starty);
		} // for

		for (int i = 0; i < 5; i++) {
			startx2 = uniLong * (int) (Math.random() * 15 + 1);
			starty2 = uniLong * (int) (Math.random() * 13 + 1);
			endy = uniLong * (int) (Math.random() * 13 + 1);

			while (starty2 == endy || isCover(starty2, endy, 1)) {
				startx2 = uniLong * (int) (Math.random() * 15 + 1);
				starty2 = uniLong * (int) (Math.random() * 13 + 1);
				endy = uniLong * (int) (Math.random() * 13 + 1);
			}
			getPoints(starty2, endy, startx2, 1);
			g2d.drawLine(startx2, starty2, startx2, endy);
		} // for

	}// paintComponent

	private boolean isCover(Point reqPoint, int type) {
		for (Wall wall : wallList) {
			if (wall.xytype == type) {
				for (Point point : wall.points) {
					if (point == reqPoint) {
						return true;
					}
				}

			}
		}
		return false;
	}
	//

	private boolean isCross(int index) {

		return true;
	}

	private void getPoints(int req1, int req2, int req3, int type) {
		int len = (int) Math.abs(req1 - req2);
		Wall wall = new Wall();
		wall.points = new LinkedList<>();
		Point point = new Point();
		wall.xytype = type;
		if (req1 > req2) {
			System.out.println(req2 + ":" + req1);
			wall.start = req2;
			wall.end = req1;
			for (int i2 = 0; i2 < len; i2++) {
				System.out.printf("%d ", req2 + i2);
				point.x=(req2 + i2);
				point.y=req3;
				wall.points.add(point);
			}
			System.out.println();
		} else {
			System.out.println(req1 + ":" + req2);
			for (int i2 = 0; i2 < len; i2++) {
				System.out.printf("%d ", req1 + i2);
				point.x=(req1 + i2);
				point.y=req3;
				wall.points.add(point);
			}
			System.out.println();
		}
		wallList.add(wall);
	}//

	// 內部類別
	class Wall {
		int xytype; // x=0,y=1;
		int start;
		int end;
		LinkedList<Point> points;
	}//
	
	class Point{
		int x;
		int y;
	}
}
//---------------------------------------
