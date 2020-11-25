package ch07;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class Error {
	private String msg;
}

@AllArgsConstructor
@Data
class User {
	private int id;
	private String username;
	private int myVal;
}

@AllArgsConstructor
@Data
class RespDto<T> { // new 할때 리턴 타입을 결정함
	private int code; // 200(정상), 400(실패)
	private T data;
}

public class Generic04 {
	
	// 함수를 호출할 때 리턴타입을 결정함
	static RespDto<?> getData(String username) {
		if(username.equals("ssar")) {
			RespDto<User> dto = new RespDto(200, new User(1, "ssar", 999));
			return dto;
		}else {
			RespDto<Error> dto = new RespDto(400, new Error("아이디가 틀렸습니다."));
			return dto;
		}
	}
	
	public static void main(String[] args) {
		RespDto<?> dto = getData("ssar");
		System.out.println(dto.getCode()); //lombok getcode
		System.out.println(dto.getData()); //lombok getdata
	}
}

