import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Repository {
	Map<String, Object> repo;
	//Map은 키와 값으로 구성된 Entry객체를 저장하는 구조를 가지고 있는 자료구조입니다. 여기서 키와 값은 모두 객체입니다.
	//어떤 값이 들어올지 모르기때문에 Object

	public Repository() { 
		//put 으로 repo 에 데이터 추가 (가상으로 테이블인척 하기위해)
		repo = new HashMap<>();
		repo.put("id",1);
		repo.put("username", "ssar");
		repo.put("password", "1234");
		repo.put("email", "ssar@nate.com");
		repo.put("createDate", Timestamp.valueOf(LocalDateTime.now()) );
		repo.put("updateDate", Timestamp.valueOf(LocalDateTime.now()) );
	}
	
	
}
