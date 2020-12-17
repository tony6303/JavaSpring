package model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Object Relation Mapping , ���̹�����Ʈ ��� �̶��� �ִ�~~~
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseTime{
	private long id;
	private String imgUrl;
	private long userId; //DB�� Ÿ���� ��ġ��Ű�� ����
//	private Member member;  //�ڹٿ����� ������ �̸� ���ѳ��ƾ� �Ѵ� (?) �ȱ׷��� �Ľ��̾ȵ�
	private String content;
}
