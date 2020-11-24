package ch10;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import lombok.Data;

public class LoginScreen extends JFrame{
	//무슨무슨 바인딩을 했음
	//Context = 스토커 (어떤 대상에 대해 모든걸 알고있는 녀석)
	private LoginScreen loginScreen = this;
	
	private JTextField tfUsername;
	private JButton btnLogin;

	
	public LoginScreen() {
		tfUsername = new JTextField("");
		btnLogin = new JButton("로그인");
		
		setTitle("HOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		
		Container c = getContentPane();
		c.add(tfUsername, BorderLayout.CENTER);
		c.add(btnLogin, BorderLayout.SOUTH);
		
		//이벤트
		initListener();
		
		setVisible(true);
	}
	//리스너 등록 모아두기
	private void initListener() {
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				if(username.equals("ssar")){
					//Context를 인자로 줌
					new HomeScreen(loginScreen);
					loginScreen.setVisible(false);
				}else {
					System.out.println("로그인 실패");
				}
			}
		});
	}
	public LoginScreen getLoginScreen() {
		return loginScreen;
	}
	public void setLoginScreen(LoginScreen loginScreen) {
		this.loginScreen = loginScreen;
	}
	public JTextField getTfUsername() {
		return tfUsername;
	}
	public void setTfUsername(JTextField tfUsername) {
		this.tfUsername = tfUsername;
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}
	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}
	
}
