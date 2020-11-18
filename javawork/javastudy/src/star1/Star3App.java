package star1;
//1. Zealot, Dragoon, Tank, Dark, SCV => StarUnit 타입 일치 
public class Star3App {
	//함수를통해 접근 ?
	//u1 -> u2 공격
	static void attack(StarUnit u1, StarUnit u2) {
//		System.out.println(u1.name +"->"+u2.name+"공격");
//		u2.getHp() = u2.hp - u1.attack;
		u2.setHp(u2.getHp() - u1.getAttack());
		System.out.println(u2.getName()+" 체력 :"+u2.getHp());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dark d = new Dark("닥템",70,50);
		Dragoon dra = new Dragoon("드라군",100,20);
		Marine m = new Marine("마린",40,5);
		River r = new River("리버",200,100);
		SCV s = new SCV("SCV",60,5);
		Tank t = new Tank("탱크",150,30);
		Zealot z = new Zealot("질럿",100,16);
		
		attack(m, r);
		attack(t,dra);
	}

}
