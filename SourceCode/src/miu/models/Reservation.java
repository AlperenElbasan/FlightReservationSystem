package miu.models;

import java.util.*;

public class Reservation {
	private UUID uuid;
	private UUID AgentId;
	private List<Ticket> tickets;

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
	}

	public Reservation(UUID agentId) {
		super();
		this.uuid = UUID.randomUUID();
		AgentId = agentId;
		tickets = new ArrayList<>();
	}
	public UUID getUuid() {
		return uuid;
	}

	public UUID getAgentId() {
		return AgentId;
	}

	public List<Ticket> addTicket(Ticket ticket) {
		tickets.add(ticket);
		return tickets;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}
}
