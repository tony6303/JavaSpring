package ch12;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Street02 extends JFrame{
	int x = 350;
	int y = 20;
	
	Container c;
	
	public Street02() {
		setTitle("장풍");
		setSize(900,300);
		setLocationRelativeTo(null);
		c = getContentPane();
		c.add(new GamePanel());
		setVisible(true);
	}
	class GamePanel extends JPanel{
		ImageIcon imgIconPlayer, imgIconJang;
		Image imgPlayer, imgJang;
		
		public GamePanel() {
			imgIconPlayer = new ImageIcon("images/player.png");
			imgIconJang = new ImageIcon("images/jang.png");
			imgPlayer = imgIconPlayer.getImage();
			imgJang = imgIconJang.getImage();
			
			setFocusable(true);
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						System.out.println(x);
						if( x<=640)
						x = x + 10;
					}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						System.out.println(x);
						if(x >= 360)
						x = x - 10;
					}
					repaint();
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
		new Street02();
	}
}
