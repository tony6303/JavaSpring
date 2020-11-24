package ch09;

public enum SMSCode {
	SUCCESS(200, "성공"), FAIL(400, "실패");
	
	int value;
	String msg;
	
	private SMSCode(int value, String msg) {
		this.value = value;
		this.msg = msg;
	}
	
}
