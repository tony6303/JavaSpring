package ch04;
class User{
	private int id;
	private String name;
	private String phone;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
public class Array01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User[] users = new User[3];
		
		users[0] = new User(1, "홍길동", "01012345678");
		users[1] = new User(2, "홍동", "01012345678");
		users[2] = new User(3, "홍길", "01012345678");
		
		System.out.println(users[0].getName());
	}

}
