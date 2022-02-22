package com.example.ciscocasemanagementsystem.cases;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CasesController.class)
class CasesControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getCases() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("printer failed",
                result.getResponse().getContentAsString());
    }
}