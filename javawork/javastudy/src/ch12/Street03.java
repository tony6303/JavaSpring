package ch12;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//외부클래스
class MyThread extends Thread{
	Street03 street;
	
	
	public MyThread(Street03 street) {
		this.street = street;
	}


	@Override
	public void run() {
		while (street.isValue) { // 새로운 스레드도 힙 변수를 공유함
			street.x = street.x + 10;
			street.repaint(); // 스레드를 분리 했으므로 이벤트가 끝이 날수 있음
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Street03 extends JFrame {
	Street03 street = this; // Context
	
	int x = 350;
	int y = 20;
	boolean isValue = true;
	Container c;
	

	public Street03() {
		setTitle("장풍");
		setSize(900, 300);
		setLocationRelativeTo(null);
		c = getContentPane();
		
		
		c.add(new GamePanel());
		setVisible(true);
		
	}

	class GamePanel extends JPanel {
		ImageIcon imgIconPlayer, imgIconJang;
		Image imgPlayer, imgJang;
		JButton btn;
		
		public GamePanel() {
			imgIconPlayer = new ImageIcon("images/player.png");
			imgIconJang = new ImageIcon("images/jang.png");
			imgPlayer = imgIconPlayer.getImage();
			imgJang = imgIconJang.getImage();
			btn = new JButton("멈춤");
			add(btn);

			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					isValue = false;
				}
			});
			setFocusable(true);
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						isValue = true;
//						new Thread(new Runnable() { // 익명클래스
//							@Override
//							public void run() {
//								while (isValue) { // 새로운 스레드도 힙 변수를 공유함
//									x = x + 10;
//									repaint(); // 스레드를 분리 했으므로 이벤트가 끝이 날수 있음
//									try {
//										Thread.sleep(20);
//									} catch (InterruptedException e) {
//										e.printStackTrace();
//									}
//								}
//							}
//						}).start();
						MyThread th = new MyThread(street);
						th.start();
					}
					else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						System.out.println(x);
						if( x<=640)
						x = x + 10;
					}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						System.out.println(x);
						if(x >= 360)
						x = x - 10;
					}
					repaint(); // keyEvent가 끝나야 실행이 됨
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imgPlayer, 0, 0, null);
			g.drawImage(imgJang, x, y, null);
		}
	}

	public static void main(String[] args) {
		new Street03();
	}
}
