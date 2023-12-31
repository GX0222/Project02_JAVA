package tw.labs.lab01;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener {
	private JButton guess;
	private JTextArea log;
	private JTextField input;
	private String answer;
	int counter = 0;

	public GuessNumber() {
		// super();
		super("猜數字遊戲");
		setLayout(new BorderLayout());
		JPanel top = new JPanel(new BorderLayout());

		guess = new JButton("猜");
		input = new JTextField();
		log = new JTextArea();

		guess.addActionListener(this);
		
		input.setFont(new Font(null, Font.BOLD + Font.ITALIC, 24));

		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);

		add(top, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);

		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initGame();
	}
	
	// =====
	
	private void initGame() {
		answer = creatAnswer(3);
		System.out.println(answer);
		counter = 0;
		log.setText("");
		
	}

	// =====

	public static void main(String[] args) {
		new GuessNumber();

	}

	// =====

	private String creatAnswer(int d) {
		int num = 10;
		int[] poker = new int[num];
		int temp;

		for (int i = 0; i < poker.length; i++) {
			poker[i] = i ;
		}

		for (int i = num - 1; i > 0; i--) {
			temp = (int) (Math.random() * (i) - 1);
			poker[i] += poker[temp];
			poker[temp] = poker[i] - poker[temp];
			poker[i] = poker[i] - poker[temp];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < d; i++) {
			sb.append(poker[i]);
		}

		return sb.toString();
	}

	// =====

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(creatAnswer(3));
		counter ++;
		String inputText = input.getText();
		String result = checkAB(inputText);
//		log.setText(String.format("%s = %s",inputText,result ));
		log.append(String.format("%s => %s\n", inputText, result));
		input.setText("");
		
		if (result.equals("3A0B")) {
			JOptionPane.showMessageDialog(null, "答對了");
			initGame();
		}else if(counter == 3){
			JOptionPane.showMessageDialog(null, "嫩，答案是:"+answer);
			initGame();
		}
		
	}

	private String checkAB(String reqInputText) {
		int numOfA = 0;
		int numOfB = 0;
		for (int i =0;i<reqInputText.length();i++) {
			String reqText = reqInputText.substring(i,i+1);
			
			for(int k =0;k<answer.length();k++) {
				String theAnswer = answer.substring(k,k+1);
				if(reqText.equals(theAnswer)) {
					if(i == k ) {
						numOfA++;
					}
					else {
						numOfB++;
					}
				}
			}
			
		}
		
		return String.format("%dA%dB", numOfA,numOfB);
	}

}
