package ch04;

//자바 특징 : 모든코드는 class 내부에 작성해야한다.
public class Method01 {
	
	static void add() {
		System.out.println("애드");
	}	
	void sound() {
		System.out.println("사운드");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method01.add();
		
		Method01 m = new Method01();
		m.sound();
	}
	
	
}
