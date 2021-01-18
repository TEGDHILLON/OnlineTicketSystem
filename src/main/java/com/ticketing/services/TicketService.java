package com.ticketing.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketing.modeles.Movie;
import com.ticketing.modeles.Ticket;
import com.ticketing.repositories.TicketRepository;

@Service
public class TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	public List<Ticket> getAlltickets(){
		List<Ticket> tickets=new ArrayList<>();
		ticketRepository.findAll().forEach(tickets::add);
//		ticketRepository.findAll().forEach(m->tickets.add();
		return tickets;
	}
	 public void addticket(Ticket ticket) {
		 ticketRepository.save(ticket);
	 }
	 public Optional<Ticket> getTicket(int id) {
			Optional<Ticket> t=ticketRepository.findById(id);
			return t;
		}
	 public void updateticket(int id, Ticket ticket) {
		 ticket.setTicketId(id);
		 ticketRepository.save(ticket);
		}
		
	 public void deleteticket(Integer id) {
			ticketRepository.deleteById(id);
			
		}
}
