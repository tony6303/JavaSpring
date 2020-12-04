package bubblebubble;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Player extends JLabel {
	public Player player = this;
	public BubbleObject bubbleObject;
	public final static String TAG = "Player : "; // 안쓰더라도 고정
	public ImageIcon icPlayerR, icPlayerL;
	public int x = 55;
	public int y = 535;
	public int curY;
	public boolean isRight = false;
	public boolean isLeft = false;
	public boolean isUp = false;

	public Player() {
		icPlayerR = new ImageIcon("image/playerR.png");
		icPlayerL = new ImageIcon("image/playerL.png");
		setIcon(icPlayerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	public void moveRight() {
		System.out.println(TAG + "moveRight()");
		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerR);
					isRight = true;
					while (isRight) {
						if (x <= 880 && y >= 20) {
							// 천장에 닿지 않았을 때
							x = x + 2;
							setLocation(x, y);
							System.out.println("x = " + x + "y = " + y);
							if (x >= 342) {
								// 선을 올라갈 때
								y = y - 2;
								setLocation(x, y);
								System.out.println("x = " + x + "y = " + y);
							}
						}

						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}

	}

	public void moveLeft() {
		System.out.println(TAG + "moveLeft()");
		if (isLeft == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerL);
					isLeft = true;
					while (isLeft) {
						if (x >= 60) {
							x = x - 2;
							setLocation(x, y);
							System.out.println("x = " + x + "y = " + y);
						}
						if (x >= 340 && y <= 535) {
							// 선을 내려가기시작함과 동시에 천장에 닿지 않았을 때
							y = y + 2;
							setLocation(x, y);
							System.out.println("x = " + x + "y = " + y);
						}
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}

	}

	public void moveUp() {
		System.out.println(TAG + "moveUp()");
		curY = getY();
		if (isUp == false) { // 올라가는중이 아닐때, 올라감을 실행
			new Thread(new Runnable() {
				@Override
				public void run() {
					isUp = true; // 상태 : 올라가는중
					while (true) {
						if (getY() < curY-130) {
							break;
						}
						System.out.println("y = " + y);
						y = y - 1;
						setLocation(x, y);
						try {
							Thread.sleep(5);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					isUp = false;
					moveDown();
				}
			}).start();
		}
	}

	public void moveDown() {
		System.out.println(TAG + "moveDown()");
		curY = getY();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					isUp = true;
					if (getY() > curY+130) {
						break;
					}
					System.out.println("y = " + y);
					y = y + 1;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				isUp = false;
			}
		}).start();
	}

	public void moveJump() {
		moveUp();
	}

	public void attack() {

	}

}
