package star1;

public class Marine {
	//필드(프로퍼티)는 private로 만든다. 이유 마법 금지
	private String name;
	private int hp;
	private int attack;
	public Marine(String name, int hp, int attack) {
		//this 를 붙이게되면 항상 파일내의 heap변수를 지정하게된다. (필드, 프로퍼티)
		this.name = name; //this.name 이 아닌 그냥 name 을 하면 가까이있는 name을 지정하게된다.
		this.hp = hp;
		this.attack = attack;
	}
	public Marine() {
		// TODO Auto-generated constructor stub
	}
	
}
