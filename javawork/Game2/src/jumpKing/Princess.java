package jumpKing;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Princess extends JLabel {
	public Princess princess = this; // 플레이어 콘텍스트
	private final static String TAG = "princess"; 
	private ImageIcon icPlayerLS, icPlayerRS, icPlayerLR, icPlayerRR; // 좌,우 이동 이미지
	private  int princessX = 500; // 캐릭터 기본 시작 X축
	private  int princessY = 300; // 캐틱터 기본 시작 Y축 
	
	public Princess() {
		init();
		
		setIcon(icPlayerRS);
		setSize(70, 70); // 버블버블 크기
		setLocation(princessX, princessY); // 기본 시작위치

	}

	void init() {
		// 우측 이미지
		icPlayerRS = new ImageIcon("images/icPlayerRS.png"); // 이동-가만히
		icPlayerRR = new ImageIcon("images/icPlayerRR.png"); // 이동-뜀
	

		// 좌측 이미지
		icPlayerLS = new ImageIcon("images/icPlayerLS.png");// 이동- 가만히
		icPlayerLR = new ImageIcon("images/icPlayerLR.png");// 이동- 뜀
	
		
		
	};
	
	
	
	
	
	
}
