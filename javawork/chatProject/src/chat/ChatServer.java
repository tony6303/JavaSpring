package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {
	private static final String TAG = "ChatServer :";
	private ChatServer chatServer = this;

	private ChatClient chatClient;
	private ServerSocket serverSocket;
	private Socket socket;
	
	Vector<ClientInfo> vc; // 연결된 클라이언트 소켓을 담는 컬렉션
	// 클래스의 소켓을 composite해서 담을거임
	public ChatServer() {
		try {
			vc = new Vector<>();
			serverSocket = new ServerSocket(10000);
			System.out.println("클라 연결 대기중");

			// 메인스레드 : 벡터에 정보 담기
			while (true) {
				socket = serverSocket.accept();
				System.out.println("연결 완료");

				ClientInfo clientInfo = new ClientInfo(socket);
				clientInfo.start();
				vc.add(clientInfo);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	} //end of ChatServer

	// vc에 담을 클라이언트 정보
	class ClientInfo extends Thread {
		Socket socket;
		String id;
		BufferedReader reader;
		PrintWriter writer;

		// 난 소켓을 가지고있음
		public ClientInfo(Socket socket) {
			this.socket = socket;
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		// 클라이언트로 부터 받은 메시지를 모든 클라이언트에게 재전송하는 역할
		// 메시지를 받고, 전송해야하므로 reader, writer 필요
		@Override
		public void run() {
			String input = null;
			try {
				
				writer.println("아이디를 입력하세요. 예)ID:아이디");
				writer.flush();

				while ((input = reader.readLine()) != null) {
					String gubun[] = input.split(":");
					if (id == null) {
						if (gubun[0].equals(Protocol.ID)) { // 입력양식 ID:ssar
							// 변수에 ID 저장
							id = gubun[1];
							writer.println("당신의 아이디는 " + id + "입니다.");
							writer.flush();
						} else {
							writer.println("아이디를 먼저 입력하세요!");
							writer.flush();
//							return;
						}
					}else if (id != null) {
						for (int i = 0; i < vc.size(); i++) {
							if (vc.get(i) != this) { // 내가 아닌 다른 클라이언트 들에게
								vc.get(i).writer.println("[" + id + "] " + input); // 메시지를 뿌림
								vc.get(i).writer.flush();
//								ClientInfo ci = vc.get(i);
//								ci.sendMessage(msg);
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} //end of run
	}//end of ClientInfo

		public static void main(String[] args) {
			new ChatServer();
		}
}
