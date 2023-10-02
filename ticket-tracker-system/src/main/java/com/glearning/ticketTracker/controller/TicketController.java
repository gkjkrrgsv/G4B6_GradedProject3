package com.glearning.ticketTracker.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glearning.ticketTracker.entity.Ticket;
import com.glearning.ticketTracker.service.TicketService;
import com.glearning.ticketTracker.serviceImpl.TicketServiceImpl;

@Controller
public class TicketController {

	@Autowired
	private TicketService ticketService;

	public TicketController(TicketServiceImpl ticketService) {
		super();
		this.ticketService = ticketService;
	}
	
	@GetMapping("/tickets")
    public String getTickets(Model model) {
		List<Ticket> tickets =ticketService.findAllTicket();
		model.addAttribute("tickets", tickets);
		return "tickets";
	}
	@GetMapping("/tickets/new")
   public String createTicket(Model model) {
		Ticket ticket =new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";
	}
	
	@PostMapping("/tickets")
   public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.saveTicket(ticket);
	    return "redirect:/tickets";
	}
	
	@GetMapping("/tickets/edit/{id}")
	 public String updateTicketForm(@PathVariable Long id,  Model model) {
	  model.addAttribute("ticket",ticketService.findTicketById(id));
	  return "edit_ticket";
	 }
	@PostMapping("/tickets/{id}")
   public String updateTicket(@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket) {
		ticketService.updateTicket(id, ticket);
	    return "redirect:/tickets";
	}
	@GetMapping("/tickets/view/{id}")
	public String viewTicket(@PathVariable Long id,  Model model) {
		model.addAttribute("ticket",ticketService.findTicketById(id));
		return "view_ticket";
	}
	@GetMapping("/tickets/search")
	public String searchTicket(	@RequestParam(name="title", required=false) String title, 
						Model model) {
		List<Ticket> tickets =ticketService.findTicketByDescriptionLike(title);
		tickets.addAll(ticketService.findTicketByTitleLike(title));
		Set<Ticket> hset=new LinkedHashSet<>();
		hset.addAll(tickets);
		model.addAttribute("tickets", hset);
		return (title != null ? "view_search_tickets" : "redirect:/tickets");
	}
	

	@GetMapping("/tickets/{id}")
    public String deleteTicket(@PathVariable Long id) {
		ticketService.deleteTicket(id);
	    return "redirect:/tickets";
	}
	
}
