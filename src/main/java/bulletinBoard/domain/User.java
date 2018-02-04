package bulletinBoard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="password")
	private String password;
	@Column(name="user_name")
	private String userName;
	@Column(name="old")
	private  int old;
	
	
}
