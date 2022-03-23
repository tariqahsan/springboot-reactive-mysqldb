package org.tahsan.reactive.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.tahsan.reactive.entity.Customer;
import org.tahsan.reactive.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CustomerController {
	
//    private final CustomerRepository customerRepository = null;
	@Autowired
	private CustomerRepository customerRepository;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/")
    public Flux<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomer(@PathVariable("id") Long id) {
        return customerRepository.findById(id);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Customer> updateCustomer(@RequestBody Customer customer) {
        return this.customerRepository
                .findById(customer.getId())
                .map(c->customer)
                .flatMap(this.customerRepository::save);
    }

    @DeleteMapping("/{id}")
    public Mono<Customer> delete(@PathVariable("id") Long id) {
        return this.customerRepository
                .findById(id)
                .flatMap(customer -> this.customerRepository.deleteById(customer.getId()).thenReturn(customer));
    }
}
