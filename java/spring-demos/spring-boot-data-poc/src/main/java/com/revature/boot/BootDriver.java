package com.revature.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // implies both @Configuration and @ComponentScan
public class BootDriver {

    public static void main(String[] args) {
        SpringApplication.run(BootDriver.class);
    }

}
