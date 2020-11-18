package ch03;

public class For04 {

	static void Star1() {
		int i=1;
		for(i=1; i<=3; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for(int k=i-2; k>=1; k--) {
			for(int l=1; l<=k; l++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	static void Star2() {
		int n=5;
		for(int i=1; i<=n; i++) {
			for(int k=n; k>i; k--) {
				System.out.print(" ");
			}
			for(int j=1; j<=i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for(int i=1; i<=n-1; i++) {
			for(int k=1; k<=i; k++) {
				System.out.print(" ");
			}
			for(int j=2*n-1; j>2*i; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
//		Star1();
		
		Star2();
	}

}
