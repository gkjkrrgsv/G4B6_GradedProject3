package com.glearning.ticketTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.ticketTracker.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long>{
	List<Ticket> findByTitleContaining(String title);
	List<Ticket> findByDescriptionContaining(String description);
}
