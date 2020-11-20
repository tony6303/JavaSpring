package ch04;

//다형성
class Job{}
class Police extends Job{
	String name ="경찰";
}
class Doctor extends Job{
	String name = "의사";
}
public class Array02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job[] job = new Job[2];
		job[0] = new Police();
		job[1] = new Doctor();
		
		System.out.println();
	}

}
