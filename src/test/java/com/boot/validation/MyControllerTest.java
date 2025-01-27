package com.boot.validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidateRequest() throws Exception {
        String json = "{\"myEnum\":\"VALUE1\",\"statusEnum\":\"ACTIVE\",\"name\":\"John\",\"address\":{\"state\":\"NY\"},\"age\":25}";

        mockMvc.perform(post("/api/validate")
                        .contentType(MediaType.APPLICATION_JSON)  // Ensure content type is set
                        .content(json))  // Set the request body content
                .andExpect(status().isOk());  // Assert the status is OK (200)
    }
}
