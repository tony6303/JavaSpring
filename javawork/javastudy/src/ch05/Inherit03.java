package ch05;
class Animal{
	
}
class Dog{
	void sound() {
		System.out.println("멍멍");
	}
}
class Cat{
	void sound() {
		System.out.println("야옹");
	}
}
class Bird{
	void sound() {
		System.out.println("짹짹");
	}
}

public class Inherit03 {
	static void start(Dog d) {
		d.sound();
	}
	static void start(Cat c) {
		c.sound();
	}
	static void start(Bird b) {
		b.sound();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d = new Dog();
		Inherit03.start(d);
		
		Cat c = new Cat();
		Inherit03.start(c);
		
		Bird b = new Bird();
		Inherit03.start(b);
	}

}
