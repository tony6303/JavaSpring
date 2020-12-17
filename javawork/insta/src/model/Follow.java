package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Follow extends BaseTime {
	private long id;
	private long fromUserId; //fk
	private long toUserId;  //fk
}
