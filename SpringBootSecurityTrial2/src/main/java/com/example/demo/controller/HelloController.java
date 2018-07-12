package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public ResponseEntity<?> getHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("name", "value");

		return new ResponseEntity<>(headers, HttpStatus.OK);
		
	}
	
	@GetMapping("/hello")
	public String getString() {		
		return "hello";
	}
	
	@GetMapping("/error")
	public ResponseEntity<?> getError() {
		
		ResponseEntity<?> re = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		return re;
		
		//return "hello";
	}
}
