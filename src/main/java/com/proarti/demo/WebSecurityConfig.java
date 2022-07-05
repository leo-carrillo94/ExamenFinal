package com.proarti.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.proarti.demo.servicios.UsuarioDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UsuarioDetailsServiceImpl userDetailSer;
	
	@Bean
	public BCryptPasswordEncoder encriptarContra() {
		return new BCryptPasswordEncoder();
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailSer).passwordEncoder(encriptarContra());
		
	}
	
	

	String[] resources = new String[] {
			"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"};
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(resources).permitAll()
		.antMatchers("/","/index","/registro").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.defaultSuccessUrl("/dashboard")
			.failureUrl("/login?error=true")
			.usernameParameter("email")
			.passwordParameter("clave")
			.and()
			.csrf().disable()
		.logout()
			.permitAll()
			.logoutSuccessUrl("/login?logout");
		
		
	}
	
	

}
