package ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		try {
			listener = new ServerSocket(9999);
			System.out.println("연결중");
			socket = listener.accept();
			System.out.println("연결됨!");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String inputMessage = in.readLine(); //클라이언트로부터 한 행 읽기
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("bye로 연결종료됨");
					break; // 종료
				}
				System.out.println("클라이언트: "+inputMessage);
				System.out.println("보내기>>"); //프롬프트
				String outputMessage = sc.nextLine(); //키보드에서 한 행 읽기
				out.write(outputMessage + "\n"); //키보드에서 읽은 문자열 전송
				out.flush(); //out의 스트림 버퍼에 있는 모든 문자열 전송
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				sc.close();
				socket.close();
				listener.close();
			} catch (Exception e) {
				System.out.println("오류발생");
			}
		}
	}
}
