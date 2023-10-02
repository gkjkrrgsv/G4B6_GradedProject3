package com.glearning.ticketTracker.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	 private long id;
	@Column(name="title")
	 private String title;
	@Column(name="description")
	 private String description;
	@Column(name="content")
	 private String content;
	@Column(name="created_on")
	 private String createdOn;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
		
	}


	public Ticket(long id, String title, String description, String content, String createdOn) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.createdOn = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MM yyyy"));
		System.out.println("Constr" + this.createdOn);
	}


	public Ticket() {}
	
	
}
