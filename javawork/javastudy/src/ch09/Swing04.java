package ch09;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Swing04 extends JFrame{

	public Swing04() {
		setTitle("그리드 레이아웃");
		setSize(300,200);
		
		GridLayout grid = new GridLayout(5,2);
		grid.setVgap(5);
		
		Container c = getContentPane();
		JPanel jp = new JPanel();
		JButton btn1 = new JButton("확인");
		
		jp.setLayout(grid);
		jp.add(new JLabel(" 이름"));
		jp.add(new JTextField(""));
		jp.add(new JLabel(" 학번"));
		jp.add(new JTextField(""));
		jp.add(new JLabel(" 학과"));
		jp.add(new JTextField(""));
		jp.add(new JLabel(" 과목"));
		jp.add(new JTextField(""));
		c.add(jp);
		c.add(btn1,BorderLayout.SOUTH);
		
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Swing04();	
	}

}
