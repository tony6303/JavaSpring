package adapterPattern;

//Duck 객체 대신 Turkey라는 새로운 인터페이스를 사용해야하는 상황
//어댑터를 이용하여 Duck과 Turkey 를 호환
public class TurkeyAdapter implements Duck{
	Turkey turkey;

	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		turkey.gobble();
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		turkey.fly();
	}
	
	
}
