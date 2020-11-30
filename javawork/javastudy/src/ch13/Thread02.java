package ch13;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class NewThread implements Runnable{
	private JLabel timerlabel; //타이머 값이 출력되는 라벨

	//생성자
	public NewThread(JLabel timerlabel) {
		this.timerlabel = timerlabel;
	}

	@Override
	public void run() {
		int n=0;
		while(true) {
			timerlabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// 
				e.printStackTrace();
			}
		}
		
	}// end of run
}

public class Thread02 extends JFrame{
	public Thread02() {
		setTitle("스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		// label 생성
		JLabel label = new JLabel();
		label.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(label);
		
		// 스레드 생성
		NewThread th = new NewThread(label);
		
		setSize(300,170);
		setVisible(true);
		
		th.run();
	}
	public static void main(String[] args) {
		new Thread02();
	}
}
