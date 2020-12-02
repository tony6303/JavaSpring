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
	
	Vector<ClientInfo> vc; // ����� Ŭ���̾�Ʈ ������ ��� �÷���
	// Ŭ������ ������ composite�ؼ� ��������
	public ChatServer() {
		try {
			vc = new Vector<>();
			serverSocket = new ServerSocket(10000);
			System.out.println("Ŭ�� ���� �����");

			// ���ν����� : ���Ϳ� ���� ���
			while (true) {
				socket = serverSocket.accept();
				System.out.println("���� �Ϸ�");

				ClientInfo clientInfo = new ClientInfo(socket);
				clientInfo.start();
				vc.add(clientInfo);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	} //end of ChatServer

	// vc�� ���� Ŭ���̾�Ʈ ����
	class ClientInfo extends Thread {
		Socket socket;
		String id;
		BufferedReader reader;
		PrintWriter writer;

		// �� ������ ����������
		public ClientInfo(Socket socket) {
			this.socket = socket;
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		// Ŭ���̾�Ʈ�� ���� ���� �޽����� ��� Ŭ���̾�Ʈ���� �������ϴ� ����
		// �޽����� �ް�, �����ؾ��ϹǷ� reader, writer �ʿ�
		@Override
		public void run() {
			String input = null;
			try {
				
				writer.println("���̵� �Է��ϼ���. ��)ID:���̵�");
				writer.flush();

				while ((input = reader.readLine()) != null) {
					String gubun[] = input.split(":");
					if (id == null) {
						if (gubun[0].equals(Protocol.ID)) { // �Է¾�� ID:ssar
							// ������ ID ����
							id = gubun[1];
							writer.println("����� ���̵�� " + id + "�Դϴ�.");
							writer.flush();
						} else {
							writer.println("���̵� ���� �Է��ϼ���!");
							writer.flush();
//							return;
						}
					}else if (id != null) {
						for (int i = 0; i < vc.size(); i++) {
							if (vc.get(i) != this) { // ���� �ƴ� �ٸ� Ŭ���̾�Ʈ �鿡��
								vc.get(i).writer.println("[" + id + "] " + input); // �޽����� �Ѹ�
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
