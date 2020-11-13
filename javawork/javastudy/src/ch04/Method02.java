package ch04;

class Dog{
	int 배고픔 = 100; //상태
	
	void eat() { //행위
		배고픔 = 10;
	}
}

public class Method02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d1 = new Dog();
		
		//마법 금지
//		d1.배고픔 = 10;  행위를 통한 상태변화를 해야한다.
		
		d1.eat();
		
		
		System.out.println("강아지의 배고픔"+ d1.배고픔 +"입니다");
	}

}
