package ch09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.peer.LightweightPeer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
class NorthPanel extends JPanel{
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY);
		
	}
}
class CenterPanel extends JPanel{
	public CenterPanel() {
		setLayout(null);
	}
}
public class Swing05 extends JFrame{
	public Swing05() {
		setTitle("오픈 챌린지");
		setSize(400,500);
		
		Container c = getContentPane();
		JPanel jp = new JPanel();
		JPanel jpN = new NorthPanel(); // JPanel을 상속받은 JPN
		JPanel jpC = new CenterPanel();
		JButton btn1 = new JButton("OPEN");
		JButton btn2 = new JButton("READ");
		JButton btn3 = new JButton("CLOSE");
		
		jpN.add(btn1);
		jpN.add(btn2);
		jpN.add(btn3);
		
		JLabel lb1 = new JLabel("LOVE");
		JLabel lb2 = new JLabel("JAVA");
		JLabel lb3 = new JLabel("HELLO");
		lb1.setSize(100,20);
		lb2.setSize(100,20);
		lb3.setSize(100,20);
		lb1.setLocation(200,20);
		lb2.setLocation(200,50);
		lb3.setLocation(200,90);
		
		jpC.add(lb1);
		jpC.add(lb2);
		jpC.add(lb3);
		
		c.add(jpN,BorderLayout.NORTH);
		c.add(jpC,BorderLayout.CENTER);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Swing05();
	}

}
