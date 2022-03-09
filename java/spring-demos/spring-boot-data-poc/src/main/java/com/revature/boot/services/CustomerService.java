package com.revature.boot.services;

import com.revature.boot.dtos.NewCustomerRequest;
import com.revature.boot.dtos.ResourceCreationResponse;
import com.revature.boot.models.Customer;
import com.revature.boot.repos.CustomerRepository;
import com.revature.boot.util.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepo;

    @Autowired
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public ResourceCreationResponse registerNewCustomer(NewCustomerRequest newCustomerRequest) {

        Customer newCustomer = newCustomerRequest.extractCustomerData();

        if (newCustomer.getShoeSize() <= 0 || newCustomer.getShoeSize() > 23) {
            throw new InvalidRequestException("Shoe sizes must be between 1 and 23!");
        }

        customerRepo.save(newCustomer);

        return new ResourceCreationResponse(newCustomer.getId());

    }

}
