package tw.labs.lab01;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class class25 extends JFrame {

	int a=0;
	
	public class25() {
		super("25!!!!");
		
		

		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		MyMouseListener listener = new MyMouseListener();
		panel.addMouseListener(listener);
		panel.addMouseMotionListener(listener);

		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new class25();

	}
	
	private void m1 () {
		System.out.println("m1():"+a);
	}
	
	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			a++;
			m1();
//			super.mouseClicked(e);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println(e.getX() + "," + e.getY());
//			super.mouseDragged(e);
		}
	}

}


