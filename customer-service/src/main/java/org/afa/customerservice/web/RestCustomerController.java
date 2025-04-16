package org.afa.customerservice.web;

import org.afa.customerservice.entities.Customer;
import org.afa.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestCustomerController {
	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/customers")
	List<Customer> findAll() {
		return customerRepository.findAll();
	}
	@GetMapping("/customers/{id}")
	Customer findCustomerById(@PathVariable Long id) {
		return customerRepository.findById(id).orElse(null);
	}
}
