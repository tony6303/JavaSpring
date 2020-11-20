package ch05;

interface Knife{
	void 요리();
	void 상해();
}
//추상클래스는 Knife를 구현을 안해도 오류가 안난다
//추상 클래스는 어댑터의 용도로도 사용할 수 있다. (implements에서 구현할 내용을 걸러준다.)
abstract class 요리사Adapter implements Knife{
	public void 상해() {
		
	}
}

//일반 클래스는 Knife를 반드시 구현을 하라고 오류가 난다
//class 백종원 implements Knife{
//	
//}

class 백종원 extends 요리사Adapter{

	@Override
	public void 요리() {
		// TODO Auto-generated method stub
		
	}
	
}
public class Adapter01 {

}
