package miu.models;

import java.util.Date;
import java.util.UUID;
import java.util.List;

public class FlightInstance {
	private UUID uuid;
	private Date flightDate;
	private Flight flight;
	private List<Passenger> passengers;
	private List<String> crews;
	private List<String> pilots;
	public FlightInstance(Flight flight, Date flightDate, List<Passenger> passengers, List<String> crews, List<String> pilots) {
		uuid = UUID.randomUUID();
		this.flight = flight;
		this.flightDate = flightDate;
		this.passengers = passengers;
		this.crews = crews;
		this.pilots = pilots;
	}
	public UUID getUuid() {
		return uuid;
	}
	public Date getFlightDate() {
		return flightDate;
	}
	public Flight getFlight() {
		return flight;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public List<String> getCrews() {
		return crews;
	}
	public List<String> getPilots() {
		return pilots;
	}
}
