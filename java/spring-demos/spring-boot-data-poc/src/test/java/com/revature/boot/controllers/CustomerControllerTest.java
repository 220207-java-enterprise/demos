package com.revature.boot.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.boot.dtos.NewCustomerRequest;
import com.revature.boot.models.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CustomerControllerTest {

    private MockMvc mockMvc;
    private final WebApplicationContext context;
    private final ObjectMapper mapper;

    @Autowired
    public CustomerControllerTest(WebApplicationContext context, ObjectMapper mapper) {
        this.context = context;
        this.mapper = mapper;
    }

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test_register_returns201_givenValidNewRegistrationRequest() throws Exception {

        // Arrange
        NewCustomerRequest request = new NewCustomerRequest();
        request.setFirstName("Shaq");
        request.setLastName("O'Neal");
        request.setEmail("soneal@revature.com");
        request.setShoeSize(23.0);
        Address shaqsAddress = new Address("123", "Main Street", "Tampa", "Florida", "33647");
        request.setAddress(shaqsAddress);

        String requestPayload = mapper.writeValueAsString(request);

        // Act and Assert
        MvcResult result = mockMvc.perform(post("/customers").contentType("application/json").content(requestPayload))
                                  .andDo(print())
                                  .andExpect(status().is(201))
                                  .andExpect(jsonPath("$.id").isNotEmpty())
                                  .andReturn();

        assertEquals("application/json", result.getResponse().getContentType());


    }

    @Test
    public void test_register_returns400_givenInvalidNewRegistrationRequest() throws Exception {

        // Arrange
        NewCustomerRequest request = new NewCustomerRequest();
        request.setFirstName("Shaq");
        request.setLastName("O'Neal");
        request.setEmail("soneal@revature.com");
        request.setShoeSize(25.0);
        Address shaqsAddress = new Address("123", "Main Street", "Tampa", "Florida", "33647");
        request.setAddress(shaqsAddress);

        String requestPayload = mapper.writeValueAsString(request);

        // Act and Assert
        MvcResult result = mockMvc.perform(post("/customers").contentType("application/json").content(requestPayload))
                                  .andDo(print())
                                  .andExpect(status().is(400))
                                  .andReturn();



    }

}
