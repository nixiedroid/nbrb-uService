package com.nixiedroid.nbrb.controllers;

import com.nixiedroid.nbrb.services.CurrencyService;
import com.nixiedroid.nbrb.services.ErrorMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(value = {ErrorController.class, CurrencyController.class})
class ErrorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService service;

    @SuppressWarnings("unused")
    @MockBean
    private ErrorMapper mapper;

    @InjectMocks
    @SuppressWarnings("unused")
    private CurrencyController controller;

    @Test
    void anyException() throws Exception {
        Mockito.when(service.getCurrency()).thenThrow(new RuntimeException("Test Exception"));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/currencies"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.content()
                        .string("Internal Error: java.lang.RuntimeException: Test Exception"));
    }

    @Test
    void notFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test-not-found"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}