package ch13;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
class TimeNowThread implements Runnable{
	private JLabel hourLabel; //타이머 값이 출력되는 라벨
	private JLabel minLabel; //타이머 값이 출력되는 라벨
	private JLabel secLabel; //타이머 값이 출력되는 라벨

	//생성자
	public TimeNowThread(JLabel hourLabel, JLabel minLabel, JLabel secLabel) {
		this.hourLabel = hourLabel;
		this.minLabel = minLabel;
		this.secLabel = secLabel;
	}

	@Override
	public void run() {
		
		while(true) {
			try {
				LocalDateTime now = LocalDateTime.now();
				hourLabel.setText(Integer.toString(now.getHour())+":");
				minLabel.setText(Integer.toString(now.getMinute())+":");
				secLabel.setText(Integer.toString(now.getSecond()));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}// end of run
}
public class TimeNow extends JFrame{
	public TimeNow() {
		setTitle("디지털 시계 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		// label 생성
		JLabel hour = new JLabel();
		JLabel min = new JLabel();
		JLabel sec = new JLabel();
		
		hour.setFont(new Font("Gothic", Font.ITALIC, 30));
		min.setFont(new Font("Gothic", Font.ITALIC, 30));
		sec.setFont(new Font("Gothic", Font.ITALIC, 30));
		c.setLayout(new FlowLayout());
		c.add(hour);
		c.add(min);
		c.add(sec);
		
		TimeNowThread tnt = new TimeNowThread(hour, min, sec);
		
		setSize(400,270);
		setVisible(true);
		
		tnt.run();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TimeNow();
	}

}
