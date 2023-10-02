package com.glearning.ticketTracker.service;

import java.util.List;


import com.glearning.ticketTracker.entity.Ticket;

public interface TicketService {

	  public List<Ticket> findAllTicket();
	  public Ticket saveTicket(Ticket tkt);
	  public Ticket findTicketById(Long id);
	  public List<Ticket> findTicketByTitleLike(String title);
	  public List<Ticket> findTicketByDescriptionLike(String description);
	  public Ticket updateTicket(Long id,Ticket tkt);
	  public void deleteTicket(Long id);
}

