package ch06;

public class Wrapper01 {
	public static void main(String[] args) {
		int num = 10;
		Integer num2 = 20;
		
//		int는 클래스가 아니라서 안됨
//		String num3 = num.toString();
		String num3 = num2.toString();
		System.out.println(num3 + 10);
		
		String num4 = num + "";
		
		String num5 = "10";
		int num6 = Integer.parseInt(num5);
		System.out.println(num6 + 10);
		//기본 타입을 wrapper로 바꾸는이유는? 함수를 사용하고싶어서(boxing)
	}
}
