package tw.labs.lab01;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.lab.classes.MyPanel;

public class MySign extends JFrame {
	
	private MyPanel myPanel;
	
	public MySign() {
		super("簽名App");
		
		setLayout(new BorderLayout());
		myPanel = new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void test() {
		
	}
	
	
	
	
	
	//===

	public static void main(String[] args) {
		new MySign();
		
	}

}
