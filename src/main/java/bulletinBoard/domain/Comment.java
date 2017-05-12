package bulletinBoard.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
	int id;
	String userName;
	int boardId;
	String comment;


}
