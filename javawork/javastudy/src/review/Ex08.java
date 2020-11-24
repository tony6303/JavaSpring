package review;

public class Ex08 {
	void add(int n1, int n2) {
		System.out.println(n1 + n2);
	}
	int add2(int n1, int n2) {
		return n1+n2;
	}
	int minus(int n1, int n2) {
		return n1-n2; //함수를 호출한 문장의 값이 n1-n2로 변경 됨.
	}
	
	public static void main(String[] args) {
		Ex08 e = new Ex08();
		e.add(10,10);
		System.out.println(e.add2(30,30));
		int result = e.minus(50,5);
		System.out.println(result);
	}
}
