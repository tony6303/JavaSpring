package composite;

import lombok.Data;

@Data
public class ShrimpBurgerSet {
	private ShrimpBurger shrimpburger;
	private Potato potato;
	private Coke coke;

	public ShrimpBurgerSet(ShrimpBurger shrimpBurger, Potato potato, Coke coke) {
		this.shrimpburger = shrimpBurger;
		this.potato = potato;
		this.coke = coke;
	}

	public ShrimpBurgerSet() {
		this(new ShrimpBurger(), new Potato(), new Coke());
	}
}
