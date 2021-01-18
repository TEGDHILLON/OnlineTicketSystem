package com.ticketing.modeles;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ticket {
	@Id
	@GeneratedValue
	private int ticketId;
	@NotNull
	private String movieName;
	@NotNull
	private int custId;
	@NotNull
	private Double amountPaid;
	@NotNull
	private Integer numberofTicket;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	@NotNull
	private String time;
	@NotNull
	private String venue;
	public Ticket() {
		}
	public Ticket(@NotNull String movieName, @NotNull int custId, @NotNull Double amountPaid,
			@NotNull Integer numberofTicket, @NotNull LocalDate date, @NotNull String time, @NotNull String venue) {
		
		this.movieName = movieName;
		this.custId = custId;
		this.amountPaid = amountPaid;
		this.numberofTicket = numberofTicket;
		this.date = date;
		this.time = time;
		this.venue = venue;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public Double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Integer getNumberofTicket() {
		return numberofTicket;
	}
	public void setNumberofTicket(Integer numberofTicket) {
		this.numberofTicket = numberofTicket;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	

}
