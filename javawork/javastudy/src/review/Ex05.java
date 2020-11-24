package review;

public class Ex05 {
	public static void main(String[] args) {
		//배열 : 연속된 데이터 공간을 확보해주기 때문에 엑세스가 굉장히 빠름
		//단점 : 데이터추가, 삭제가 안됨
		//같은 타입의 여러 데이터를 저장가능한데, Object타입으로 만들면 모든 타입이 저장 가능
		//상속을 통해서 부모타입으로 묶으면 모든 타입이 저장 가능
		
		//배열은 크기가 정해져 있어야 함
		//컬렉션을 사용할 예정 (ArrayList) = 제네릭을 알아야 사용 가능
		int[] n1 = new int[3];
		
		Object[] n2 = new Object[3];
		//Wrapper 클래스
		n2[0] = "가"; // String
		n2[1] = 3; // Integer
		n2[2] = 10.5; // Double
		for (int i = 0; i < n2.length; i++) {
			System.out.println(n2[i]);
		}
		
	}
}
