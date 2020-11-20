package sms;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class ExampleSend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 	문자전송("01066527321","테스트" );
		 	
		  }
	static public void 문자전송(String to, String text) {
		String api_key = "NCSEQORAP97QIYL3";
	    String api_secret = "GUMISLPC7BWNAWKZUSOQ1UQAIO1D3AIQ";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", to);
	    params.put("from", "010665"); //무조건 자기번호 (인증)
	    params.put("type", "SMS");
	    params.put("text", text);
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	    	//send() 는 메시지를 보내는 함수  
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	      // 파싱시작 부분
	      // obj(문자열) > 오브젝트
	      // error가 있는지 확인
	      // DB insert
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
		
	}
}

