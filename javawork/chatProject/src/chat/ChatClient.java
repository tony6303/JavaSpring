package chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	private static final String TAG ="ChatClient: ";
	private ChatClient chatClient = this;
	private ChatServer chatServer;
	
	private static final int PORT = 10000;
	
	private JButton btnConnect, btnSend;
	private JTextField tfHost, tfChat;
	private JTextArea taChatList;
	private ScrollPane scrollPane;
	private JPanel topPanel, bottomPanel;
	
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;
	
	public ChatClient() {
		init();
		setting();
		batch();
		listener();
		
		setVisible(true);
	}
	
	private void init() {
		btnConnect = new JButton("connect");
		btnSend = new JButton("send");
		tfHost = new JTextField("127.0.0.1", 20);
		tfChat = new JTextField(20);
		taChatList= new JTextArea(10, 30);
		scrollPane = new ScrollPane();
		topPanel = new JPanel();
		bottomPanel = new JPanel();
	}
	private void setting() {
		setTitle("ä�� �ٴ�� Ŭ���̾�Ʈ");
		setSize(350, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // ������� ?
		taChatList.setBackground(Color.orange);
		taChatList.setForeground(Color.blue);
	}
	private void batch() {
		topPanel.add(tfHost);
		topPanel.add(btnConnect);
		
		bottomPanel.add(tfChat);
		bottomPanel.add(btnSend);
		
		scrollPane.add(taChatList);
		
		add(topPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	private void listener() {
		btnConnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		tfChat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					send();
				}
			}
		});
	}
	
	class ReaderThread extends Thread{
		//while�� ���鼭 �����κ��� �޽����� �޾Ƽ� tachatlist�� �Ѹ���
		@Override
		public void run() {
			String input = null;
			try {				
				while((input = reader.readLine()) != null) {
					taChatList.append(input + "\n");					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void connect() {
		String host = tfHost.getText();
		try {
			socket = new Socket(host, PORT);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			ReaderThread rt = new ReaderThread();
			rt.start();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	private void send() {
		String chat = tfChat.getText();
		taChatList.append(chat + "\n"); //Ŭ���̾�Ʈ�� �Ѹ���
		//������ ����
		writer.write(chat+"\n");
		writer.flush();
		
		//chat ����
		tfChat.setText("");
		
	}
	public static void main(String[] args) {
		new ChatClient();
	}
}
