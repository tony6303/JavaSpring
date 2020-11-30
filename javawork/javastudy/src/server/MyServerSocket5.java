package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

import protocol.Chat;

public class MyServerSocket5 {
	private ServerSocket serverSocket;
	Vector<SocketThread> vc; //대기열 queue 다른클래스에서 써야하기때문에 private ㄴㄴ 
	
	//생성자
	public MyServerSocket5() {
		try {
			serverSocket = new ServerSocket(10000);
			vc = new Vector<>();
			while(true) { //accept 해야함
				System.out.println("요청 대기중...");
				//while 이기때문에 접속을 요청을 계속 기다림 accept()
				Socket socket = serverSocket.accept();//벡터에 담을 소켓
				
				// 1. 서버소켓이 클라이언트에 연결되면 새로운 소켓을 생성함(socket)
				// 2. 새로운 스레드를 생성함
				// 3. 새로운 스레드에게 socket 변수를 넘겨줘야함
				// 4. 새로운 스레드 자체를 vc에게 담기
				System.out.println("요청 받음");
				
				//소켓스레드 생성자(Socket , String)
				SocketThread st = new SocketThread(socket);
				st.start(); // run 실행
				vc.add(st); //벡터에 소켓스레드를 담음 (상태를 저장하기위해서)
			}
		} catch (Exception e) {
			System.out.println("서버 연결 오류");
			e.printStackTrace();
		}
	}
	
	//소켓스레드
	class SocketThread extends Thread{
		private Socket socket;
		private String id;
		private BufferedReader reader;
		private PrintWriter writer;
		
		//생성자
		public SocketThread(Socket socket) {
			this.socket = socket;
		}


		@Override
		//소켓 자체를 벡터에 담는것은 위험(상태가 없기때문)
		//그래서 스레드를 벡터에 담을거임
		public void run() {
			try {
				//메시지 읽어오기
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//메시지 써서 보내기
				writer = new PrintWriter(socket.getOutputStream());
				
				String input = null;
				while((input=reader.readLine()) != null) {
					//전체 메시지 보내기
					routing(input);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} //end of run
		
		private void routing(String input) {		
			String gubun[] = input.split(":");
			if(id == null) {
				if(gubun[0].equals(Chat.ID)) {
					// 변수에 ID 저장
					id = gubun[1];
					writer.println("당신의 아이디는 "+id+"입니다.");
					writer.flush();
				}else {
					writer.println("아이디를 먼저 입력하세요!");
					writer.flush();
					return;
				}


			}
			
			if(gubun[0].equals(Chat.ALL)) { // 전체채팅 ALL:안녕
				for (int i = 0; i < vc.size(); i++) {
					if(vc.get(i) != this) {
						vc.get(i).writer.println(id+"-->"+gubun[1]);
						vc.get(i).writer.flush();
					}
				}
			} else if(gubun[0].equals(Chat.MSG)) { // MSG:ssar1:안녕
				String tempId = gubun[1];
				String tempMsg = gubun[2];
				
				for (int i = 0; i < vc.size(); i++) {
					if(vc.get(i).id != null && vc.get(i).id.equals(tempId)) {
						vc.get(i).writer.println(id+"-->"+tempMsg);
						vc.get(i).writer.flush();
					}
				}
			}
		} //end of routing
	} //end of SocketThread
	
	

	public static void main(String[] args) {
		new MyServerSocket5();
	}
}
