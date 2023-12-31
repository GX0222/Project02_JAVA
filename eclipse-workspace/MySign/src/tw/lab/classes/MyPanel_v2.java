package tw.lab.classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class MyPanel_v2 extends JPanel {

	private LinkedList<Line> lineBox, lineMove;
	private Color color = Color.BLACK;
	private int drawType = 0; // 0:Line, 1:Rectangle

	public MyPanel_v2() {
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);

		lineBox = new LinkedList<>();
		lineMove = new LinkedList<>();

		MyMouseListener listener = new MyMouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		for (Line line : lineBox) {
			g2d.setColor(line.color);
			g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

			switch (line.drawType) {
			case 0: {
				for (int i = 1; i < line.points.size(); i++) {
					g2d.drawLine(line.points.get(i - 1).x, line.points.get(i - 1).y, line.points.get(i).x,
							line.points.get(i).y);
				}
			}
			case 1, 2: {
				int width;
				int widthStart;
				int height;
				int heightStart;
				if (line.points.get(1).x >= line.points.get(0).x) {
					widthStart = line.points.get(0).x;
					width = line.points.get(1).x - line.points.get(0).x;
				} else {
					widthStart = line.points.get(1).x;
					width = line.points.get(0).x - line.points.get(1).x;
				}
				if (line.points.get(1).y >= line.points.get(0).y) {
					heightStart = line.points.get(0).y;
					height = line.points.get(1).y - line.points.get(0).y;
				} else {
					heightStart = line.points.get(1).y;
					height = line.points.get(0).y - line.points.get(1).y;
				}
				g2d.drawRect(widthStart, heightStart, width, height);
			}
			}

		}

	}

	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			lineMove.clear();
			Line line = new Line(e.getX(), e.getY(), color, drawType);
			lineBox.add(line);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (drawType == 0) {
				lineBox.getLast().addPoint(e.getX(), e.getY());
			} else if (drawType == 1) {

				if (lineBox.getLast().points.size() > 1) {
					lineBox.getLast().points.removeLast();
					lineBox.getLast().addPoint(e.getX(), e.getY());
				} else {
					lineBox.getLast().addPoint(e.getX(), e.getY());
				}
			}
			repaint();
		}
	}

	public void paintClear() {
		for (Line line : lineBox) {
			lineMove.add(line);
		}
		lineBox.clear();
	}

	public void undo() {
		if (lineBox.size() >= 1) {
			lineMove.add(lineBox.pollLast());
		}
	}

	public void redo() {
		if (lineMove.size() >= 1) {
			lineBox.add(lineMove.pollLast());
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		setForeground(color);
		repaint();
	}

	public void setType(int reqType) {
		drawType = reqType;
	}

	// 存檔
	public void saveObj(File file) throws Exception {
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
		oout.writeObject(lineBox);
		oout.flush();
		oout.close();
	}

	// 讀黨
	public void loadObj(File file) throws Exception {
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
		Object obj = oin.readObject();
		oin.close();
		if (obj instanceof LinkedList) {
			lineBox = (LinkedList<Line>) obj;
			repaint();
		} else {
			throw new Exception("ERR01:格式不對");
		}
		oin.close();
	}

	// 存JPG
	public void saveJPEG(File file) {
		BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_BGR);
		
		Graphics g = img.getGraphics();
		paint(g);
		
		try {
			ImageIO.write(img, "jpg", file);
			System.out.println("Save JPG sucess!");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}

class Line implements Serializable {
	LinkedList<Point> points;
	Color color;
	int drawType;

	Line(int x, int y, Color color, int drawType) {
		this.color = color;
		this.drawType = drawType;
		points = new LinkedList<Point>();
		addPoint(x, y);
	}

	void addPoint(int x, int y) {
		Point point = new Point();
		point.x = x;
		point.y = y;
		points.add(point);
	}

}

class Point implements Serializable {
	int x, y;
}

//for (int i = 1; i < line.points.size(); i++) {
//if (line.drawType == 0) {
//	g2d.drawLine(line.points.get(i - 1).x, line.points.get(i - 1).y, line.points.get(i).x,
//			line.points.get(i).y);
//} else if (line.drawType == 1) {
//	int width;
//	int widthStart;
//	int height;
//	int heightStart;
//	if (line.points.get(i).x >= line.points.get(i - 1).x) {
//		widthStart = line.points.get(i - 1).x;
//		width = line.points.get(i).x - line.points.get(i - 1).x;
//	} else {
//		widthStart = line.points.get(i).x;
//		width = line.points.get(i - 1).x - line.points.get(i).x;
//	}
//	if (line.points.get(i).y >= line.points.get(i - 1).y) {
//		heightStart = line.points.get(i - 1).y;
//		height = line.points.get(i).y - line.points.get(i - 1).y;
//	} else {
//		heightStart = line.points.get(i).y;
//		height = line.points.get(i - 1).y - line.points.get(i).y;
//	}
//	g2d.drawRect(widthStart, heightStart, width, height);
//}
//}