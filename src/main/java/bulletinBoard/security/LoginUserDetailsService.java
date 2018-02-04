package bulletinBoard.security;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bulletinBoard.domain.Account;
import bulletinBoard.domain.AccountUserDetails;
import bulletinBoard.repository.AccountRepository;

/**
 * 資格情報とユーザーの状態をデータストアから取得するためのインターファイスUserDetailsServiceを利用
 * UserRepositoryを利用してデータベースからスタッフIDを利用してユーザー情報を取得しUserDetailsを利用している
 * LoginUserに返却
 * @author kazuanzo
 *
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository AccountRepository;

	@Transactional( readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 // 認証を行うユーザー情報を格納する
        Account account = Optional.ofNullable(AccountRepository.findByuserName(userName))
        		.orElseThrow(() -> new UsernameNotFoundException("found"));
        return new AccountUserDetails(account);
        
	}   
}

