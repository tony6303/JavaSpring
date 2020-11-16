package ch04;

public class Cat3App {
	public int f(int a, int b) {
		return a+b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat3 c = new Cat3();
		
		c.setAge(5);
		Cat3App ca = new Cat3App();
		
		int sum = ca.f(2,3);
	}

}
