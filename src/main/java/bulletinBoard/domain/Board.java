package bulletinBoard.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="board")
//クエリ名はクラスに依存する。
@NamedQuery(name = "boardSerch", query = "from Board  where boardTypeId = :boardType and  (boardName like :keyword or boardContent like :keyword)")
public class Board {
	@Id
	@GeneratedValue
	int id;
	int boardTypeId;
	String boardName;
	String boardContent;
	int createAccountId;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="board_id", referencedColumnName="id")
	@OrderBy("id ASC")
	List<Comment> commentList;

}
