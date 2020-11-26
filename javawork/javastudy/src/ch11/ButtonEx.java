package ch11;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
//595p
public class ButtonEx extends JFrame {
	
	public ButtonEx() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		ImageIcon normalIcon = new ImageIcon("images/normalicon.gif"); //평상시
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif"); //마우스 위
		ImageIcon pressdIcon = new ImageIcon("images/pressedIcon.gif"); //클릭 시

		JButton btn = new JButton("call~", normalIcon); //(String text , Icon icon)
		btn.setPressedIcon(pressdIcon);
		btn.setRolloverIcon(rolloverIcon);
		c.add(btn);
		
		setSize(300,250);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ButtonEx();
	}

}
