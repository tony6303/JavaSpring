//package star1;
//
//public class Star1App {
//	static void attack(Zealot u1,Dragoon u2) {
//		System.out.println(u1.name +"->"+u2.name+"공격");
//		u2.hp = u2.hp - u1.attack; //90
//		System.out.println(u2.name+" :"+u2.hp);
//		
//	}
//	
//	static void attack(Dragoon u1,Zealot u2) {
//		System.out.println(u1.name +"->"+u2.name+"공격");
//		u2.hp = u2.hp - u1.attack; //90
//		System.out.println(u2.name+ ":"+ u2.hp);
//		
//	}
//	static void attack(Dragoon u1,Dragoon u2) {
//		System.out.println(u1.name +"->"+u2.name+"공격");
//		u2.hp = u2.hp - u1.attack; //90
//		System.out.println(u2.name +":"+ u2.hp);
//		
//	}
//	static void attack(Dark u1,Zealot u2) {
//		System.out.println(u1.name +"->"+u2.name+"공격");
//		u2.hp = u2.hp - u1.attack;
//		System.out.println(u2.name +":"+ u2.hp);
//	}
//	
//	
//	public static void main(String[] args) {
//		Zealot z1 = new Zealot("질럿1",100,10);
//		Dragoon d1= new Dragoon("드라군1",100,20);
//		Dragoon d2 =new Dragoon("드라군2",100,20);
//		Dark dar1=new Dark("다크템플러1",100,50);
//		
//		//1. 질럿1 - > 드라군1 공격
//		attack(z1,d1);
//		
//		//2. 드라군1->질럿1 공격
//		attack(d1,z1);
//		
//		//3.드라군1 -> 드라군2 공격
//		attack(d1,d2);
//		
//		//4.다크템플러1 -> 질럿1 공격 (다크템플러1,100,50)
//		attack(dar1,z1);
//		//5.다크템플러2 -> 드라군1 공격
//		
//		
//	}
//}
