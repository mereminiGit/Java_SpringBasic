package com.yedam.app;


import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yedam.app.customer.Customer;
import com.yedam.app.customer.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Sp03JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp03JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			Optional<Customer> customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			/*
			 * log.info("Customer found with findByLastName('Bauer'):");
			 * log.info("--------------------------------------------");
			 * repository.findByLastName("Bauer").forEach(bauer -> {
			 * log.info(bauer.toString()); });
			 */
			log.info("");
		};
	}

}
