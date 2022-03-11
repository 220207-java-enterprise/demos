package com.revature.boot.services;

import com.revature.boot.dtos.NewCustomerRequest;
import com.revature.boot.dtos.ResourceCreationResponse;
import com.revature.boot.models.Customer;
import com.revature.boot.repos.CustomerRepository;
import com.revature.boot.util.InvalidRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {

//    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private CustomerRepository customerRepo;

    @Autowired
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public ResourceCreationResponse registerNewCustomer(NewCustomerRequest newCustomerRequest) {
//        logger.info("CustomerService#registerNewCustomer invoked at {} with args: {}", LocalDateTime.now(), newCustomerRequest);

        Customer newCustomer = newCustomerRequest.extractCustomerData();

        if (newCustomer.getShoeSize() <= 0 || newCustomer.getShoeSize() > 23) {
//            logger.warn("CustomerService#registerNewUser threw a InvalidRequestException at {}", LocalDateTime.now());
            throw new InvalidRequestException("Shoe sizes must be between 1 and 23!");
        }

        customerRepo.save(newCustomer);

        ResourceCreationResponse response = new ResourceCreationResponse(newCustomer.getId());
//        logger.info("CustomerService#registerNewCustomer successfully returned at {} with value: {}", LocalDateTime.now(), response);
        return response;

    }

}
