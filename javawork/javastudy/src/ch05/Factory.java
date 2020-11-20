package ch05;
//추상클래스
//추상메서드 , 일반메서드 선언 가능. 추상메서드는 구현하면 안 됨 
public abstract class Factory {
	//protected  같은패키지 + 자식만 찾을 수 있음
	protected abstract void 색칠();
	protected void 건조() {
		System.out.println("건조완료");
	}
	public void 가동() {
		색칠();
		건조();
	}
}
