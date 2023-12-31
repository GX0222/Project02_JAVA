//package tw.lab.classes;
//
//import java.awt.BasicStroke;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.HashMap;
//import java.util.LinkedList;
//
//import javax.swing.JColorChooser;
//import javax.swing.JPanel;
//
//public class MyPanel_v3 extends JPanel {
//
//	private LinkedList<LinkedList<Point>> lineBox;
//	private LinkedList<LinkedList<Point>> lineMove;
//	public int drawType = 2; // 1:Line, 2:Rectangle
//
//	public MyPanel_v3() {
//		setBackground(Color.WHITE);
//		setForeground(Color.BLACK);
//
//		lineBox = new LinkedList<>();
//		lineMove = new LinkedList<>();
//
//		MyMouseListener listener = new MyMouseListener();
//		addMouseListener(listener);
//		addMouseMotionListener(listener);
//	}
//
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//
//		Graphics2D g2d = (Graphics2D) g;
//
//		for (LinkedList<Point> line : lineBox) {
//			for (int i = 1; i < line.size(); i++) {
//				if (drawType == 1) {
//					g2d.setColor(line.get(i).color);
//					g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
//					g2d.drawLine(line.get(i - 1).x, line.get(i - 1).y, line.get(i).x, line.get(i).y);
//				} else if (drawType == 2) {
//					g2d.setColor(line.get(i).color);
//					g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
//					int widthA;
//					int widthB;
//					int heightA;
//					int heightB;
//					if (line.get(i).x >= line.get(i - 1).x) {
//						widthA = line.get(i).x;
//						widthB = line.get(i - 1).x;
//					} else {
//						widthB = line.get(i).x;
//						widthA = line.get(i - 1).x;
//					}
//					if (line.get(i).y >= line.get(i - 1).y) {
//						heightA = line.get(i).y;
//						heightB = line.get(i - 1).y;
//					} else {
//						heightB = line.get(i).y;
//						heightA = line.get(i - 1).y;
//					}
//					int width = widthA - widthB;
//					int height = heightA - heightB;
//					g2d.drawRect(widthB, heightB, width, height);
//				}
//			}
//		}
//
//	}
//
//	private class MyMouseListener extends MouseAdapter {
//		@Override
//		public void mousePressed(MouseEvent e) {
//			lineMove.clear();
//			Point point = new Point();
//			point.x = e.getX();
//			point.y = e.getY();
//			point.color = getForeground();
//
//			LinkedList<Point> line = new LinkedList<>();
//			line.add(point);
//			lineBox.addLast(line);
//		}
//
//		@Override
//		public void mouseDragged(MouseEvent e) {
//			Point point = new Point();
//
//			if (drawType == 1) {
//				point.x = e.getX();
//				point.y = e.getY();
//				point.color = getForeground();
//				lineBox.getLast().add(point);
//			} else if (drawType == 2) {
//				point.x = e.getX();
//				point.y = e.getY();
//				point.color = getForeground();
//				if (lineBox.getLast().size() > 1) {
//					lineBox.getLast().removeLast();
//					lineBox.getLast().add(point);
//				} else {
//					point.x = e.getX();
//					point.y = e.getY();
//					point.color = getForeground();
//					lineBox.getLast().add(point);
//				}
//			}
//			repaint();
//		}
//	}
//
//	public void paintClear() {
//		for (LinkedList<Point> line : lineBox) {
//			lineMove.add(line);
//		}
//		lineBox.clear();
//	}
//
//	public void undo() {
//		if (lineBox.size() >= 1) {
//			lineMove.add(lineBox.pollLast());
//		}
//	}
//
//	public void redo() {
//		if (lineMove.size() >= 1) {
//			lineBox.add(lineMove.pollLast());
//		}
//	}
//
//	public Color changeColor() {
//		Color newColor = JColorChooser.showDialog(getRootPane(), getName(), getForeground());
//		if (newColor != null) {
//			setForeground(newColor);
//			return newColor;
//		} else {
//			return getForeground();
//		}
//	}
//
//	public Color changeBgColor() {
//		Color oldColor = getForeground();
//		Color newColor = getContrastColor(oldColor);
//		return getForeground();
//	}
//
//	public Color getContrastColor(Color oldColor) {
//		int red = 255 - oldColor.getRed();
//		int green = 255 - oldColor.getGreen();
//		int blue = 255 - oldColor.getBlue();
//		return new Color(red, green, blue);
//	}
//
//}
//
//class Point {
//	int x, y;
//	Color color;
//}
//
