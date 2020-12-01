package miu.models;

import java.util.*;

public class Reservation {
	private UUID uuid;
	private UUID AgentId;
	private List<Ticket> tickets;
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

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	public List<Ticket> getTickets() {
		return tickets;
	}
}
