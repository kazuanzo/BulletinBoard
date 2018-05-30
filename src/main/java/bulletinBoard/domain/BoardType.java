package bulletinBoard.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="board_type")
public class BoardType {
	@Id
	int id;
	String boardType;

}
