package composite;

public class BigBurger extends Burger{
	
	
	public BigBurger() {
		this(2000,"빅버거");
	}
	public BigBurger(int price, String desc) {
		super(price,desc);
	}
}
