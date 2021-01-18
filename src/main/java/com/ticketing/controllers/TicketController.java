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

import com.ticketing.modeles.Ticket;
import com.ticketing.services.TicketService;

@Controller
@RequestMapping(path = "tickets")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
		@GetMapping
		public String getAll(Model model) {
		        model.addAttribute("tickets", ticketService.getAlltickets());
		        return "all-tickets";
		  
		}
	   @GetMapping("/addticket")
	    public String showSignUpForm(Ticket ticket) {
	        return "add-ticket";
	    }

	    @PostMapping("/addticket")
	    public String addUser(@Valid Ticket ticket, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	System.out.println(""+result.getFieldError());
	            return "add-ticket";
	        }
	        ticketService.addticket(ticket);
	        return "redirect:/tickets";
	    }
	    @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") int id, Model model) {
	        Optional<Ticket> ticket = ticketService.getTicket(id);
	        model.addAttribute("ticket", ticket.get());
	    
	        return "update-ticket";
	    }
	    @PostMapping("/edit/{id}")
	    public String updateUser(@PathVariable("id") int id, @Valid Ticket ticket,
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            ticket.setTicketId(id);
	            return "update-ticket";
	        }
	        ticketService.updateticket(id, ticket);
	        return "redirect:/tickets";
	    }
	    @GetMapping("/delete/{id}")
	    public String deleteUser(@PathVariable("id") int id, Model model) {
	       ticketService.deleteticket(id);
	       return "redirect:/tickets";
	    }
}
