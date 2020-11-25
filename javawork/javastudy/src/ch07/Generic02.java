package ch07;

import java.util.ArrayList;
import java.util.List;

public class Generic02 {
	
	public static void main(String[] args) {
		//List가 ArrayList의 부모, List를 더 많이 씀
		List<String> list1 = new ArrayList<>();
		list1.add("사과");
		list1.add("딸기");
		list1.add(1,"배추"); //실제 메모리의 주소는 연속적이지 않다.		
		list1.add(1,"참외");
		
		int size = list1.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list1.get(i));
		}
		
	}
}
