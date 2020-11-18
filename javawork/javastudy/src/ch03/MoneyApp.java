package ch03;

import java.util.Scanner;

public class MoneyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("금액을 입력하시오>>");
		int money = sc.nextInt();
		
		System.out.println("오만원권: "+ money/50000 +"매");
		money = money%50000;
		System.out.println("만원권: "+ money/10000 +"매");
		money = money%10000;
		System.out.println("오천원권: "+ money/5000 +"매");
		money = money%5000;
		System.out.println("천원권: "+ money/1000 +"매");
		money = money%1000;
		System.out.println("오백원: "+ money/500 +"개");
		money = money%500;
		System.out.println("백원: "+ money/100 +"개");
		money = money%100;
		System.out.println("십원: "+ money/10 +"개");
		money = money%10;
		System.out.println("일원: "+ money/1 +"개");
		
	}

}
