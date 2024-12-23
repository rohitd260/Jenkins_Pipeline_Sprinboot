package com.example.jenkinsdemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.jenkinsdemo.controllers.HelloController;

@SpringBootTest
class HelloControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private HelloController helloController;

    @Test
    void testSayHello() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();

        mockMvc.perform(get("/hello").param("name", "World"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }
}
