package review;

//자바는 함수만 만들 수가 없다.

//OOP 위반
//class A{
//	void add() {
//		System.out.println("더하기");
//	}
//}
interface A{
	void add();
}
class 운동선수{
	int 근육량 = 10;
	
	void 벌크업() {
		근육량 = 근육량 + 30;
	}
}
public class Ex121 {
	public static void main(String[] args) {
		new A() {
			@Override
			public void add() {
				System.out.println("더하기");
			}
		}.add();
	}
}
