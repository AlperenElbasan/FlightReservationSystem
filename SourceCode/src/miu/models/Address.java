package miu.models;

import java.util.UUID;

public class Address {
	private UUID uuid;
	private String street;
	private String city;
	private String state;
	private int zip;
	public Address(String street, String city, String state, int zip) {
		super();
		this.uuid = UUID.randomUUID();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public UUID getUuid() {
		return uuid;
	}
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public int getZip() {
		return zip;
	}
}
