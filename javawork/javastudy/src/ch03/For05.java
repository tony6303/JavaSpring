package ch03;

public class For05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		
		for(int i=1; i<=100; i++) {
			if(i%3==0) {
				sum = sum + i;
			}else
				continue;
		}
		System.out.println("1부터 100까지 3의배수의 합: "+ sum);
	}

}
