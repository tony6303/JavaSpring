package ch04;

class Bird {

}

public class PersonApp2 {

	public static void main(String[] args) {
		// 컴파일러는 Bird()라는 디폴트 생성자를 만들어준다.
		Bird b = new Bird();

		Person p1 = new Person("최승희", "의사", 45, '여', "A");
		p1.preview();

	}

}
