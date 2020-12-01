package miu.models;

import java.util.Date;
import java.util.UUID;
import java.util.List;

public class FlightInstance extends Flight {
	private UUID uuid;
	private Date flightDate;
	private List<Passenger> passengers;
	private List<String> crews;
	private List<String> pilots;
	public FlightInstance(int number, int capacity, Airline airlineOwn, Airport departureAirport,
			Airport arrivalAirport, Date departureTime, Date arrivalTime, Date flightDate,
			List<Passenger> passengers, List<String> crews, List<String> pilots) {
		super(number, capacity, airlineOwn, departureAirport, arrivalAirport, departureTime, arrivalTime);
		uuid = UUID.randomUUID();
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
