package app;

import java.lang.reflect.Field;

import dto.JoinDto;
import dto.LoginDto;

public class ReflectApp {
	public static void main(String[] args) {
		LoginDto loginDto = new LoginDto();
		loginDto.setUsername("ssar");
		loginDto.setPassword("1234");
		myReflect(loginDto);

		JoinDto joinDto = new JoinDto();
		joinDto.setUsername("ssar");
		joinDto.setPassword("1234");
		joinDto.setEamil("ssar@nate.com");
		myReflect(joinDto);
		
		
	}
	
	static <T> void myReflect(T dto) { //<T>는 자료형이랑은 상관없음
//	static void myReflect(LoginDto dto) {
		
//		Method[] methods = loginDto.getClass().getDeclaredMethods();
//		Method[] methods = dto.getClass().getMethods();
//		for (Method method : methods) { // foreach : 배열의 크기만큼 반복함
//			System.out.println(method.getName());
//		}

		Field[] fs = dto.getClass().getDeclaredFields();
//		Field[] fs = loginDto.getClass().getFields();
//		for (Field field : fs) {
//			System.out.println(field.getName());
//		}
		
		for (Field field : fs) {
			field.setAccessible(true); // private에 접근하게 해주는거
			try {				
				Object o = field.get(dto);
				System.out.println(o);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
}
