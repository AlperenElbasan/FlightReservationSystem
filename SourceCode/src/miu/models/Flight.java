package miu.models;

import java.util.Date;
import java.util.UUID;

public class Flight {
	private UUID uuid;
	private int number;
	private int capacity;
	private Airline airlineOwn;
	private Airport departureAirport;
	private Airport arrivalAirport;
	private Date departureTime;
	private Date arrivalTime;
	public Flight(int number, int capacity, Airline airlineOwn, Airport departureAirport,
			Airport arrivalAirport, Date departureTime, Date arrivalTime) {
		super();
		this.uuid = UUID.randomUUID();
		this.number = number;
		this.capacity = capacity;
		this.airlineOwn = airlineOwn;
		
		this.departureAirport = departureAirport;
		departureAirport.addDepartureFlight(this);
		this.arrivalAirport = arrivalAirport;
		arrivalAirport.addArrivalFlights(this);
		
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	public UUID getUuid() {
		return uuid;
	}
	public int getNumber() {
		return number;
	}
	public int getCapacity() {
		return capacity;
	}
	public Airline getAirlineOwn() {
		return airlineOwn;
	}
	public Airport getDepartureAirport() {
		return departureAirport;
	}
	public Airport getArrivalAirport() {
		return arrivalAirport;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	@Override
	public String toString() {
		return "Flight [number=" + number + ", airlineOwn=" + airlineOwn.getCode() + ", departureAirport=" + departureAirport.getName()
				+ ", arrivalAirport=" + arrivalAirport.getName() + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + "]";
	}
	
}
