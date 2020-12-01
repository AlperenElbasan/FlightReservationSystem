package models;

import java.util.UUID;

public class Ticket {
	private UUID uuid;
	private long number;
	private String reservationCode;
	private FlightInstance flightInstance;
	public Ticket(UUID uuid, long number, String reservationCode, FlightInstance flightInstance) {
		super();
		this.uuid = uuid;
		this.number = number;
		this.reservationCode = reservationCode;
		this.flightInstance = flightInstance;
	}
	public UUID getUuid() {
		return uuid;
	}
	public long getNumber() {
		return number;
	}
	public String getReservationCode() {
		return reservationCode;
	}
	public FlightInstance getFlightInstance() {
		return flightInstance;
	}
}
