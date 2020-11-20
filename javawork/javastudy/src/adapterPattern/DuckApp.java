package adapterPattern;

//한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환합니다.
//어댑터를 이용하면 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스들을 연결해서 쓸 수 있습니다.



//구식의코드 (Duck) 에 어댑터를 꽂아서 새로운 코드(Turkey)를 사용할 수 있다.
//옛 코드를 새 코드 처럼 사용할 수 있다.  라고한다;

public class DuckApp {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();
		
		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		
		
		System.out.println("Turkey says...");
		turkey.gobble();
		turkey.fly();
		
		System.out.println("\nDuck says...");
		testDuck(duck);
		
		//Duck 대신 어댑터로 변환시킨 Turkey를 넘김.
		System.out.println("\nTurkeyAdapter says..");
		testDuck(turkeyAdapter);
	}
	
	static public void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}
