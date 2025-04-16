package org.afa.borrowingservice.feign;

import org.afa.borrowingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
	@GetMapping("/customers/{id}")
	Customer getCustomerById(@PathVariable long id);

	@GetMapping("/customers")
	List<Customer> getAllCustomer();
}
