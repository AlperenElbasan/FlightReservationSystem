package miu.models;

import java.util.UUID;

public class Reservation {
	private UUID uuid;
	private int AgentId;
	private List<Ticket> tickets 
	
	public Reservation(List<Ticket> tickets) {
		super();
		this.uuid = UUID.randomUUID();
		this.tickets = new ArrayList<Ticket>(tickets);
//		AgentId = agentId;
	}
	public UUID getUuid() {
		return uuid;
	}
	public int getAgentId() {
		return AgentId;
	}
}
