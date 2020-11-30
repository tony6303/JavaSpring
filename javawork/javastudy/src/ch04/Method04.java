package ch04;

//ctrl+shift+F �ڵ�����
//method �ȿ� method�� ������ �� ����
//������ �޼��带 ���� �� ����.
public class Method04 {
	int money = 10000; //heap
	
	void add(int num) { //int num stack , add() heap
		money = money + num;
	}

	public static void main(String[] args) {
		// 
		Method04 m = new Method04();
		m.add(50000);
		System.out.println(m.money);
	}

}
