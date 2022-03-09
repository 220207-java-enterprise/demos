package com.revature.boot.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "shoe_size", nullable = false)
    private double shoeSize;

    @Column(name = "joined_datetime", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime joinedDatetime;

    @Embedded
    private Address address;

    @OneToMany(
        mappedBy = "owner",
        fetch = FetchType.EAGER,
        cascade = CascadeType.PERSIST // when a customer is saved, save all boots in this list (if any exist)
    )
    private List<Boot> bootsPurchased;

    public Customer() {
        bootsPurchased = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public LocalDateTime getJoinedDatetime() {
        return joinedDatetime;
    }

    public void setJoinedDatetime(LocalDateTime joinedDatetime) {
        this.joinedDatetime = joinedDatetime;
    }

    public List<Boot> getBootsPurchased() {
        return bootsPurchased;
    }

    public void setBootsPurchased(List<Boot> bootsPurchased) {
        this.bootsPurchased = bootsPurchased;
    }

    public void addBootsToPurchasedList(Boot... boots) {
        bootsPurchased.addAll(Arrays.asList(boots));
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", shoeSize=" + shoeSize +
                ", address=" + address +
                ", joinedDatetime=" + joinedDatetime +
                '}';
    }

}
