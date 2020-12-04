package bubblebubble;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BubbleObject extends JLabel{
	Player player;
	BubbleObject bubbleObject = this;
	public ImageIcon bubbleImg;
	public ImageIcon bubbledImg;
//	public int x;
	public int y = 100;
	boolean isbubbled = false;
	
	public BubbleObject(Player player) {
		bubbleImg = new ImageIcon("image/bubble.png");
		bubbledImg = new ImageIcon("image/bubbled.png");
		setIcon(bubbleImg);
		setSize(50, 50);
		setLocation(player.x, player.y - y);
		setVisible(true);
	}
	
	//TODO : x 400을 지나면 거품이 알아서움직이게 (까마귀 같은거) 해보려했는데 모르겠음
	public void flying(Player player) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
//					if(player.x >= 400) {
					if(isbubbled == false) {
						setIcon(bubbledImg);
						try {
							Thread.sleep(300);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else {
						setIcon(bubbleImg);
						try {
							Thread.sleep(300);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					isbubbled = !isbubbled;
				}
			}
		}).start();
	}
}
	
//}
