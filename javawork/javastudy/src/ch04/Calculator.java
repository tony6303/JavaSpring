package ch04;

public class Calculator {
	//숫자 10,5를 더해서
		//그 결과값과 숫자20을 곱해서
		//그 결과값을 숫자5로 나누고
		//그 결과값에 100을 뺀 값을 화면에 출력하시오.
		int add(int n1,int n2) {
			int result = n1 + n2;
			return result;
		}
		
		int minus(int n1,int n2) {
			int result = n1 - n2;
			return result;
		}
		
		int divid(int n1,int n2) {
			int result = n1 / n2;
			return result;
		}
		
		int multi(int n1,int n2) {
			int result = n1 * n2;
			return result;
		}
}
