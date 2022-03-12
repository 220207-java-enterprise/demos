package com.revature.boot.util;

import com.revature.boot.models.Address;
import com.revature.boot.models.Boot;
import com.revature.boot.models.Customer;
import com.revature.boot.repos.BootRepository;
import com.revature.boot.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Profile("local")
@Component
public class DummyDataInserter implements CommandLineRunner {

    private final CustomerRepository customerRepo;
    private final BootRepository bootRepo;

    @Autowired
    public DummyDataInserter(CustomerRepository customerRepo, BootRepository bootRepo) {
        this.customerRepo = customerRepo;
        this.bootRepo = bootRepo;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // Write persistence logic here for dummy data
        Customer customer1 = new Customer();
        customer1.setId(UUID.randomUUID().toString());
        customer1.setFirstName("Tester");
        customer1.setLastName("McTesterson");
        customer1.setEmail("tester@revature.com");
        customer1.setAddress(new Address("123", "Main Street", "Tampa", "Florida", "33647"));
        customer1.setShoeSize(10.5);

        Boot hikingBoots = new Boot();
        hikingBoots.setId(UUID.randomUUID().toString());
        hikingBoots.setBrand("Timberland");
        hikingBoots.setColor("brown");
        hikingBoots.setSize(10.5);
        hikingBoots.setPrice(79.99);
        hikingBoots.setWaterproof(true);
        hikingBoots.setMaterial("leather");
        hikingBoots.setOwner(customer1);

        Boot hikingBoots2 = new Boot();
        hikingBoots2.setId(UUID.randomUUID().toString());
        hikingBoots2.setBrand("Timberland");
        hikingBoots2.setColor("brown");
        hikingBoots2.setSize(7);
        hikingBoots2.setPrice(79.99);
        hikingBoots2.setWaterproof(true);
        hikingBoots2.setMaterial("leather");
        hikingBoots2.setOwner(customer1);

        customer1.addBootsToPurchasedList(hikingBoots, hikingBoots2);
        customerRepo.save(customer1); // the boots purchased by the customer are automatically persisted

    }

}
