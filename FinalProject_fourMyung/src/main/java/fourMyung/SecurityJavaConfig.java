package fourMyung;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig  extends WebSecurityConfigurerAdapter{
	// pox.xml 설정에 의해서 프로젝트 실행시 login 페이지가 실행되는걸 막기 위한 class
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.cors().disable() // cors 방지
			.csrf().disable() // csrf 방지
			.formLogin().disable()
			.headers().frameOptions().disable();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
