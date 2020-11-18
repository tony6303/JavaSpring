package ch03;

import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		//2장 3번 잘못품 
//		 System.out.println("금액을 입력하시오>>"); int money = sc.nextInt();
//		 
//		 System.out.println("오만원권: "+ money/50000 +"매"); money = money%50000;
//		 System.out.println("만원권: "+ money/10000 +"매"); money = money%10000;
//		 System.out.println("오천원권: "+ money/5000 +"매"); money = money%5000;
//		 System.out.println("천원권: "+ money/1000 +"매"); money = money%1000;
//		 System.out.println("오백원: "+ money/500 +"개"); money = money%500;
//		 System.out.println("백원: "+ money/100 +"개"); money = money%100;
//		 System.out.println("십원: "+ money/10 +"개"); money = money%10;
//		 System.out.println("일원: "+ money/1 +"개");
		
// 2장 4번 잘못 품
//		System.out.println("숫자 세 개를 입력하세요>>");
//		int n1 = sc.nextInt();
//		int n2 = sc.nextInt();
//		int n3 = sc.nextInt();
//		
//		int middle =0;
//		if((n1>n2) && (n3>n1) || (n2>n1) && (n1>n3)) {
//			//  n3>n1>n2             n2>n1>n3
//			middle = n1;
//		}else if((n2>n1)&&(n3>n2) || (n1>n2) && (n2>n3)) {
//			//      n3>n2>n1              n1>n2>n3
//			middle = n2;
//		}else {
//			//        n2>n3>n1               n1>n3>n2
//			middle = n3;
//		}
//		System.out.println("중간값은: " + middle);

		//3장 6번
		int[] unit = {50000,10000,5000,1000,500,100,10,1};
		
		System.out.println("금액을 입력하시오>>");
		int money = sc.nextInt();
		
		for(int i=0; i<unit.length; i++) { //unit.length : 배열 길이를 알아서 지정해주는 기능
			int num = money / unit[i];      // ▽개수 변수
			System.out.println(unit[i]+"원짜리 " + num +"개");
			money = money % unit[i];  // 나머지 연산
		}
	}

}
