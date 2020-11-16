package ch04;

public class CalculatorApp {
	//숫자 10,5를 더해서
	//그 결과값과 숫자20을 곱해서
	//그 결과값을 숫자5로 나누고
	//그 결과값에 100을 뺀 값을 화면에 출력하시오.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		System.out.println(c.minus(c.divid(c.multi(20, c.add(5, 10)), 5), 100));
		
		
		Calculator cal = new Calculator();
		int sum =cal.add(10, 5);
		int mult = cal.multi(sum, 20);
		int div =cal.divid(mult,5);
		int minus = cal.minus(div, 100);
		
		int result =minus;
		System.out.println(result);
	}

}
