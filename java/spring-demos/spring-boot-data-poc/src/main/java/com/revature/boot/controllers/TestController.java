package com.revature.boot.controllers;

import com.revature.boot.dtos.ResourceCreationResponse;
import com.revature.boot.models.Customer;
import com.revature.boot.repos.CustomerRepository;
import com.revature.boot.util.security.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/test")
public class TestController {

    private CustomerRepository customerRepo;

    @Autowired
    public TestController(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Secured(allowedUsers = {"wsingleton, aanderson"})
    @GetMapping
    public String test() {
        return "{\"endpoint\": \"/test\", \"status\": UP}";
    }

    // Using RequestMapping instead of the newer Get/Post/Put/Patch/DeleteMapping
    @RequestMapping(method = RequestMethod.GET, value = "test2")
    public String test2() {
        return "{\"endpoint\": \"/test2\", \"status\": UP}";
    }

    // Grabbing request param values
    @GetMapping(value = "test3", produces = "application/json")
    public HashMap<String, Object> test3(@RequestParam String username, @RequestParam("email") String someEmail) {
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("endpoint", "/test3");
        responseMap.put("status", "UP");
        responseMap.put("providedValues", Arrays.asList(username, someEmail));
        return responseMap;
    }

    // Grabbing request header values
    @GetMapping(value = "test4", produces = "application/json")
    public HashMap<String, Object> test4(@RequestHeader("Authorization") String token) {
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("endpoint", "/test4");
        responseMap.put("status", "UP");
        responseMap.put("providedToken", token);
        return responseMap;
    }

    // Grabbing path parameter values
    @GetMapping(value = "/test5/{something}/{another}", produces = "application/json")
    public HashMap<String, Object> test5(@PathVariable String something, @PathVariable String another) {
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("endpoint", "/test5");
        responseMap.put("status", "UP");
        responseMap.put("providedPathVariables", Arrays.asList(something, another));
        return responseMap;
    }

    // Grabbing request body data
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/test6", produces = "application/json", consumes = "application/json")
    public ResourceCreationResponse test6(@RequestBody Customer customerData) {
        customerData.setId(UUID.randomUUID().toString());
        customerData.setJoinedDatetime(LocalDateTime.now());
        customerRepo.save(customerData);
        return new ResourceCreationResponse(customerData.getId());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/do-thing")
    public void doThing() {
        System.out.println("We did the thing!");
    }

    // Grabbing request header values using a provided HttpServletRequest
    @GetMapping(value = "test7", produces = "application/json")
    public HashMap<String, Object> test7(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("endpoint", "/test7");
        responseMap.put("status", "UP");
        responseMap.put("providedToken", token);
        return responseMap;
    }

    // Using an injected HttpServletResponse to modify response headers/status code
    @PostMapping(value = "test8", produces = "application/json", consumes = "application/json")
    public void test8(@RequestBody HashMap<String, Object> credentials, HttpServletResponse resp) {
        if (credentials.get("username").equals("wsingleton") && credentials.get("password").equals("p4$$W0RD")) {
            resp.setHeader("Authorization", "some-token-value-here");
        } else {
            resp.setStatus(401);
        }
    }

    // Using a ResponseEntity as a return to modify response values
    @GetMapping(value = "test9", produces = "application/json")
    public ResponseEntity<HashMap<String, Object>> test9() {
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("endpoint", "/test9");
        responseMap.put("status", "UP");
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

}
