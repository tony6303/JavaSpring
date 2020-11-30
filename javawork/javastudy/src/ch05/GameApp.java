package ch05;

public class GameApp {

	static void start(Control c) {
		c.엑셀();
		c.브레이크();
	}
	public static void main(String[] args) {
		// 
		Truck t = new Truck();
		start(t);
	}

}
