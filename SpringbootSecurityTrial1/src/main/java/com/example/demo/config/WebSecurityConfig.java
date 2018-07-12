package com.example.demo.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {
	    JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
	    manager.setDataSource(dataSource);
	    return manager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		System.out.println("Returning PasswordEncoder");
		BCryptPasswordEncoder b =  new BCryptPasswordEncoder();
		System.out.println("Clear password = password");
		System.out.println("Encrt password = " + b.encode("password"));
		return b;
	}

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  System.out.println("Configure HttpSecurity");
    http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
    .and()
    .httpBasic(); // Authenticate users with HTTP basic authentication
  }
}