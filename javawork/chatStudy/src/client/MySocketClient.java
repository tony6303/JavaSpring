package client;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
//클라이언트 >> 서버 단방향 통신
public class MySocketClient {

	Socket socket = null;
//	PrintWriter writer = null;
	BufferedWriter writer2 = null;

	public MySocketClient() {
		try {
			//서버쪽 accept()호출하기 //127.0.0.1 / 사설IP / localhost 
			socket = new Socket("localhost", 10000);
			
			//내가 메세지를 보낼거니깐 output
//			writer = new PrintWriter(socket.getOutputStream());
			writer2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//사용자로 부터 입력받기.
			Scanner sc = new Scanner(System.in);
			
			String line = null;
			while(true) {
				line = sc.nextLine();
				writer2.write(line+"\n");
				writer2.flush();
//				writer.println(line);
//				writer.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MySocketClient();
	}

}
