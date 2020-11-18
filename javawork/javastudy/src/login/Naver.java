package login;

public class Naver implements OAuth{
	private String provider;
	private String email;
	private String password;
	private String userName;
	
	public Naver() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return provider;
	}
	@Override
	public String oAuthId() {
		// TODO Auto-generated method stub
		return email;
	}
	@Override
	public String oAuthPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String oAuthNickName() {
		// TODO Auto-generated method stub
		return userName;
	}
}
