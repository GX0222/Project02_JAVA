package tw.labs.lab01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import tw.lab.classes.GamePanel;

public class MyGame extends JFrame {
	private GamePanel panel;
	private JButton[] ballBtn;

	public MyGame() {
		super("遊戲");
		panel = new GamePanel();

		setLayout(new BorderLayout());

		add(panel, BorderLayout.CENTER);
		
		ballBtn = new JButton[3];
		ballBtn[0]=new JButton("螺旋丸");
		ballBtn[1]=new JButton("月球");
		ballBtn[2]=new JButton("寶貝球");
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new MyGame();
	}

}
