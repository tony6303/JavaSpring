package protocol;

import lombok.Data;

@Data
public class RequestDto {
	//�����Ͱ� �� �� �ʿ����� �� ��?
	//"�ϴ�" String �� �������� , �׸��� ������ �� ������ ���׸����� �����丵(�缳��)
	private String gubun;
	private String id;
	private String msg;
}
