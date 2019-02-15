package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductTests {


    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testBasicGet() throws Exception {
        mockMvc.perform(
        	get("/products/AAA"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code").value("AAA"))
        ;
    }

    @Test
    public void testPost() throws Exception {

        mockMvc.perform(get("/products/JJJ"))
            .andExpect(status().isNotFound());
    	
    	mockMvc.perform(
        	post("/products/") 
        	.content("{\"code\":\"JJJ\",\"price\":99.00,\"weight\":99.00}")
        	.contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isCreated())
        ;

        mockMvc.perform(get("/products/JJJ"))
        .andExpect(status().isOk());

        mockMvc.perform(delete("/products/JJJ"))
        .andExpect(status().isNoContent());

        mockMvc.perform(get("/products/JJJ"))
        .andExpect(status().isNotFound());
        
    }

    @Test
    public void testPut() throws Exception {
        mockMvc.perform(
        	put("/products/HHH") 
        	.content("{\"code\":\"HHH\",\"price\":999.00,\"weight\":999.00}")
        	.contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent())
        ;
    }

	
}
