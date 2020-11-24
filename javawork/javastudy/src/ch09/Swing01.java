package ch09;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Swing은 내부적으로 while이 돌고 있음. 데몬프로세스
public class Swing01 extends JFrame{
	public Swing01() {
		setTitle("제목");
		setSize(300,500);
		
		Container c = getContentPane(); //JFrame이 기본적으로 가지고있는 패널
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
//		JButton btn4 = new JButton("버튼4");
		JButton btn5 = new JButton("버튼5");
		JButton btn6 = new JButton("버튼6");
		
		JPanel jp1 = new JPanel();
		jp1.add(btn6);
		
		
		c.add(btn1,Batch.EAST);
		c.add(btn2,Batch.WEST);
		c.add(btn3,Batch.NORTH);
//		c.add(btn4,Batch.CENTER);
		c.add(btn5,BorderLayout.SOUTH); //이미 있다
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Swing01();
		System.out.println(MyLayout.WEST);
		System.out.println(MyLayout.WEST.getValue());
	}
}
