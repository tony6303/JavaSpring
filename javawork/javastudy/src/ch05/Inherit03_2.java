package ch05;

class Animal2{
	void sound() {
		
	}
}
class Dog2 extends Animal2{
	// 오버라이딩 : 부모가 가진 속성을 자식이 사용함 (무효화하다)
	void sound() {
		System.out.println("멍멍");
	}
}
class Cat2 extends Animal2{
	// 오버라이딩 : 부모가 가진 속성을 자식이 사용함 (무효화하다)
	void sound() {
		System.out.println("야옹");
	}
}
class Bird2 extends Animal2{
	// 오버라이딩 : 부모가 가진 속성을 자식이 사용함 (무효화하다)
	void sound() {
		System.out.println("짹짹");
	}
}

public class Inherit03_2 {
	static void start (Animal2 a) {
		a.sound();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog2 d = new Dog2();
		Inherit03_2.start (d);
		
		Cat2 c = new Cat2();
		Inherit03_2.start (c);
		
		Bird2 b = new Bird2();
		Inherit03_2.start (b);
	}

}
