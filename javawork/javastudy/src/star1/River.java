package star1;

public class River {
	// 1.상태
		String name; //메모리공간을 읽기 전용으로 변경
		int hp;
		int attack;
		
		// 2.초기화를 위한 생성자(마법x)
		public River(String n, int h, int a) {
			name =n;
			hp =h;
			attack =a;
		}
		
		// 3.디폴트 생성자를 직접만들어준다.
		// 이유: 컴파일러가 안만들어주니깐
		public River() {
			
		}
		
		// 4.변수의 값을 변경하거나 확인하는 행위가 필요 
}
