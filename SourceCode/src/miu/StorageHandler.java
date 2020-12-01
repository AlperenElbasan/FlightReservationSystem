package miu;

import miu.models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StorageHandler {
	public static List<Airport> airports = new ArrayList<>();
    public static List<Address> addresses = new ArrayList<>();
    public static List<Flight> flights = new ArrayList<>();
    public static List<FlightInstance> flightInstances = new ArrayList<>();
    public static List<Passenger> passengers = new ArrayList<>();

    public static List<Reservation> getReservations() {
        return reservations;
    }

    public static List<Reservation> reservations = new ArrayList<>();

    public static void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public static Address getRandomAddress() {
    	return new Address("Main road", "Fairfield", "IOWA", (int)(Math.random() * 1000) + 3000);
    }
    
    public static void createRandomAddresses(int amount) {
    	for (int i = 0; i < amount; i++) {
    		addresses.add(getRandomAddress());
    	}
    }

    public static int randomNumber(){
        return (int)(Math.random() * 1000);
    }

    public static List<Passenger> getListPassenger(int amount){
        for (int i = 0; i< amount; i++) {
            passengers.add(getRandomPassenger(i));
        }
        return passengers;
    }

    public static Passenger getRandomPassenger(int num){
        return new Passenger(
                "name" + num,
                "last name" + num,
                new Date(),
                num +"_email@gmail.com",
                getRandomAddress()
        );
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

    public static Flight createRandomFlight(int amount) {
        int number = (int)Math.random();
        int capacity = amount;
        Airline airlineOwn = new Airline("AIA", "American Airline", "history");
        Airport departureAirport = getRandomAirport();
        Airport arrivalAirport = getRandomAirport();
        Date departureTime = new Date();
        Date arrivalTime = new Date();
        return new Flight(number, capacity, airlineOwn, departureAirport, arrivalAirport, departureTime, arrivalTime);
    }

    public static List<String> createRandomPilots(int amount) {
        List<String> pilots = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            pilots.add("pilot_" + i);
        }
        return pilots;
    }

    public static List<String> createRandomCrew(int amount) {
        List<String> crews = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            crews.add("crew_" + i);
        }
        return crews;
    }

    public static FlightInstance createRandomFlightInstance(){
        int number = (int)Math.random();
        int capacity = 30;
        Airline airlineOwn = new Airline("AIA", "American Airline", "history");
        Airport departureAirport = getRandomAirport();
        Airport arrivalAirport = getRandomAirport();
        Date dateFlight = new Date();
        List<Passenger> passengers = getListPassenger(10);
        List<String> pilots = createRandomPilots(5);
        List<String> crews = createRandomCrew(5);

        return new FlightInstance(
                createRandomFlight(5),
                dateFlight,
                passengers,
                crews,
                pilots
            );
    }

    public static List<FlightInstance> generateListFlightInstance(int amount) {
        List<FlightInstance> flightInstances = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            flightInstances.add(createRandomFlightInstance());
        }
        return flightInstances;
    }

    public static void initializeData() {
        System.out.println("initializeData");
    }

    public static void printReservations() {
        for (Reservation r: reservations) {
            System.out.print("reservation: " + r.getAgentId());
        }
    }
}
