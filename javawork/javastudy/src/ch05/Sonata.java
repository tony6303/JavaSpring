package ch05;

public class Sonata extends Car implements Control{
	private String name;
	private Engine2000 engine2000;
	@Override
	public void 엑셀() {
		// 
		System.out.println("전진");
	}
	@Override
	public void 브레이크() {
		// 
		System.out.println("멈춤");
	}
}
