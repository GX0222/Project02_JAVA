package tw.labs.lab01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class class13 extends JFrame {

	private JButton b1, b2, b3;

	public class13() {

		b1 = new JButton("OOO");
		b2 = new JButton("XXX");
		b3 = new JButton("ZZZ");
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);

		setVisible(true);
		setSize(720, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new class13();
	}

}
