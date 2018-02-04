package bulletinBoard.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="account")
public class Account implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Column(name="user_name")
    private String userName;
	@Column(name="password")
    private String password;
	@Column(name="first_name")
    private String firstName;
	@Column(name="last_name")
    private String lastName;
	@Column(name="role_name")
	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public RoleName getRoleName() {
		return roleName;
	}
	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
 
}