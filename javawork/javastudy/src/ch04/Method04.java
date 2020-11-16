package ch04;

//ctrl+shift+F 코드정렬
//method 안에 method를 정의할 수 없다
//변수에 메서드를 담을 수 없다.
public class Method04 {
	int money = 10000; //heap
	
	void add(int num) { //int num stack , add() heap
		money = money + num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method04 m = new Method04();
		m.add(50000);
		System.out.println(m.money);
	}

}
