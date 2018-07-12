package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
public class UnitTest {
	@Autowired
    private WebApplicationContext wac;
	
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        System.out.println("Going to SETUP");
    	DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    //@Disabled
    @Test
    public void test1() throws Exception {
        System.out.println("Going to run test1");
        
        mockMvc.perform(get("/")).andExpect(status().isOk())
        						 .andExpect(content().string("hello"))
        						 .andExpect(header().string("name", "value"));
        
        System.out.println("End of run get test");
    }
    
    @Test
    public void test2() throws Exception {
        System.out.println("Going to run test2");
        
        ResultActions ra = mockMvc.perform(get("/error")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
        ra.andDo(MockMvcResultHandlers.print());
        
        System.out.println("End of run get test");
    }
}
