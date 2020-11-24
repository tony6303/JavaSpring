package review;

import lombok.Data;

//커스텀 자료형
@Data // toString, get, set 생성
class Product{
	private int no;
	private int price;
	private String name;
}

public class Ex04 {
	public static void main(String[] args) {
		//클래스 자료형 : 여러가지 타입의 데이터가 섞여있을 때 사용
		Product p1 = new Product();
		System.out.println(p1);
	}
}
