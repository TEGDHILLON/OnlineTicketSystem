package com.ticketing.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ticketing.modeles.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
