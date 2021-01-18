package com.ticketing.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticketing.modeles.Customer;
import com.ticketing.repositories.CustomerRepository;
import com.ticketing.services.CustomerService;

@Controller
@RequestMapping(path = "customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
		@GetMapping
		public String getAll(Model model) {
		        model.addAttribute("customers", customerService.getAllcustomers());
		        return "all-customers";
		  
		}
	   @GetMapping("/addcustomer")
	    public String showSignUpForm(Customer customer) {
	        return "add-customer";
	    }

	    @PostMapping("/addcustomer")
	    public String addUser(@Valid Customer customer, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-customer";
	        }
	        customerService.addcustomer(customer);
	        return "redirect:/customers";
	    }
	    @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") int id, Model model) {
	        Optional<Customer> customer = customerService.getCustomer(id);
	        model.addAttribute("customer", customer.get());
	    
	        return "update-customer";
	    }
	    @PostMapping("/edit/{id}")
	    public String updateUser(@PathVariable("id") int id, @Valid Customer customer,
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            customer.setCustId(id);
	            return "update-customer";
	        }
	        customerService.updatecustomer(id, customer);
	        return "redirect:/customers";
	    }
	    @GetMapping("/delete/{id}")
	    public String deleteUser(@PathVariable("id") int id, Model model) {
	       customerService.deletecustomer(id);
	       return "redirect:/customers";
	    }
}
