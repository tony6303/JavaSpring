package review;
interface Helloable{
	void 안녕();
}
//첫 번째 방법
class AA implements Helloable{
	@Override
	public void 안녕() {
		// TODO Auto-generated method stub
		System.out.println("반갑습니다");
	}
}

public class Ex123 {
	//공통모듈을 만들기 위해서!! (매개변수가 인터페이스)
	static void start(Helloable h) {
		h.안녕();
	}
	
	public static void main(String[] args) {
		//첫번째 방법
		start(new AA());
		
		//두번째 방법 익명클래스
		start(new Helloable() {
			
			@Override
			public void 안녕() {
				// TODO Auto-generated method stub
				System.out.println("방가워요");
			}
		});
	}
}
