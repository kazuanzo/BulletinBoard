package bulletinBoard.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
	int id;
	int userId;
	int boardId;
	String comment;


}
