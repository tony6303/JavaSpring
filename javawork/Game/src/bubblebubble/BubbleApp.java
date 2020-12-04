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
	private BubbleObject bubbleobject;

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
		laBackGround = new JLabel(new ImageIcon("image/bg1.png"));
		player = new Player();
		bubbleobject = new BubbleObject(player);
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
		add(bubbleobject);

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
				}else if (e.getKeyCode() == KeyEvent.VK_L)
					bubbleobject.flying(player);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.isRight = false;
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.isLeft = false;
				}else if (e.getKeyCode() == KeyEvent.VK_UP) {
					player.isUp = true;
				}
				
			}
		});
		
	}
	

	public static void main(String[] args) {
		new BubbleApp();
	}
}
