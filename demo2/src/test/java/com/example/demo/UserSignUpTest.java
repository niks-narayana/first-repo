package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;

//import com.sling.example.UserPackages.controller.SlingController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
public class UserSignUpTest {
	@Autowired
    private WebApplicationContext wac;
	
	//@InjectMocks
	//private SlingController slingController;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        System.out.println("Going to SETUP");
    	//this.mockMvc = MockMvcBuilders.standaloneSetup(this.slingController).build();
    	DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }

    @Test
    public void testGetAccount() throws Exception {
        System.out.println("Going to run get test");
        
        mockMvc.perform(get("/")).andExpect(status().isOk());
        
        System.out.println("End of run get test");
    }
    
    @Test
    public void postAccount() throws Exception {
        System.out.println("Going to run post test");
        
        mockMvc.perform(post("/signup")).andExpect(status().isOk());
        
        System.out.println("End of run post test");
    }
    
    @Test
    public void newTest() throws Exception {
        System.out.println("Going to run new test");

        ResultMatcher ok = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
        this.mockMvc.perform(builder)
        .andExpect(ok);
        
        System.out.println("End of run new test");
    }
    
    @Test
    public void signUpTest() throws Exception {
        System.out.println("Going to run signup test");
        String postRequestBody = "{\n" + 
        		"	\"email\": \"exampleqwininx.io\",\n" + 
        		"	\"password\": \"Qwinix12\",\n" + 
        		"	\"phoneNumber\": \"9876543210\",\n" + 
        		"	\"name\": \"John Dee\",\n" + 
        		"	\"annualIncome\": \"100000\",\n" + 
        		"	\"dateOfBirth\": \"01/01/2000\"\n" + 
        		"}\n" + 
        		"";
        
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/signup").contentType(MediaType.APPLICATION_JSON_VALUE).content(postRequestBody);
        
        this.mockMvc.perform(builder).andExpect(ok).andDo(MockMvcResultHandlers.print())
        .andExpect(jsonPath("$.success", is("false")));
        System.out.println("End of run signup test");
    }
        

}