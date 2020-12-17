package jumpKing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lombok.Data;

public class JumpKingApp extends JFrame implements Initable {

	// ���ؽ�Ʈ ����
	private JumpKingApp jumpKingApp = this; // ���� ���ؽ�Ʈ �����
	// �±�
	private static final String TAG = "JumpKing : ";

	public Player player; // �÷��̾�
	public Princess princess; // �÷��̾�
	private Thread thPixel; // �ȼ��˻�
	private BgJumpKing bgPanel; // ��׶���
	private String bgImageURL;
	
	private ImageIcon[] icon = {null, new ImageIcon("images/1StageC.png"), new ImageIcon("images/2StageC.png"), new ImageIcon("images/3StageC.png")};
	private int imgCount = 1;
	private Image img = icon[imgCount].getImage(); // �̹��� ��ü
	
	private Thread laThread;
	private JLabel la1Stage, la2Stage, la3Stage;
	
	

	public JumpKingApp() {
		init(); // ���� ��ü����
		setting(); // ���� ����
		batch(); // ��ġ ����
		listener(); // ������ ����
		setVisible(true);
		
	}

	class BgJumpKing extends JLabel implements Runnable{
		

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);
//			g.drawLine(player.getPlayerX(), player.getPlayerY(),	player.getPlayerX(), player.getPlayerY()+30);
			
		}
		
		public BgJumpKing() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
									
					img = icon[imgCount].getImage();
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
		}).start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		

		
	}

	@Override
	public void init() {
		
		player = new Player();
		princess = new Princess();
		bgPanel = new BgJumpKing();
		la1Stage = new JLabel("----------1Stage----------");
		la2Stage = new JLabel("----------2Stage----------");
		la3Stage = new JLabel("----------3Stage----------");
		thPixel = new Thread(new PixelCheck(player,jumpKingApp)); // ���� ���� ������
		thPixel.start();
		laThread = new Thread(new LaStageChange());
		laThread.start();
		
	}

	@Override
	public void setting() {
		setTitle("�������");
		setSize(1080, 607);
		
		
		la1Stage.setBounds(450, 80, 300, 400);
		la1Stage.setForeground(Color.white);
		la1Stage.setFont(new Font("Serif", Font.BOLD, 22));
		la2Stage.setBounds(450, 80, 300, 400);
		la2Stage.setForeground(Color.white);
		la2Stage.setFont(new Font("Serif", Font.BOLD, 22));
		la3Stage.setBounds(450, 80, 300, 400);
		la3Stage.setForeground(Color.white);
		la3Stage.setFont(new Font("Serif", Font.BOLD, 22));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setContentPane(bgPanel); // �⺻ ����Ʈ���� = �� ��׶���
	}

	@Override
	public void batch() {
		add(player);
//		add(princess);
		
		
	}

	@Override
	public void listener() {
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				if (player.isMoveLock() == true) { // Move���� �ɷ������� �޼������ȵ�
					return;
				}

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // ������ �̵�
					player.setJumpUpDirectionStay(true); // ���ڸ� ������ ���� ���� ���� (���� �̹��� ������ ���)
					player.moveRight();
//					System.out.println(player.getPlayerX() +" a "+ player.getPlayerY());
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT ) { // �����̵�
					player.setJumpUpDirectionStay(false); // ���ڸ� ������ ���� ���� ���� (���� �̹��� ������ ���)
					player.moveLeft();
				} else if (e.getKeyCode() == KeyEvent.VK_UP && player.isLeft() == true) { // ���� �� ����
					player.setJumpUpDirection(-1);// ���� ���Ⱚ ����
					player.jumpUp();
				} else if (e.getKeyCode() == KeyEvent.VK_UP && player.isRight() == true) { // ���� �� ����
					player.setJumpUpDirection(1); // ���� ���Ⱚ ����
					player.jumpUp();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {// ���ڸ� ����
					player.jumpUp();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) { // ��ư���� ���ߴ� �Լ�
				if (e.getKeyCode() == KeyEvent.VK_UP) // UP��ư �����Է� ����
					player.setUp(false);
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) // ��,���̵� �Ų����� ��ȯ ���ǹ�
					player.setRight(false);
				else if (e.getKeyCode() == KeyEvent.VK_LEFT)
					player.setLeft(false);
			}
		});
		
	}
	
	

	
	class LaStageChange implements Runnable {

		@Override
		public void run() {
			boolean lacount = true;
			while(true) {
				
				if(imgCount ==1 && lacount == true) {
					System.out.println("��������1");
					try {
						lacount = false;
						add(la1Stage);
						Thread.sleep(2000);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(imgCount == 2 && lacount == false) {
					System.out.println("��������22");
					try {
						lacount = true;
						add(la2Stage);
						Thread.sleep(2000);
						
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(imgCount == 3 && lacount == true) {
					try {
						System.out.println("��������3");
						lacount = false;
						add(la3Stage);
						Thread.sleep(3000);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				remove(la1Stage);
				remove(la2Stage);
				remove(la3Stage);
			}
			
		}
		
	}
		
	



	
	
	

	public int getImgCount() {
		return imgCount;
	}

	public void setImgCount(int imgCount) {
		this.imgCount = imgCount;
	}

	public static void main(String[] args) {
		new JumpKingApp();

	}

}
