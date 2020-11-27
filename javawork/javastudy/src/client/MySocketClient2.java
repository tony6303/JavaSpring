package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class MySocketClient2 {

	private Socket socket;
	private Scanner sc;
	private BufferedWriter writer;
	private BufferedReader reader;

	public MySocketClient2() {
		try {
			//서버쪽 accept()호출하기 //127.0.0.1 / 사설IP / localhost 
			socket = new Socket("localhost", 10000);
			
			//내가 메시지를 보낼 것이니까 output
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//사용자로 부터 입력받기.
			Scanner sc = new Scanner(System.in);
			
			//익명클래스의 경우로 만들어 봄. (MyServerSocket2 는 별도의 클래스를 만든 경우)
			new Thread(new Runnable() {
				@Override
				public void run() {
					String input = null;
					try {
						while((input = reader.readLine()) != null) {
							System.out.println("서버로부터온 메시지: "+input);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
			//end of 익명클래스
			
			//메인 스레드는 키보드로부터 입력을 받은 뒤 클라이언트 소켓에 전송
			String input = null;
			while(true) {
				input = sc.nextLine();
				writer.write(input+"\n");
				writer.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MySocketClient2();
	}

}
