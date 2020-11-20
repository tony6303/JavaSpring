package sms;

import lombok.Data;

@Data
public class Response {
	String group_id;
	String error_list;
	String success_count;
	String error_count;

	static String startEndTrim(String str) {
		return str.substring(str.indexOf("{")+1,str.lastIndexOf("}"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "{\"group_id\":\"R2GtX62GMhUpnaem\",\"error_list\":{\"1\":\"1062\"},\"success_count\":0,\"error_count\":1}\r\n"
				+ "";
		System.out.println(data);
		System.out.println("----------------------------------");
		data = data.replaceAll("\"", "");
		data = startEndTrim(data);

		Response res = new Response();
		System.out.println(data);
		System.out.println();

		String s1[] = data.split(",");
		String s2[] = null;
		for (int i = 0; i < 4; i++) {
//			if(s1[i].contains("{")||s1[i].contains("}")) {
//				s1[i] = s1[i].replace("{", "");
//				s1[i] = s1[i].replace("}", "");
//				System.out.println("s1[" + i + "] " + s1[i]);
//			}else
				System.out.println("s1[" + i + "] " + s1[i]);			
		}
		System.out.println();
		for (int i = 0; i < s1.length; i++) {
			if(s1[i].contains("{")||s1[i].contains("}")) {
				s1[i] = s1[i].replace("{", "");
				s1[i] = s1[i].replace("}", "");
			}
			s2 = s1[i].split(":");
			for (int j = 0; j < s2.length; j++) {
				System.out.println("s2" + "[" + j + "] " + s2[j]);
			}
		}
		

		System.out.println(res);
	}

}
