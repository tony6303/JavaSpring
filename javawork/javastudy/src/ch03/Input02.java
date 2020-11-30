package ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Input02 {

	public static void main(String[] args) {
		// 
		//I/O장치 중에 Input되는 장치의 선에 접근해서 1바이트 데이터를 읽어주는 클래스
		InputStream in = System.in; // 컴퓨터로 입력되는 선(키보드)
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(ir);
		
		try {
//			int num = in.read(); //아스키코드
//			System.out.println("입력받은값: "+num);
			
			String data = br.readLine();
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("괜찮아");
		}
	}

}
