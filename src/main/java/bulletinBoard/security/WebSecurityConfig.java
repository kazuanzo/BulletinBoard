package bulletinBoard.security;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(WebSecurity web){
		web.ignoring().antMatchers(// TODO セキュリティ対策が不要なリソースを設定
				 "/images/**", "/css/**", "/javascript/**", "/webjars/**");
	}

}
