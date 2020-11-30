package ch05_test;

import ch05.BlueCloth;
import ch05.Factory;

public class FactoryApp {

	public static void main(String[] args) {
		// 
		Factory f1 = new BlueCloth();
		//같은 패키지에 있었으면 가능
//		f1.색칠(); //부모 추상클래스의 추상메서드 동적바인딩
//		f1.건조(); //부모 추상클래스의 일반메서드
		
		//public 일반메서드라 호출 가능
		f1.가동();
	}

}
