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
	public int curX;
	public boolean isRight = false;
	public boolean isLeft = false;
	public boolean isUp = false;
	public boolean isDownhill = false;

	public Player() {
		icPlayerR = new ImageIcon("image/playerR.png");
		icPlayerL = new ImageIcon("image/playerL.png");
		setIcon(icPlayerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	public void moveRight() {
		System.out.println(TAG + "moveRight()");
		if(isDownhill == false) { // downhill �����϶� ��� ���� �����
		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerR);
					isRight = true;
					while (isRight) {
						if (x <= 880 && y >= 20) {
							// õ�忡 ���� �ʾ��� �� (õ�� ���� ��� ���� y �ʿ����)
							x = x + 2;
							setLocation(x, y);
							System.out.println("x = " + x + "y = " + y);
							System.out.println(TAG + "isDownhill: " + isDownhill);
							System.out.println(TAG + "isUP :" + isUp);
							if (x >= 342) {
								// ���� �ö� ��
								y = y - 2;
								System.out.println("x = " + x + "y = " + y);
							}
							if (x > 461) {
								// ���� �ö󰡴ٰ� ������ ������ ��
								y = y + 2; // x�� 342 �̻��� ������ ���º�ȭ y -2 �� ��ġ�⶧���� ��� ���������
								System.out.println("x = " + x + "y = " + y);
							}
							if (x >= 725 && x <= 850 && y<= 530) {
								//x ��ǥ�� �������� ���ο� ��ġ�ϸ鼭 , y���� ���Ϸ� �ȵ��Բ�
								//false���� ������ �����ʿ��� �����Ű�� ��� ȣ��Ǽ� downhill�� ������ �ҷ���
								isRight=false; // ���� while �ߴ�
								walkDownhill();
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

	}

	public void moveLeft() {
		System.out.println(TAG + "moveLeft()");
		if(isDownhill == false) { // downhill �����϶� ��� ���� �����
		if (isLeft == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerL);
					isLeft = true;
					while (isLeft) {
						if (x >= 60) {
							//���� �� ��ǥ 60�� ������ ���ο��� �۵�
							x = x - 2;
							setLocation(x, y);
							System.out.println("x = " + x + "y = " + y);
							System.out.println(TAG + "isDownhill: " + isDownhill);
							System.out.println(TAG + "isUP :" + isUp);
						}
						if (x >= 340 && x <= 461 && y <= 534) {
							if(x == 461)
								y = y - 2;
							// ���� ���� ������������� , y���� ���Ϸ� �������°� ����
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

	}

	public void moveUp() { //�� ����Ű (����)
		System.out.println(TAG + "moveUp()");
		curY = getY(); //ȣ�� �� ����� Y��ǥ�� �˾Ƴ������� ��������
		if(isDownhill == false) {  // downhill �����϶� ��� ���� �����
		if (isUp == false) { // �ö󰡴����� �ƴҶ���, �ö��� ����
			isUp = true; // ���� : �ö󰡴���
			new Thread(new Runnable() {
				@Override
				public void run() {					
					while (isUp) {
						if (getY() < curY - 130) {
							break;
						}
						System.out.println("y = " + y);
						System.out.println(TAG + "isUP :" + isUp);
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
	}

	public void moveDown() {
		System.out.println(TAG + "moveDown()");
		curY = getY(); //ȣ�� �� ����� Y��ǥ�� �˾Ƴ������� ��������
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					isUp = true;
					if (getY() > curY + 130) {
						break;
					}
					System.out.println("y = " + y);
					System.out.println(TAG + "isUP :" + isUp);
					y = y + 1;
					if(y >= 534) {
						isUp = false;
						break;
					}
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

	public void walkDownhill() {
		System.out.println(TAG + "walkDownhill()");
		new Thread(new Runnable() {
			@Override
			public void run() {
				isDownhill = true;
				while (isDownhill) {
					// �������� ������ �� �� #������ ��������#
						x = x + 2;
						y = y + 2;
						setLocation(x, y);
						System.out.println("x = " + x + "y = " + y);					
					try {
						Thread.sleep(30);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(x >=850 || y >= 535)
						isDownhill=false;
				}
			isUp=false;
			isDownhill=false;
			}
		}).start();
	}

	public void moveJump() {
		moveUp();
	}

	public void attack() {

	}

	public void reset() {
		curX = getX(); // ���� X���� �˾Ƴ��� ���� ��������
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (curX != 55) { // X���� �ʱ���ġ ���ƴϸ�
						player.setX(55); // ������ X, Y�� set
						player.setY(535);
						System.out.println("x = " + x + "y = " + y);
						System.out.println("reset");
						break;
					}

				}
			}
		}).start();

	}

}
