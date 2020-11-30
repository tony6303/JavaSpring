package login;

public class Facebook implements OAuth{
	private String provider;
	private String id;
	private String password;
	private String nickName;
	
	public Facebook() {
		// 
		this("facebook", "ssar@nate.com", "1234", "깨봉");
	}

	public Facebook(String provider, String id, String password, String nickName) {
		this.provider = provider;
		this.id = id;
		this.password = password;
		this.nickName = nickName;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String oAuthProvider() {
		// 
		return provider;
	}
	@Override
	public String oAuthId() {
		// 
		return id;
	}
	@Override
	public String oAuthPassword() {
		return password;
	}
	@Override
	public String oAuthNickName() {
		return nickName;
	}
	
}
