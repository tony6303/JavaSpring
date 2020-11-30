package ch12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch12.Gra01.MyPanel;

public class Gra02 extends JFrame {

	private MyPanel panel;
	int x = 10;
	int y = 10;

	public Gra02() {
		setTitle("repaint 예제");
		setSize(400, 500);

		setVisible(true);
	}

	class Mypanel extends JPanel {
		public Mypanel() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(java.awt.event.MouseEvent e) {
					x = e.getX();
					y = e.getY();
					repaint();
				};
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g); // 이전 그림 삭제
			g.setColor(Color.blue);
			g.drawRect(x, y, 50, 50);
		}
	}
	
	public static void main(String[] args) {
		new Gra02();
	}
}
