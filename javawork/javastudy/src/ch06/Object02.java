package ch06;

public class Object02 {
	
	public static void main(String[] args) {
		String str = "홍길동";
		System.out.println(str.hashCode());
		
		String str2 = "홍길동";
		System.out.println(str2.hashCode());
		
		str = "임꺽정";
		System.out.println(str.hashCode());
	}
}
