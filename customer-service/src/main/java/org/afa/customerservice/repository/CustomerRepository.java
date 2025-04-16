package org.afa.customerservice.repository;

import org.afa.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
