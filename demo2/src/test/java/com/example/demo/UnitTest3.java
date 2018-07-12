package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.controller.HelloController;

@RunWith(JUnitPlatform.class)
@SpringBootTest
public class UnitTest3 {
	@Autowired
    private WebApplicationContext wac;
	
	@InjectMocks
	private HelloController helloController;

    private MockMvc mockMvc;
    
    @BeforeAll
    static void setupAll(){
        System.out.println("@BeforeAll executed");
    }
    
    @BeforeEach
    void doBeforeEach() {
    	System.out.println("Do beforeEach");
    }
    
    //@BeforeEach
    void setup() {
        System.out.println("Going to SETUP");
    	this.mockMvc = MockMvcBuilders.standaloneSetup(this.helloController).build();
    	DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    @Disabled
    @Test
    public void testGetAccount() throws Exception {
        System.out.println("Going to run get test");
        
        mockMvc.perform(get("/")).andExpect(status().isOk())
        						 .andExpect(content().string("hello"));
        
        System.out.println("End of run get test");
    }
}
