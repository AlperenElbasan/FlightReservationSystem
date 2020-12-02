package miu.models;

import miu.StorageHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agent {
	private UUID uuid;
	private List<Passenger> passengers;
	public Agent() {
		super();
		this.uuid = UUID.randomUUID();
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
