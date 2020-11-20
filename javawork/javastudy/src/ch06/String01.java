package ch06;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//Dto = Data Transfer Object 통신용
class UserDto{
	private int id;
	private String name;
}

public class String01 {
	public static void main(String[] args) {
		String data = "id:1, name:홍길동";
		UserDto dto = new UserDto();
		dto.setId(1);
		dto.setName("홍길동");
		
	}
}
