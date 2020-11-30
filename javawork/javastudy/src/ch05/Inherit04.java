package ch05;
interface Animal3{
	//인터페이스는 new할 수 없다. 왜냐면 추상 메소드를 가졌기 때문에
	void sound();
}
class Dog3 implements Animal3{
	// 오버라이딩 : 부모가 가진 속성을 자식이 사용함 (무효화하다)
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
class Cat3 implements Animal3{
	// 오버라이딩 : 부모가 가진 속성을 자식이 사용함 (무효화하다)
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}
class Bird3 implements Animal3{
	// 오버라이딩 : 부모가 가진 속성을 자식이 사용함 (무효화하다)
	@Override
	public void sound() {
		System.out.println("짹짹");
	}
}
class Tiger3 implements Animal3{
	// 오버라이딩 : 부모가 가진 속성을 자식이 사용함 (무효화하다)
	@Override
	public void sound() {
		System.out.println("어흥");
	}
}
class Monkey3 implements Animal3{
	@Override
	public void sound() {
		// 
		System.out.println("몽몽");
	}
}
public class Inherit04 {
	static void start (Animal3 a) {
		a.sound();
	}
	public static void main(String[] args) {
		// 
		//자기자신의 클래스의 static을 호출할 때는 클래스명 생략가능
		start(new Dog3());
		start(new Cat3());
		start(new Bird3());
		start(new Tiger3());
		start(new Monkey3());
	}

}
