package org.generation.blogPessoal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BaseSecurityConfig extends WebSecurityConfigurerAdapter {
	
		@Autowired
	private UserDetailsService userDetailsService;
	
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/usuarios/logar").permitAll()
		.antMatchers("/usuarios/cadastrar").permitAll()
		.anyRequest() .authenticated()
		.and() .httpBasic()
		.and() .sessionManagement() .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and() .cors()
		.and() .csrf() .disable();
	}
}
