package miu.controllers;

import java.util.*;
import miu.StorageHandler;
import miu.Utility;
import miu.models.Agent;
import miu.models.Airline;
import miu.models.Airport;
import miu.models.Flight;
import miu.models.FlightInstance;
import miu.models.Passenger;
import miu.models.Reservation;
import miu.models.Ticket;

public class PassengerController {
    public void createReservation(Passenger passenger, List<Ticket> tickets){
    	Reservation reservation = new Reservation(tickets);
    	passenger.addReservation(reservation);
    	
    	System.out.println("added reservation to passenger...");
    }

    public void cancelReservation(){

    }

    public static void listAirports(){
    	StorageHandler.createRandomAirports(10);
		List<Airport> airports = StorageHandler.airports;
		for (Airport airport: airports)
			System.out.println(airport);
		StorageHandler.emptyAirports();
    }
    
    public static void listFlights(String code) {
    	System.out.println("\n#####\nListing airlines for the code " + code + "\n");
    	// populate the db...
    	Airport departureAirport = new Airport(code, code + " Airport", StorageHandler.getRandomAddress());
    	Airport arrivalAirport = new Airport("WYZ", "WYZ Airport", StorageHandler.getRandomAddress());
    	
    	int i = 0;
    	while (i++ < 5)
    		new Flight(1, 350, StorageHandler.getRandomAirline(), departureAirport, arrivalAirport, new Date(), new Date());
    	
    	
    	// perform the query
    	List<Flight> depFlights = departureAirport.getDepartureFlights();
    	List<Airline> airlines = new ArrayList<>();
    	System.out.println("First list all the flights\n");
    	for (Flight depFlight: depFlights) {
    		Airline depFlightAirline = depFlight.getAirlineOwn();
    		if (!airlines.contains(depFlightAirline)) {
    			airlines.add(depFlightAirline);
    		}
    		
    		System.out.println(depFlight);
    	}
    	
    	System.out.println("\nAnd now all the airlines\n");
    	for (Airline airline: airlines)
    		System.out.println(airline);
    	
    	System.out.println("\nEnd of the listing airlines for the code \n#####\n");
    }

    public void getFlightsOnDate(Date departureAirport, Date arrivalAirport, Date date) {

    }

    public List<Reservation> getOwnReservation(Passenger passenger) {
    	return passenger.getReservation();
    }
    
    public List<Reservation> getDetailsOfReservation(Reservation reservation) {
    	return null;
    }

    public static void makeReservation(List<FlightInstance> flightInstances) {
        Scanner Input = new Scanner(System.in);  // Create a Scanner object
        Reservation reservation = new Reservation(null);
        for(FlightInstance flightInstance: flightInstances){
            Utility.viewFlightInstanceDetail(flightInstance);
        }
        System.out.println("Please select your flight");
        int flightNumber = Input.nextInt();

    }


    public static void main(String[] args) {
    	// First use-case
    	listAirports();
    	// Second use-case
        listFlights("COH");
    	
    	
        List<FlightInstance> FInstance = StorageHandler.generateListFlightInstance(10);
        makeReservation(FInstance);
    }
}
