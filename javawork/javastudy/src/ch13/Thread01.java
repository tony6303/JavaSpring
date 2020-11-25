package ch13;

//Thread 클래스는 Runnable을 또 상속받고있다.
class Another extends Thread{

	@Override
	public void run() {
		System.out.println("새로운 스레드 실행 됨");
		for (int i = 1; i <11; i++) {
			try {
				System.out.println("run" + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("새로운 스레드 종료");
	} 
	
}
public class Thread01 {
	public static void main(String[] args) {
		System.out.println("메인 스레드 실행 됨");
		
		//새로운 스레드 실행방법
		//1.객체생성  2.타겟 설정  3.실행
		//바로 밑 줄 Thread 컨트롤 클릭 해보세요
		Thread t1 = new Thread(new Another());
		t1.start();
		
		for (int i = 1; i <11; i++) {
			try {
				System.out.println("main" + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("메인 스레드 종료");
	} //end of main
}
