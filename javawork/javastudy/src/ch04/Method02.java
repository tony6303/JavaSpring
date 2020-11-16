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
		
		//d1.배고픔 =10; 이렇게 변수를 바꿔버리면 마법이라서 안된다
		
		d1.eat();
		
		
		System.out.println("강아지의 배고픔 : "+d1.배고픔);
	}

}
