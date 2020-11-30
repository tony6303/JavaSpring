package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MySocketClient5 {
	private Socket socket;
	private BufferedReader reader; //메시지 읽어오기
	
	private Scanner sc;
	private PrintWriter writer; //메시지 써서 보내기
	
	public MySocketClient5() {
		try {
			socket = new Socket("localhost", 10000);
			
			sc= new Scanner(System.in);
			writer = new PrintWriter(socket.getOutputStream());
			
			SocketThread st = new SocketThread();
			st.start();
			//while 위에 작성해야합니다
			
			while(true) {
				//ALL:안녕 , MSG:ssar1:안녕
				
				String keyboard = sc.nextLine();
				writer.println(keyboard);
				writer.flush();
			}
		}
		catch (IOException e) {
			System.out.println("서버 연결 실패");
			e.printStackTrace();
		}
	}
	
	class SocketThread extends Thread{
		//읽기만 하면 됨
		@Override
		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String input = null;
				while((input = reader.readLine())!= null) {
					System.out.println(input);					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new MySocketClient5();
	}
}
