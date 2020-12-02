package miu.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Airport {
	private UUID uuid;
	private String code;
	private String name;
	private Address address;
	private List<Flight> departureFlights = new ArrayList<>();
	private List<Flight> arrivalFlights = new ArrayList<>();
	
	public Airport(String code, String name, Address address) {
		super();
		this.uuid = UUID.randomUUID();
		this.code = code;
		this.name = name;
		this.address = address;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Flight> getDepartureFlights() {
		return departureFlights;
	}
	public List<Flight> getArrivalFlights () {
		return arrivalFlights;
	}
	public void addDepartureFlight(Flight flight) {
		departureFlights.add(flight);
	}
	public void removeDepartureFlight(Flight flight) {
		departureFlights.remove(flight);
	}
	public void addArrivalFlights(Flight flight) {
		arrivalFlights.add(flight);
	}
	public void removeArrivalFlights(Flight flight) {
		arrivalFlights.remove(flight);
	}
	@Override
	public String toString() {
		return "Airport [ " + uuid + ", " + code + ", " + name + ", address = " + address + " ]";
	}
}
