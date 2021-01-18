package com.ticketing.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ticketing.modeles.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
