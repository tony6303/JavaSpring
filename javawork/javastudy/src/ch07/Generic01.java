package ch07;

import lombok.Data;

@Data
class ResponseDto<T> {
	private int statusCode; // 200=성공 , 300=다시요청, 400=잘못된요청
	private T data; //아직 뭐가 들어 올지 모르겠다는 뜻
	
//	private Object data; //어떤 데이터가 들어올지 모르겠어서 오브젝트로 정의
//	그런데 꺼낼때 다시 캐스팅해줘야해서 매우 불편
}
@Data
class Dog{
	String name = "안녕";
}

public class Generic01 {
	public static void main(String[] args) {
		ResponseDto<Dog> dto = new ResponseDto();
		Dog d = new Dog();
		dto.setStatusCode(200);
		dto.setData(d);

		if (dto.getStatusCode() == 200) {
			System.out.println(dto.getData().name);
		}
	}
}
