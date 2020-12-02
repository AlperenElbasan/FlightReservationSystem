package miu.models;

import miu.StorageHandler;
import miu.constants.ReservationStatus;

import java.util.*;

public class Reservation {
	private UUID uuid;
	private UUID AgentId;
	private List<Ticket> tickets;
	private ReservationStatus status = ReservationStatus.NONE;
	private String reservationCode;

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	/*
	*
	* passenger can make a reservation
	* so we need more constructor without Agent
	* */
	public Reservation() {
		super();
		this.uuid = UUID.randomUUID();
		AgentId = null;
		tickets = new ArrayList<>();
		reservationCode = StorageHandler.randomReservationCode();
	}

	public String getReservationCode() {
		return reservationCode;
	}

	public Reservation(UUID agentId) {
		super();
		this.uuid = UUID.randomUUID();
		AgentId = agentId;
		tickets = new ArrayList<>();
	}

	public Reservation(List<Ticket> tickets) {
		super();
		this.uuid = UUID.randomUUID();
		AgentId = null;
		this.tickets = tickets;
	}

	public UUID getUuid() {
		return uuid;
	}

	public UUID getAgentId() {
		return AgentId;
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void cancel(){
		this.status = ReservationStatus.CANCEL;
		tickets.clear();
	}

	public void confirmed(){
		this.status = ReservationStatus.CONFIRM_PURCHASE;
	}
}
