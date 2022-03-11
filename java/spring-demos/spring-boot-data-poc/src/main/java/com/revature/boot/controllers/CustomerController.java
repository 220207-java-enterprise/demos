package com.revature.boot.controllers;

import com.revature.boot.dtos.NewCustomerRequest;
import com.revature.boot.dtos.ResourceCreationResponse;
import com.revature.boot.services.CustomerService;
import com.revature.boot.util.InvalidRequestException;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestController // TODO associates should look into the difference between @RestController and @Controller
@RequestMapping("/customers")
public class CustomerController {

//    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResourceCreationResponse registerCustomer(@RequestBody NewCustomerRequest request) {
//        logger.info("CustomerController#registerCustomer invoked at {} with args: {}", LocalDateTime.now(), request);
        ResourceCreationResponse response = customerService.registerNewCustomer(request);
//        logger.info("CustomerController#registerCustomer successfully returned at {} with value: {}", LocalDateTime.now(), response);
        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, Object> handleInvalidRequests(InvalidRequestException e) {
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", 400);
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now());
        return responseBody;
    }

}
