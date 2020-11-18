package ch05;

class Father{
	int money = 10000;
}
class Son extends Father{
	int money = 20000;
}

public class inherit01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son s = new Son();
		//1. 변수를 찾으러 가면, 찾을 때 변수가 있으면 그 변수를 사용. 없으면 부모를 찾아 올라감.
		System.out.println(s.money);
		
		//2. new를하면 Father과 Son이 heap에 뜬다. 하지만 생성자는 Son만 호출 됨.
		//가리키는 메모리 주소는 타입을 따라간다.
		Father f = new Son();
		System.out.println(f.money);
		
	}

}
