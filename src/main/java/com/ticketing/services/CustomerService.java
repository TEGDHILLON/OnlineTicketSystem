package com.ticketing.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketing.modeles.Customer;
import com.ticketing.repositories.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	public List<Customer> getAllcustomers(){
		List<Customer> customers=new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
//		customerRepository.findAll().forEach(m->customers.add();
		return customers;
	}
	public Optional<Customer> getCustomer(int id) {
		Optional<Customer> c=customerRepository.findById(id);
		return c;
	}
	 public void addcustomer(Customer customer) {
		 customerRepository.save(customer);
	 }
	 public void updatecustomer(int id, Customer customer) {
		 customer.setCustId(id);
		 customerRepository.save(customer);
		}
		
	 public void deletecustomer(Integer id) {
			customerRepository.deleteById(id);
			
		}
}
