package review;

//강제성 부여
//사용자에게 편리한 인터페이스 제공
interface Remocon{
	void change();
}
class SamsungRemocon implements Remocon{
	@Override
	public void change() {
		System.out.println("Samsung 채널변경");
	}
	
}
class LGRemocon implements Remocon{
	@Override
	public void change() {
		System.out.println("LG 채널변경");
	}
	
}

public class Ex12 {
	static void 채널변경(Remocon r) {
		r.change();
	}
	public static void main(String[] args) {
		
		
		Remocon r = new LGRemocon();
		r.change();
		
		채널변경(new SamsungRemocon());
		채널변경(new LGRemocon());
		
		//익명클래스
		Remocon r2 = new Remocon() {
			
			@Override
			public void change() {
				// 
				
			}
		};
	}
}
