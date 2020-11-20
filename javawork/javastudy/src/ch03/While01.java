package ch03;

import java.util.Scanner;

public class While01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//Daemon process : 끝이없는 프로세스
		while(true) {
			int num = sc.nextInt();
			System.out.println("받은 값: "+num);
			if(num < 0)
				break;
		}
	}

}
