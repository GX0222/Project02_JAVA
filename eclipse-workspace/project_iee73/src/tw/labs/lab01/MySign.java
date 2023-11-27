package tw.labs.lab01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.lab.classes.MyPanel;
import tw.lab.classes.MyPanel_v2;

public class MySign extends JFrame {

	private MyPanel_v2 myPanel;
	private JButton clear, undo, redo, colorBtn, typeLine, typeRect;

	public MySign() {
		super("簽名App");

		setLayout(new BorderLayout());
		myPanel = new MyPanel_v2();

		add(myPanel, BorderLayout.CENTER);

		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear");
		top.add(clear);
		undo = new JButton("Undo");
		top.add(undo);
		redo = new JButton("Redo");
		top.add(redo);
		colorBtn = new JButton();
		colorBtn.setPreferredSize(new Dimension(25, 25));
		colorBtn.setBackground(myPanel.getColor());
		top.add(colorBtn);

		add(top, BorderLayout.NORTH);

		JPanel left = new JPanel(new FlowLayout());
		typeLine = new JButton("L");
		typeRect = new JButton("R");
		left.add(typeLine);
		left.add(typeRect);
		add(left, BorderLayout.WEST);

		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLinstener();

	}

	private void setLinstener() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.paintClear();
				repaint();
			}
		});
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.undo();
				repaint();
			}
		});
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.redo();
				repaint();
			}
		});
		colorBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(rootPane, "Change Color", myPanel.getColor());
				if (color != null) {
					myPanel.setColor(color);
					colorBtn.setBackground(color);
				}
				repaint();
			}
		});
		typeLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.setType(0);
			}
		});
		typeRect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.setType(1);
			}
		});

	}

	// ===

	public static void main(String[] args) {
		new MySign();
	}

}