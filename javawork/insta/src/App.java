import java.sql.Timestamp;
import java.util.Map;

import model.Member;

public class App {

	
	public static void main(String[] args) {	
		// 1. DB에서 값 가져오기
		Repository r1 = new Repository();
		Map<String, Object> m1 = r1.getRepo(); //lombok 함수
		//Map은 키와 값으로 구성된 Entry객체를 저장하는 구조를 가지고 있는 자료구조입니다. 여기서 키와 값은 모두 객체입니다.
		//어떤 값이 들어올지 모르기때문에 Object		
		
		// 2. 파싱하기 (순서, 개수)
		Member member = new Member(
				(Integer)m1.get("id"), // 묵시적 형 변환 ? 근데 원래 이렇게 안함
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
