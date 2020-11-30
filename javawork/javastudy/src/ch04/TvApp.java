package ch04;

class Tv2{
	private String madeBy;
	private int year;
	private int size;
	
	public void show() {
		System.out.println(madeBy + "에서 만든 " + year + "년형 " + size + "인치 TV");
	}

	public Tv2(String madeBy, int year, int size) {
		this.madeBy = madeBy;
		this.year = year;
		this.size = size;
	}
	
}
public class TvApp {

	public static void main(String[] args) {
		// 
		Tv2 myTV = new Tv2("LG",2017,32);
		myTV.show();
	}

}
