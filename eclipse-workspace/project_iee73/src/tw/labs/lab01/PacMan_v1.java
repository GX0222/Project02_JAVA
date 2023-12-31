package tw.labs.lab01;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.LayoutStyle;

import tw.lab.classes.PacManMap_v1;

public class PacMan_v1 extends JFrame {
	
	private PacManMap_v1 map;
	
	//建構式
	public PacMan_v1() {
		super("PacMan");
		
		setLayout(new BorderLayout());
		map = new PacManMap_v1();
		add(map,BorderLayout.CENTER);
		
		setSize(800, 700);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new PacMan_v1();

	}

}
