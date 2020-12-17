import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Repository {
	Map<String, Object> repo;
	//Map�� Ű�� ������ ������ Entry��ü�� �����ϴ� ������ ������ �ִ� �ڷᱸ���Դϴ�. ���⼭ Ű�� ���� ��� ��ü�Դϴ�.
	//� ���� ������ �𸣱⶧���� Object

	public Repository() { 
		//put ���� repo �� ������ �߰� (�������� ���̺���ô �ϱ�����)
		repo = new HashMap<>();
		repo.put("id",1);
		repo.put("username", "ssar");
		repo.put("password", "1234");
		repo.put("email", "ssar@nate.com");
		repo.put("createDate", Timestamp.valueOf(LocalDateTime.now()) );
		repo.put("updateDate", Timestamp.valueOf(LocalDateTime.now()) );
	}
	
	
}
