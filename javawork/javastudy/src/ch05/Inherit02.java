package ch05;

class 지구인{
	String name = "지구인";
}

class 한국인 extends 지구인{
	String name = "한국인";
}

class 부산인 extends 한국인{
	String name = "부산인";
}
public class Inherit02 {

	public static void main(String[] args) {
		// 
		//heap 한국인, 지구인 -> pointer 지구인
		지구인 b = new 한국인();

//		한국인 h = b;
		//1. b는 한국인(자식), 지구인(부모)이 메모리에 다 있기 때문에 다운캐스팅 가능
		한국인 h = (한국인) b;
		
		//예외 처리
		try {
			부산인 busan = (부산인) b;
		} catch (Exception e) {
			System.out.println("오류발생");
		}
		
		
		
		
	}

}
