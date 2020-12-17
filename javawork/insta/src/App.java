import java.sql.Timestamp;
import java.util.Map;

import model.Member;

public class App {

	
	public static void main(String[] args) {	
		// 1. DB���� �� ��������
		Repository r1 = new Repository();
		Map<String, Object> m1 = r1.getRepo(); //lombok �Լ�
		//Map�� Ű�� ������ ������ Entry��ü�� �����ϴ� ������ ������ �ִ� �ڷᱸ���Դϴ�. ���⼭ Ű�� ���� ��� ��ü�Դϴ�.
		//� ���� ������ �𸣱⶧���� Object		
		
		// 2. �Ľ��ϱ� (����, ����)
		Member member = new Member(
				(Integer)m1.get("id"), // ������ �� ��ȯ ? �ٵ� ���� �̷��� ����
				(String)m1.get("username"),
				(String)m1.get("password"),
				(String)m1.get("userImg"),
				(String)m1.get("email")
				);
		
		System.out.println(member);
		
		Member member2 = Member.builder()
				.id(2)
				.username("cos")
				.password("1234")
				.email("ssar@nate.com")
				.build(); //lombok builder
	}
	

}
