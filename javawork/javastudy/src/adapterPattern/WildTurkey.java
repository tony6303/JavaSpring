package adapterPattern;

public class WildTurkey implements Turkey{

	@Override
	public void gobble() {
		// 
		System.out.println("Gobble gobble");
	}

	@Override
	public void fly() {
		System.out.println("I can't flying");
	}
	
}
