package ch04;

public class Circle {
	int radius;
	String name;
	
	public Circle() { //������
		radius =1;
		name="";
	}
	
	public Circle(int r,String n) { //�����ε�
		radius =r;
		name=n;
	}
	
	public double getarea() {
		return 3.14*radius*radius;
	}
	
	
	public static void main(String[] args) {
		Circle pizza = new Circle(10,"�ڹ�����"); // �����ε��� ������(?)�� 10���� ������ ������
		
		double area = pizza.getarea();
		System.out.println(pizza.name + "�� ������" + area);
		
		Circle donut =new Circle(); // �⺻�������� �ʱ�ȭ ���� 1�� ������ ������
		donut.name ="��������";
		area = donut.getarea();
		System.out.println(donut.name + "�� ������"+ area);

	}
}
