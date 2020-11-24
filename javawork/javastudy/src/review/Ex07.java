package review;

/**
 * 
 * @author ldy
 * static은 시작하기전에 메모리에 로딩된다.
 * 그러므로 static 데이터는 중복될 수 없다. 단 한번만 메모리에 로딩 되기 때문
 * 두 개가 메모리에 뜰 수 없음 => static 데이터는 공유될 수 있는 데이터
 * 
 * heap은 new할 때 메모리에 뜬다. 타이밍이 무조건 static보다 늦음
 * 개발자가 원하는 만큼 메모리에 로딩할 수 있음
 * 자동차 공장에서 소나타를 3대 찍어내면 3대는 모두 다른 소나타이다.
 *
 */
public class Ex07 {
	int num = 10; // 안 뜸. new 해야 메모리에 뜸
	static int sum = 20; //main 이 시작되기 전에 메모리에 뜸
	
	public static void main(String[] args) {
		System.out.println(Ex07.sum);
		
		Ex07 e = new Ex07();
		System.out.println(e.num);
	}
}
