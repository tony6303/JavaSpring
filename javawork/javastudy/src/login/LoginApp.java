package login;

public class LoginApp {
	static void userInfo(OAuth o){
		System.out.println("로그인 한 사용자는..");
		System.out.println(o.oAuthProvider());
		System.out.println(o.oAuthId());
		System.out.println(o.oAuthPassword());
		System.out.println(o.oAuthNickName());
	}
	
//	static void userInfo(Naver n){
//		System.out.println("로그인 한 사용자는..");
//		System.out.println(n.getId());
//		System.out.println(n.getPassword());
//		System.out.println(n.getNickName());
//	}
	public static void main(String[] args) {
		Facebook f = new Facebook();
		userInfo(f);
		
		Naver n = new Naver();
		userInfo(n);
	}
}
