package ch03;

public class If01 {

	public static void main(String[] args) {
		// 
		if(true) {
			System.out.println("조건 true실행됨");
		}
		
		if(false) {
			System.out.println("조건 false실행안됨");
		}
		
		int num = 3;
		if(num >1) {
			System.out.println("num은 1보다 큽니다.");
		} else {
			System.out.println("num은 1보다 작습니다.");
		}
		
		int sum = 30;
		if (sum==10) {
			System.out.println("sum은 10입니다.");
		}else if(sum==20) {
			System.out.println("sum은 20입니다.");
		}else {
			System.out.println("sum은 10도 20도 아닙니다.");
		}
		int c=0, b=3;
		if(c==0) {
			System.out.println("c1");
		}else if(b==3)
			System.out.println("b3");
	}

}
