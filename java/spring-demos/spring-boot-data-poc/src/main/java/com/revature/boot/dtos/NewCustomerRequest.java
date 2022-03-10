package com.revature.boot.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.boot.models.Address;
import com.revature.boot.models.Customer;

import java.time.LocalDateTime;
import java.util.UUID;

public class NewCustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private double shoeSize;
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(double shoeSize) {
        this.shoeSize = shoeSize;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer extractCustomerData() {
        Customer customerData = new Customer();
        customerData.setId(UUID.randomUUID().toString());
        customerData.setFirstName(firstName);
        customerData.setLastName(lastName);
        customerData.setEmail(email);
        customerData.setShoeSize(shoeSize);
        customerData.setAddress(address);
        customerData.setJoinedDatetime(LocalDateTime.now());
        return customerData;
    }

    @Override
    public String toString() {
        return "NewCustomerRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", shoeSize=" + shoeSize +
                ", address=" + address +
                '}';
    }

}
