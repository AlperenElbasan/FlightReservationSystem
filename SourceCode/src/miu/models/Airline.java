package miu.models;

import java.util.UUID;

public class Airline {
	private UUID uuid;
	private String code;
	private String name;
	private String history;
	public Airline(String code, String name, String history) {
		super();
		this.uuid = UUID.randomUUID();
		this.code = code;
		this.name = name;
		this.history = history;
	}
	public UUID getUuid() {
		return uuid;
	}
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public String getHistory() {
		return history;
	}
}

