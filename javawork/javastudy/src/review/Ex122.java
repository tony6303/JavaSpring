package review;

class 저장소{
	String data;
	
	String 다운로드() {
		data = "GTA5 게임";
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return data;
	}
}

//자바에서는 메서드를 함수의 매개변수(인수)로 전달 할 수는 없다.
//메서드를 함수의 매개변수(인수)로 전달하고 싶으면 무조건 인터페이스에 함수를 담아야한다.
public class Ex122 {
	public static void main(String[] args) {
		저장소 s = new 저장소();
		System.out.println(s.다운로드());
	}
}
