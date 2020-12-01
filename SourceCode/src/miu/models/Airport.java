package miu.models;

import java.util.UUID;

public class Airport {
	private UUID uuid;
	private String code;
	private String name;
	private Address address;
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
}
