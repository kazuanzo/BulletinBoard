package bulletinBoard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//WebSecurityConfigurerAdapterを親クラスにすることによりデフォルトで適用されるBean定義を簡単にカスタマイズできる。
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	//ここでUserDetailsServiceを利用して認証処理を行う
	@Autowired
	private LoginUserDetailsService UserDetailsService;

	@Bean //パスワードの暗号化方式を宣言（平文でDBにパスワードを保存しないこと！）
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}

	@Override
	public void configure(WebSecurity web)throws Exception{
		web.ignoring().antMatchers(// TODO セキュリティ対策が不要なリソースを設定
				"/images/**", "/css/**", "/javascript/**", "/webjars/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//ログイン画面と新規登録画面は許可
		http.authorizeRequests()
		.antMatchers("/loginForm","/registrationForm","/registration").permitAll()
		// それ以外は全て認証無しの場合アクセス不許可
        .anyRequest().authenticated(); 
		
		
		// login setting
		http.csrf().disable().formLogin()
		//ログインの処理をするURL
		.loginProcessingUrl("/login")
		//ログイン画面のURL
		.loginPage("/loginForm")
		//ログインが成功した時のURL※true : ログイン画面した後必ずtopにとばされる
		.defaultSuccessUrl("/top", true)
		//ログインに失敗した時のURL
		.failureUrl("/loginForm?error=failed")
		//ログイン画面のhtmlのinputのname属性を見に行っている
		.usernameParameter("userName")
		//ログイン画面のhtmlのinputのname属性を見に行っている
		.passwordParameter("password")
		//ログアウトのURL
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("signout"))
		//ログアウト成功したあとのURL
		.logoutSuccessUrl("/login")
		//ログアウトしたら cookieの　JSESSIONID を削除
		.deleteCookies("JSESSIONID")
		//ログアウトしたらセッションを無効にする
		.invalidateHttpSession(true)
		.permitAll();



	}


	//AuthenticationManagerのBean定義を行うメソッドを作成
	//パスワードを平文で保存しているのでpasswordEncoder()を使用していない。
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(UserDetailsService);
//		.passwordEncoder(passwordEncoder()); // hashed password

	}
}

