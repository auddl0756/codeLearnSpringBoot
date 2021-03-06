package com.example.demo.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SampleController.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    //private static String url="http://localhost:8080/";

    @Test
    public void helloTest() throws Exception{
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk());

    }
}