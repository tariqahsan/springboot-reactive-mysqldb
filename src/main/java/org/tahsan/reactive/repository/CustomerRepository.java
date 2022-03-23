package org.tahsan.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.tahsan.reactive.entity.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
}
