package bubblebubble;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;

@Data
public class Player extends JLabel {
	public Player player = this;
	public BubbleObject bubbleObject;
	public final static String TAG = "Player : "; // �Ⱦ����� ����
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
							// õ�忡 ���� �ʾ��� ��
							x = x + 2;
							setLocation(x, y);
							System.out.println("x = " + x + "y = " + y);
							if (x >= 342) {
								// ���� �ö� ��
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
							// ���� ������������԰� ���ÿ� õ�忡 ���� �ʾ��� ��
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
		if (isUp == false) { // �ö󰡴����� �ƴҶ�, �ö��� ����
			new Thread(new Runnable() {
				@Override
				public void run() {
					isUp = true; // ���� : �ö󰡴���
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
