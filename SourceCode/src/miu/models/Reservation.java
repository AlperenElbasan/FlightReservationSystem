package miu.models;

import java.util.UUID;

public class Reservation {
	private UUID uuid;
	private int AgentId;
	public Reservation(int agentId) {
		super();
		this.uuid = UUID.randomUUID();
		AgentId = agentId;
	}
	public UUID getUuid() {
		return uuid;
	}
	public int getAgentId() {
		return AgentId;
	}
}
