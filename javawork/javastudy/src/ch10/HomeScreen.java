package ch10;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

import lombok.Data;

public class HomeScreen extends JFrame{
	private HomeScreen homeScreen = this;
	private LoginScreen loginScreen;
	
	private JLabel laUsername;
	
	//기본 생성자
	public HomeScreen() {
		this(null);
//		setTitle("LOGIN");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setSize(400,500);
//		setVisible(true);
	}
	
	//오버로딩 (로그인 후)
	public HomeScreen(LoginScreen loginScreen) {
		this.loginScreen = loginScreen;

		laUsername = new JLabel(loginScreen.getTfUsername().getText());
		
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		
		Container c = getContentPane();
		c.add(laUsername, BorderLayout.CENTER);
		
		setVisible(true);
	}

	public HomeScreen getHomeScreen() {
		return homeScreen;
	}

	public void setHomeScreen(HomeScreen homeScreen) {
		this.homeScreen = homeScreen;
	}

	public LoginScreen getLoginScreen() {
		return loginScreen;
	}

	public void setLoginScreen(LoginScreen loginScreen) {
		this.loginScreen = loginScreen;
	}

	public JLabel getLaUsername() {
		return laUsername;
	}

	public void setLaUsername(JLabel laUsername) {
		this.laUsername = laUsername;
	}
	
}
