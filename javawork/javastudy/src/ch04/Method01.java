package ch04;

//�ڹ� Ư¡ : ����ڵ�� class ���ο� �ۼ��ؾ��Ѵ�.
public class Method01 {
	
	static void add() {
		System.out.println("�ֵ�");
	}	
	void sound() {
		System.out.println("����");
	}
	public static void main(String[] args) {
		// 
		Method01.add();
		
		Method01 m = new Method01();
		m.sound();
	}
	
	
}
