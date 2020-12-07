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
		if(isDownhill == false) { // downhill 상태일때 모든 동작 제어용
		if (isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerR);
					isRight = true;
					while (isRight) {
						if (x <= 880 && y >= 20) {
							// 천장에 닿지 않았을 때 (천장 갈일 없어서 이제 y 필요없음)
							x = x + 2;
							setLocation(x, y);
							System.out.println("x = " + x + "y = " + y);
							System.out.println(TAG + "isDownhill: " + isDownhill);
							System.out.println(TAG + "isUP :" + isUp);
							if (x >= 342) {
								// 선을 올라갈 때
								y = y - 2;
								System.out.println("x = " + x + "y = " + y);
							}
							if (x > 461) {
								// 선을 올라가다가 지평선을 만났을 때
								y = y + 2; // x가 342 이상인 조건의 상태변화 y -2 와 겹치기때문에 상쇄 시켜줘야함
								System.out.println("x = " + x + "y = " + y);
							}
							if (x >= 725 && x <= 850 && y<= 530) {
								//x 좌표가 내리막길 내부에 위치하면서 , y값은 지하로 안들어가게끔
								//false하지 않으면 리스너에서 우방향키가 계속 호출되서 downhill이 여러번 불러짐
								isRight=false; // 내부 while 중단
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
		if(isDownhill == false) { // downhill 상태일때 모든 동작 제어용
		if (isLeft == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerL);
					isLeft = true;
					while (isLeft) {
						if (x >= 60) {
							//왼쪽 벽 좌표 60을 제외한 전부에서 작동
							x = x - 2;
							setLocation(x, y);
							System.out.println("x = " + x + "y = " + y);
							System.out.println(TAG + "isDownhill: " + isDownhill);
							System.out.println(TAG + "isUP :" + isUp);
						}
						if (x >= 340 && x <= 461 && y <= 534) {
							if(x == 461)
								y = y - 2;
							// 왼쪽 선을 내려가기시작함 , y값은 지하로 내려가는거 방지
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

	public void moveUp() { //위 방향키 (점프)
		System.out.println(TAG + "moveUp()");
		curY = getY(); //호출 될 당시의 Y좌표를 알아내기위한 지역번수
		if(isDownhill == false) {  // downhill 상태일때 모든 동작 제어용
		if (isUp == false) { // 올라가는중이 아닐때만, 올라감을 실행
			isUp = true; // 상태 : 올라가는중
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
		curY = getY(); //호출 될 당시의 Y좌표를 알아내기위한 지역번수
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
					// 내리막길 내려갈 때 를 #쓰레드 실행으로#
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
		curX = getX(); // 현재 X값을 알아내기 위한 지역변수
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					if (curX != 55) { // X값이 초기위치 가아니면
						player.setX(55); // 강제로 X, Y값 set
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
