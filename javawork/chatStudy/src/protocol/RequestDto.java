package protocol;

import lombok.Data;

@Data
public class RequestDto {
	//데이터가 몇 개 필요한지 모를 때?
	//"일단" String 다 때려넣음 , 그리고 개발이 다 끝나면 제네릭으로 리팩토링(재설계)
	private String gubun;
	private String id;
	private String msg;
}
