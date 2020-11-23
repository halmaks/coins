package com.halmaks.coins.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// https://dzone.com/articles/spring-boot-oauth2-getting-the-authorization-code
@Configuration
@EnableWebSecurity
public class CustomerSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/api/v1/product/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/api/v1/customer/**")
			.hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
			.permitAll().and().logout().permitAll();

		http.csrf().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
	    authenticationMgr.inMemoryAuthentication().withUser("admin").password("admin")
		    .authorities("ROLE_ADMIN");
	}
}
			

