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

	// 컨텍스트 저장
	private JumpKingApp jumpKingApp = this; // 버블 컨텍스트 남기기
	// 태그
	private static final String TAG = "JumpKing : ";

	public Player player; // 플레이어
	public Princess princess; // 플레이어
	private Thread thPixel; // 픽셀검사
	private BgJumpKing bgPanel; // 백그라운드
	private String bgImageURL;
	
	private ImageIcon[] icon = {null, new ImageIcon("images/1StageC.png"), new ImageIcon("images/2StageC.png"), new ImageIcon("images/3StageC.png")};
	private int imgCount = 1;
	private Image img = icon[imgCount].getImage(); // 이미지 객체
	
	private Thread laThread;
	private JLabel la1Stage, la2Stage, la3Stage;
	
	

	public JumpKingApp() {
		init(); // 생성 객체모음
		setting(); // 셋팅 모음
		batch(); // 배치 모음
		listener(); // 리스너 모음
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
		thPixel = new Thread(new PixelCheck(player,jumpKingApp)); // 색깔 연산 스레드
		thPixel.start();
		laThread = new Thread(new LaStageChange());
		laThread.start();
		
	}

	@Override
	public void setting() {
		setTitle("버블버블");
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
		setContentPane(bgPanel); // 기본 컨텐트페인 = 라벨 백그라운드
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
				
				if (player.isMoveLock() == true) { // Move락이 걸려있으면 메서드실행안됨
					return;
				}

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // 오른쪽 이동
					player.setJumpUpDirectionStay(true); // 제자리 점프시 우측 방향 설정 (우측 이미지 때문에 사용)
					player.moveRight();
//					System.out.println(player.getPlayerX() +" a "+ player.getPlayerY());
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT ) { // 왼쪽이동
					player.setJumpUpDirectionStay(false); // 제자리 점프시 좌측 방향 설정 (좌측 이미지 때문에 사용)
					player.moveLeft();
				} else if (e.getKeyCode() == KeyEvent.VK_UP && player.isLeft() == true) { // 좌측 위 점프
					player.setJumpUpDirection(-1);// 좌측 방향값 설정
					player.jumpUp();
				} else if (e.getKeyCode() == KeyEvent.VK_UP && player.isRight() == true) { // 우측 위 점프
					player.setJumpUpDirection(1); // 우측 방향값 설정
					player.jumpUp();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {// 제자리 점프
					player.jumpUp();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) { // 버튼땔때 멈추는 함수
				if (e.getKeyCode() == KeyEvent.VK_UP) // UP버튼 연속입력 방지
					player.setUp(false);
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) // 좌,우이동 매끄러운 변환 조건문
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
					System.out.println("스테이지1");
					try {
						lacount = false;
						add(la1Stage);
						Thread.sleep(2000);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(imgCount == 2 && lacount == false) {
					System.out.println("스테이지22");
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
						System.out.println("스테이지3");
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
