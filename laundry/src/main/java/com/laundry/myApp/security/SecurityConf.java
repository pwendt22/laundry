package com.laundry.myApp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConf extends WebSecurityConfigurerAdapter {
	
	//method to return the object ServiceUserDetail
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		UserDetailsService detalheDoUsuario = new UserDetailsService(usuarioRepository);
		return detalheDoUsuario;
	}

	
	@Override
	//roles for each user
	protected void configure(HttpSecurity http) throws Exception{
			http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/auth/user/*").hasAnyAuthority("USER","ADMIN","STAFF")
			.antMatchers("/auth/admin/*").hasAnyAuthority("ADMIN")
			.antMatchers("/auth/staff/*").hasAnyAuthority("STAFF")
			.antMatchers("/usuario/admin/*").hasAnyAuthority("ADMIN")
			.and()
			.exceptionHandling().accessDeniedPage("/auth/auth-acess-denied")
			.and()
			.formLogin().successHandler(loginSucess)
			.loginPage("/login").permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").permitAll();

		
	}

}
