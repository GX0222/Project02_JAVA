//package tw.labs.lab01;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JColorChooser;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//import tw.lab.classes.MyPanel;
//import tw.lab.classes.MyPanel_v2;
//
//public class MySign_v2 extends JFrame {
//
//	private MyPanel_v2 myPanel;
//	private JButton clear;
//	private JButton undo;
//	private JButton redo;
//	private JButton color;
//
//	public MySign_v2() {
//		super("簽名App");
//
//		setLayout(new BorderLayout());
//		myPanel = new MyPanel_v2();
//
//		add(myPanel, BorderLayout.CENTER);
//
//		JPanel top = new JPanel(new FlowLayout());
//		clear = new JButton("Clear");
//		top.add(clear);
//		undo = new JButton("Undo");
//		top.add(undo);
//		redo = new JButton("Redo");
//		top.add(redo);
//		color = new JButton();
//		color.setPreferredSize(new Dimension(25, 25));
//		color.setForeground(Color.BLACK);
//		color.setBackground(myPanel.changeBgColor());
//		top.add(color);
//
//		add(top, BorderLayout.NORTH);
//
//		setSize(640, 480);
//		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//		setLinstener();
//
//	}
//
//	private void setLinstener() {
//		clear.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				myPanel.paintClear();
//				repaint();
//			}
//		});
//		undo.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				myPanel.undo();
//				repaint();
//			}
//		});
//		redo.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				myPanel.redo();
//				repaint();
//			}
//		});
//		color.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				color.setForeground(myPanel.changeColor());
//				color.setBackground(myPanel.changeBgColor());
//				repaint();
//			}
//		});
//
//	}
//
//	// ===
//
//	public static void main(String[] args) {
//		new MySign_v2();
//	}
//
//}
