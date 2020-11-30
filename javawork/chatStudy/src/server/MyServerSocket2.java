package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import client.MySocketClient2;

public class MyServerSocket2 {
	private ServerSocket serverSocket;
	private Socket socket;
	private Scanner sc;
	private BufferedWriter writer;
	private BufferedReader reader;
	
	public MyServerSocket2() {
		try {
			serverSocket = new ServerSocket(10000);
			System.out.println("클라이언트 요청 대기중");
			socket = serverSocket.accept(); // 엄청 간단???
			System.out.println("요청 성공");
					
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			sc = new Scanner(System.in);
			
			String input = null;
			
			//스레드가 while 위에 있어야함
			Thread t1 = new Thread(new WriteThread());
			t1.start();
			
			//메인 스레드역할
			while((input = reader.readLine()) != null) {
				System.out.println("클라이언트로부터 온 메시지 : "+input);
//				input = sc.nextLine();
//				writer.write(input+"\n");
//				writer.flush();
			}
			reader.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
class WriteThread implements Runnable{
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {	
			try {
				String input = sc.nextLine();
				writer.write(input+"\n");
				writer.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
	public static void main(String[] args) {
		new MyServerSocket2();
	}
}
