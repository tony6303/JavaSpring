package ch04;

public class Circle {
	int radius;
	String name;
	
	public Circle() { //생성자
		radius =1;
		name="";
	}
	
	public Circle(int r,String n) { //오버로딩
		radius =r;
		name=n;
	}
	
	public double getarea() {
		return 3.14*radius*radius;
	}
	
	
	public static void main(String[] args) {
		Circle pizza = new Circle(10,"자바피자"); // 오버로딩된 생성자(?)로 10으로 면적이 구해짐
		
		double area = pizza.getarea();
		System.out.println(pizza.name + "의 면적은" + area);
		
		Circle donut =new Circle(); // 기본생성자의 초기화 값인 1로 면적이 구해짐
		donut.name ="도넛피자";
		area = donut.getarea();
		System.out.println(donut.name + "의 면적은"+ area);

	}
}
