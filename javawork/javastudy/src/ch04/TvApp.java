package ch04;
class Tv{
	private String madeBy;
	private int year;
	private int size;
	
	public void show() {
		System.out.println(madeBy + "에서 만든 " + year + "년형 " + size + "인치 TV");
	}

	public Tv(String madeBy, int year, int size) {
		this.madeBy = madeBy;
		this.year = year;
		this.size = size;
	}
	
}
public class TvApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv myTV = new Tv("LG",2017,32);
		myTV.show();
	}

}
