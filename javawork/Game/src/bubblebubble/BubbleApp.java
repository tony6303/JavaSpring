package bubblebubble;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleApp extends JFrame implements Initable {
	BubbleApp bubbleApp = this;
	// 디버깅 태그 (클래스이름)
	public static final String TAG = "BubbleApp : ";
	private JLabel laBackGround;
	private Player player;

	public BubbleApp() {
		// 작업환경 공유
		init();
		setting();
		batch();
		listener();
		setVisible(true);
	}

	@Override
	public void init() {
		laBackGround = new JLabel(new ImageIcon("image/bg.png"));
		player = new Player();
	}

	@Override
	public void setting() {
		setTitle("Bubble bubble");
		setSize(1000, 639);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setContentPane(laBackGround);
	}

	@Override
	public void batch() {
		add(player);

	}

	@Override
	public void listener() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.moveRight();
				}else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.moveLeft();
				}else if (e.getKeyCode() == KeyEvent.VK_UP) {
					player.moveJump();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.isRight = false;
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.isLeft = false;
				}
			}
		});
	}

	public static void main(String[] args) {
		new BubbleApp();
	}
}
