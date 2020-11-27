package ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		try {
			socket = new Socket("localhost",9999); //클라이언트 소켓 생성, 서버에 연결
			//소켓 입력 스트림
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//소켓 출력 스트림
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				System.out.println("보내기>>"); //프롬프트
				String outputMessage = sc.nextLine();
				if(outputMessage.equalsIgnoreCase("bye")) {
					out.write(outputMessage+"\n"); //bye 전송
					out.flush();
					break;  //bye 입력시 서버로 전송후 종료
				}
				out.write(outputMessage+ "\n");
				out.flush();
				String inputMessage = in.readLine();
				System.out.println("서버: "+ inputMessage);
			
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				sc.close();
				if(socket != null) socket.close();
			} catch (Exception e) {
				System.out.println("오류발생");
			}
		}
	}
}
