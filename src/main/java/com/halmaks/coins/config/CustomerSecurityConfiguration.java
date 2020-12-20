package com.halmaks.coins.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class CustomerSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/api/v1/authenticated/**").authenticated()
				.and()
				.httpBasic()
				.and()
				.logout().logoutSuccessUrl("/");

	}

	@Bean
	public JdbcUserDetailsManager users(DataSource dataSource) {
		UserDetails user = User.builder()
			.username("user")
			.password("{user0909pass!!ddd___--$$")
			.roles("USER")
			.build();
		UserDetails admin = User.builder()
			.username("admin")
			.password("dffiidkjrekrererererefe")
			.roles("ADMIN", "USER")
			.build();
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		if(jdbcUserDetailsManager.userExists(user.getUsername())) {
			jdbcUserDetailsManager.deleteUser(user.getUsername());
		}
		if(jdbcUserDetailsManager.userExists(admin.getUsername())) {
			jdbcUserDetailsManager.deleteUser(admin.getUsername());
		}
		jdbcUserDetailsManager.createUser(user);
		jdbcUserDetailsManager.createUser(admin);
		return jdbcUserDetailsManager;
	
	}
}
			

