package miu.models;

import java.util.*;

public class Reservation {
	private UUID uuid;
	private UUID AgentId;
	private List<Ticket> tickets;
	
	public Reservation(List<Ticket> tickets) {
		super();
		this.tickets = new ArrayList<Ticket>(tickets);
		this.uuid = UUID.randomUUID();
		// tickets = new ArrayList<>();
	}

	public Reservation(UUID agentId, List<Ticket> tickets) {
		super();
		this.tickets = new ArrayList<Ticket>(tickets);
		this.uuid = UUID.randomUUID();
		this.AgentId = agentId;
		// tickets = new ArrayList<>();
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
}
