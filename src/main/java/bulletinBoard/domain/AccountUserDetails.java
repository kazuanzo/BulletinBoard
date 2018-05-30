package bulletinBoard.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
//取得したユーザーを保持するクラス
public class AccountUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Account account;
	
//	public AccountUserDetails(
//			Account user, Collection<GrantedAuthority> authorities){
//		this.account=user;
//		this.authorities=authorities;
//	}
	public AccountUserDetails(Account account){
		this.account=account;
	}
	public Account getAccount(){
		return account;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return AuthorityUtils.createAuthorityList("ROLE_" +this.account.getRoleName());
	}
	
	
	public  int getId(){
	return account.getId();	
	}
	

	@Override
	public String getPassword(){
	return account.getPassword();	
	}
	@Override
	public String getUsername(){
		return account.getUserName();
	}
	@Override
	public boolean isEnabled(){
		return true;
	}

	@Override
	public boolean isAccountNonLocked(){
		return true;
	}
	@Override
	public boolean isAccountNonExpired(){
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
}
	
	
	
	
	


