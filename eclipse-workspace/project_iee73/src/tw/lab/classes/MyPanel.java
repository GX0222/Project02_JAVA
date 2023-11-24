package tw.lab.classes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

	private LinkedList<LinkedList<HashMap<String, Integer>>> lineBox;

	public MyPanel() {
		setBackground(Color.yellow);

		lineBox = new LinkedList<>();

		MyMouseListener listener = new MyMouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

//	int i = 1;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

//		if (g instanceof Graphics2D) {
//			System.out.println("Ok" + i);
//		} else {
//			System.out.println("XX");
//		}

		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.blue);
		g2d.setStroke(new BasicStroke(5));

//		g2d.drawLine(0, 0, 200, 400);

		for (LinkedList<HashMap<String, Integer>> line : lineBox) {
			for (int i = 1; i < line.size(); i++) {
				g2d.drawLine(line.get(i - 1).get("x"), line.get(i - 1).get("y"), line.get(i).get("x"),
						line.get(i).get("y"));
			}
		}

//		i++;

	}

	private class MyMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
			line.add(point);
			lineBox.addLast(line);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX());
			point.put("y", e.getY());

			lineBox.getLast().add(point);
			repaint();
		}
	}

}
