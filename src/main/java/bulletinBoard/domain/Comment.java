package bulletinBoard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="comment")
public class Comment {
	@Id
	@GeneratedValue
	int id;
	@Column(name="account_id")
	int accountId;
	@Column(name="board_id")
	int boardId;
	@NotBlank
	@Column(name="comment")
	String commentD;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="account_id", referencedColumnName="id" ,insertable = false, updatable = false)
	Account account;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(insertable = false, updatable = false)
	Board board;

	
}
