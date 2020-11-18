package ch03;

public class For02 {

	public static void main(String[] args) {
		//짝수
//		for (int i = 1; i <= 101; i++) {
//			if(i%2==0) {
//				System.out.println("2의배수:" + i);
//			}			
//		}
		
		for (int i = 1; i <= 101; i++) {
			if(!(i%2==0)) {
				System.out.println("홀수:" + i);
			}			
		}
	}

}
