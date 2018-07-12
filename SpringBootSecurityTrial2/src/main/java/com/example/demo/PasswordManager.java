package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordManager {

	public static void main(String[] args) {
		System.out.println("PasswordEncoder");
		String pwd = "password";
		BCryptPasswordEncoder b =  new BCryptPasswordEncoder();
    	System.out.println("Clear password = '" + pwd + "'");
    	String encodedPassword = b.encode(pwd);
    	System.out.println("Encrt password = " + encodedPassword);
    	
    	
    	System.out.println("Match = " + b.matches("password", encodedPassword));
    	
	}

}
