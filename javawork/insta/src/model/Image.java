package model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Object Relation Mapping , 하이버네이트 기술 이란게 있다~~~
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseTime{
	private long id;
	private String imgUrl;
	private long userId; //DB와 타입을 일치시키기 위해
//	private Member member;  //자바에서는 조인을 미리 시켜놓아야 한다 (?) 안그러면 파싱이안됨
	private String content;
}
