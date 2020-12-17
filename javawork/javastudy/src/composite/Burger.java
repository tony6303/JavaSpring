package composite;

import lombok.Data;


public class Burger {
	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	private int price;
	private String desc;
	
	public Burger(int price, String desc) {
		
		this.price = price;
		this.desc = desc;
		System.out.println(desc + "이(가) 만들어졌습니다.");
	}



	public Burger() {
		this(1000,"기본버거");
	}

}
