package bubblebubble;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {
	public Player player = this;
	public final static String TAG = "Player : "; // 안쓰더라도 고정
	public ImageIcon icPlayerR, icPlayerL;
	public int x = 55;
	public int y = 535;
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
						if (x <= 880) {
							x = x + 2;
							setLocation(x, y);
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
		if(isUp == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					isUp = true;
					while (true) {
						if(y < 405) {
							break;
						}				
						System.out.println(y);
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
			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						isUp = true;
						if(y > 534) {
							break;
						}
						System.out.println(y);
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
