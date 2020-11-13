package ch02;

//클래스 자료형
class Car{
	static int power = 2000;
	static String color = "하얀색";
	static String name = "소나타";
	static String type = "승용차";
}

public class Var07 {
	static int power = 3000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Car.power);
		System.out.println(Car.color);
		System.out.println(Car.name);
		System.out.println(Car.type);
		System.out.println(Var07.power);
	}

}
