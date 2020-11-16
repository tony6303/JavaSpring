package ch04;

public class Person {
	String name;
	String job;
	int age;
	char gender;
	String blood;
	
	//�ʱ�ȭ�� ������
	public Person(String n, String j, int a, char g, String b) {
		System.out.println("사람이 태어남");
		name = n;
		job = j;
		age = a;
		gender = g;
		blood = b;
	
	}
	void preview() {
		System.out.println("==== name ====");
		System.out.println("이름 " + name);
		System.out.println("직업 " + job);
		System.out.println("나이 " + age);
		System.out.println("성별 " + gender);
		System.out.println("혈액형 " + blood);
	}

}
