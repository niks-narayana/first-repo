package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import javax.sql.DataSource;

@EnableWebSecurity(debug = true)
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
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
                //.and().formLogin()
                //.loginPage("/customLogin")
                //.defaultSuccessUrl("/loginSuccess", true)
                //.permitAll();
    }

}