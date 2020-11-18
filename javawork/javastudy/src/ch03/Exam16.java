package ch03;

import java.util.Scanner;

public class Exam16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String user;
		String str[] = {"가위", "바위", "보"};
		Scanner s = new Scanner(System.in);
		
		while(true) {
			int n = (int)(Math.random()*3);
			
			System.out.println("\n가위바위보 게임을 시작합니다.");
			System.out.print("가위 바위 보!>>");
			user = s.nextLine();
			
			if(str[n].equals("가위")) {
				if(user.equals("가위")) {
					System.out.print("사용자: "+ user + ", 컴퓨터: "+ str[n] + ", ");
					System.out.print("비겼습니다");
				}else if(user.equals("바위")) {
					System.out.print("사용자: "+ user + ", 컴퓨터: "+ str[n] + ", ");
					System.out.print("이겼습니다");
				}else if(user.equals("보")) {
					System.out.print("사용자: "+ user + ", 컴퓨터: "+ str[n] + ", ");
					System.out.print("졌습니다");
				}else if(user.equals("그만")){
					System.out.println("게임을 종료합니다...");
					break;
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}else if(str[n].equals("바위")) {
				if(user.equals("가위")) {
					System.out.print("사용자: "+ user + ", 컴퓨터: "+ str[n] + ", ");
					System.out.print("졌습니다");
				}else if(user.equals("바위")) {
					System.out.print("사용자: "+ user + ", 컴퓨터: "+ str[n] + ", ");
					System.out.print("비겼습니다");
				}else if(user.equals("보")) {
					System.out.print("사용자: "+ user + ", 컴퓨터: "+ str[n] + ", ");
					System.out.print("이겼습니다");
				}else if(user.equals("그만")){
					System.out.println("게임을 종료합니다...");
					break;
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}else if(str[n].equals("보")) {
				if(user.equals("가위")) {
					System.out.print("사용자: "+ user + ", 컴퓨터: "+ str[n] + ", ");
					System.out.print("이겼습니다");
				}else if(user.equals("바위")) {
					System.out.print("사용자: "+ user + ", 컴퓨터: "+ str[n] + ", ");
					System.out.print("졌습니다");
				}else if(user.equals("보")) {
					System.out.print("사용자: "+ user + ", 컴퓨터: "+ str[n] + ", ");
					System.out.print("비겼습니다");
				}else if(user.equals("그만")){
					System.out.println("게임을 종료합니다...");
					break;
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}

		}
		
	}

}
