package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
//클라이언트 >> 서버 단방향 통신
public class MyServerSocket {
	private ServerSocket serverSocket;
	private Socket socket; //채팅을 실질적으로 하는 소켓
	private BufferedReader reader; //클라가 하는말 받아오기
	
	public MyServerSocket() {
		try {
			serverSocket = new ServerSocket(10000); //서버 소켓 생성
			System.out.println("클라이언트 요청 대기중");
			socket = serverSocket.accept(); // 접속대기, 접속
			System.out.println("요청 성공");
					
			//클라가 하는말 받아옴
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			String input = null;
			//메인 스레드역할
			while((input = reader.readLine()) != null) {
				System.out.println("클라이언트 : "+input);
			}
			//프로그램 종료시 실행
			reader.close();
			socket.close();
		} catch (Exception e) {
			
		}
	}
	public static void main(String[] args) {
		new MyServerSocket();
	}
}
