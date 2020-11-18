package ch05;

//1. 인터페이스는 new 할수없다
//2. 인터페이스는 변수를 가질수있다. 그변수는 public static final 이다.
//3. 인터페이스는 추상메서드를 가진다. 그 메서드는 public abstract 이다
//4.
interface Remocon{
	public static final String name="리모컨";
	public abstract void control();
}
public class Interface01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
