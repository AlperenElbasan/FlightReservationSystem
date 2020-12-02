package miu.models;

import miu.StorageHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agent {
	private UUID uuid;
	private List<Passenger> passengers;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String firstName;
	private String lastName;
	private String email;

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
