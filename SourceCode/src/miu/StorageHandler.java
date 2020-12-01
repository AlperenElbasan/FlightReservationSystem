package miu;

import miu.models.Address;
import miu.models.Airport;
import miu.models.Flight;
import miu.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class StorageHandler {
	public static List<Airport> airports = new ArrayList<>();
    public static List<Address> addresses = new ArrayList<>();
    public static List<Flight> flights = new ArrayList<>();
    public static List<Passenger> passengers = new ArrayList<>();
    
    public static Address getRandomAddress() {
    	return new Address("Main road", "Fairfield", "IOWA", (int)(Math.random() * 1000) + 3000);
    }
    
    public static void createRandomAddresses(int amount) {
    	for (int i = 0; i < amount; i++) {
    		addresses.add(getRandomAddress());
    	}
    }
    
    public static void emptyAddresses() {
    	addresses.removeAll(addresses);
    }
    
    public static Airport getRandomAirport() {
    	final String airportCode = (int)(Math.random() * 1000) + "";
    	return new Airport(airportCode, "Airport Number " + airportCode, getRandomAddress());
    }
    
    public static void createRandomAirports(int amount) {
    	for (int i = 0; i < amount; i++) {
    		airports.add(getRandomAirport());
    	}
    }
    
    public static void emptyAirports() {
    	airports.removeAll(airports);
    }
}
