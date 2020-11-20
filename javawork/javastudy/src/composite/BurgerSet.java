package composite;

import lombok.Data;

@Data
public class BurgerSet {
	private Burger burger;
	private Potato potato;
	private Coke coke;

	public BurgerSet(Burger burger, Potato potato, Coke coke) {
		this.burger = burger;
		this.potato = potato;
		this.coke = coke;
	}

	public BurgerSet() {
		this(new Burger(), new Potato(), new Coke());
	}
}
