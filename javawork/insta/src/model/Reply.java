package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply extends BaseTime{
	private long id;
	private String content;
	private long userId;
	private long imageId;
	
}
