package ch06;

public class String02 {
	public static void main(String[] args) {
		String a = "hello";
		String b = "hello";
		
		System.out.println("a의 길이는" + a.length());
		System.out.println(a.contains("l"));
		
		a = a.concat(" how are you");
		System.out.println(a);

		b.replace("hello", "hi");
		System.out.println(b);
		
		String[] s = a.split("e");
		for(int i=0; i<s.length; i++) {
			System.out.println("e로 분리된 문자열: " + s[i]);
		}
		
		a= a.substring(10); // 10번째 인덱스 이후의 서브스트링만 리턴
		System.out.println(a);
		
		
	}
}
