package miu.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agent {
	private UUID uuid;
	private List<Passenger> passengers;
	public Agent(UUID uuid) {
		super();
		this.uuid = uuid;
		this.passengers = new ArrayList<>();
	}
	public UUID getUuid() {
		return uuid;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}
}
