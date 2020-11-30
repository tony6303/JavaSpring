package ch04;

class TV{
	private int size;
	private String mf;
	public TV() {
//		size = 32;
//		mf = "LG";
//		System.out.println(size + "인치" + mf);
		this(32,"LG");
	}
	public TV(String mf) {
//		this.size = 32;
//		this.mf = mf;
//		System.out.println(size + "인치" + mf);
		this(32,mf);
	}
	public TV(int size, String mf) {
		this.size = size;
		this.mf = mf;
		System.out.println(size + "인치" + mf);
	}
}
public class TVAppNo6 {
	
	public static void main(String[] args) {
		// 
		new TV();
		new TV("삼성");
		new TV(65, "삼성");
		
	}

}
