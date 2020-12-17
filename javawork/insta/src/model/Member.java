package model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseTime{
	private long id; //8Bytes
	private String username;
	private String password;
	private String userImg;
	private String email;
	
	//builder pattern  자료형이 Member인 함수
//	public static Member builder() {
//		return new Member();
//	}
//	
//	public Member id(long id) {
//		this.id=id;
//		return this;
//		//자기 자신을 리턴하기때문에 set 과 get  이 동시에 ? 되는거같음
//	}
//	
//	public Member username(String username) {
//		this.username=username;
//		return this;
//	}
//	
//	public Member password(String password) {
//		this.password=password;
//		return this;
//	}
//	
//	public Member userImg(String userImg) {
//		this.userImg=userImg;
//		return this;
//	}
//	
//	public Member email(String email) {
//		this.email=email;
//		return this;
//	}
//	
//	public Member createDate(Timestamp createDate) {
//		this.createDate=createDate;
//		return this;
//	}
//	
//	public Member updateDate(Timestamp updateDate) {
//		this.updateDate=updateDate;
//		return this;
//	}
	
}
