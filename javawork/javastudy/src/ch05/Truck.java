package ch05;

public class Truck extends Car implements Control{
	private String name;
	private Engine5000 engine5000;
	@Override
	public void 엑셀() {
		// TODO Auto-generated method stub
		System.out.println("전진");
	}
	@Override
	public void 브레이크() {
		// TODO Auto-generated method stub
		System.out.println("멈춤");
	}
}
