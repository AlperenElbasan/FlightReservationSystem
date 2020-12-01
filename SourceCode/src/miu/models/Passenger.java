package miu.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Passenger {
	private UUID uuid;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String email;
	private Address residenceAddress;
	private List<Reservation> reservations;
	
	public Passenger(String firstName, String lastName, Date birthDate, String email,
			Address residenceAddress) {
		super();
		this.uuid = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.residenceAddress = residenceAddress;
	}
	public UUID getUuid() {
		return uuid;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public String getEmail() {
		return email;
	}
	public Address getResidenceAddress() {
		return residenceAddress;
	}

	// reservation part
	public List<Reservation> getReservation() {
    	return reservations;
    }
	
	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}
	
	public void removeReservation(Reservation reservation) {
		reservations.remove(reservation);
	}
}
