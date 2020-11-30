package login;

public class Naver implements OAuth{
	private String provider;
	private String email;
	private String password;
	private String userName;
	
	public Naver() {
		// 
		this("naver", "arss@nate.com", "5678", "깨봉2");
	}
	
	public Naver(String provider, String email, String password, String userName) {
		this.provider = provider;
		this.email = email;
		this.password = password;
		this.userName = userName;
	}
	@Override
	public String oAuthProvider() {
		// 
		return provider;
	}
	@Override
	public String oAuthId() {
		return email;
	}
	@Override
	public String oAuthPassword() {
		return password;
	}
	@Override
	public String oAuthNickName() {
		return userName;
	}
}
