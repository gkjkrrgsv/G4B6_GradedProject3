package com.glearning.ticketTracker.serviceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.ticketTracker.entity.Ticket;
import com.glearning.ticketTracker.repository.TicketRepository;
import com.glearning.ticketTracker.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	 @Autowired
	 private TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAllTicket() {
		// TODO Auto-generated method stub
	return ticketRepository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket tkt) {
		// TODO Auto-generated method stub
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MM yyyy");
		tkt.setCreatedOn(LocalDate.now().format(format));
		Ticket ticket =ticketRepository.save(tkt);
		return ticket;
	}

	@Override
	public Ticket findTicketById(Long id) {
		// TODO Auto-generated method stub
		Optional<Ticket> tktOptional= ticketRepository.findById(id);
		if(tktOptional.isPresent()) {
			return tktOptional.get();
		}
		throw new RuntimeException("Ticket doesn't exist");
	}

	@Override
	public Ticket updateTicket(Long id, Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket existingTkt= findTicketById(id);
		existingTkt.setTitle(ticket.getTitle());
		existingTkt.setDescription(ticket.getDescription());
		existingTkt.setContent(ticket.getContent());
		return ticketRepository.save(existingTkt);
	}

	@Override
	public void deleteTicket(Long id) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(id);
	}

	@Override
	public List<Ticket> findTicketByTitleLike(String title) {
		// TODO Auto-generated method stub
		return ticketRepository.findByTitleContaining(title);
	}

	@Override
	public List<Ticket> findTicketByDescriptionLike(String description) {
		// TODO Auto-generated method stub
		return ticketRepository.findByDescriptionContaining(description);
	}
	 
	 
}
