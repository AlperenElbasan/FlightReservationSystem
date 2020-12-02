package miu.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import miu.StorageHandler;
import miu.Utility;
import miu.models.*;

public class AgentController {
    public static void listAirports() {
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

	public Reservation createReservation(Agent agent, Passenger passenger, List<FlightInstance> flightInstances) {
        Reservation reservation = new Reservation(agent.getUuid());
        for (FlightInstance f: flightInstances) {
            Ticket t = new Ticket(
                    StorageHandler.randomTicketNumber(),
                    reservation.getReservationCode(),
                    f);
            reservation.addTicket(t);
        }
        passenger.addReservation(reservation);

        StorageHandler.addReservation(reservation);
        StorageHandler.setTickets(reservation.getReservationCode(), reservation.getTickets());

        return reservation;
    }

    public void cancelReservation(String reservationCode) {
        StorageHandler.removeTickets(reservationCode);
        StorageHandler.removeReservation(reservationCode);
    }

    public void confirmAndPurchase(String reservationCode, Boolean status){
        if(status) {
            Reservation reservation = StorageHandler.getReservationByCode(reservationCode);
            reservation.confirmed();
            StorageHandler.updateReservation(reservation);
        } else {
            cancelReservation(reservationCode);
        }
    }

    // added by Bayartsogt
    public static List<FlightInstance> getFlightsOnDate(String departureAirportName, String arrivalAirportName, Date date) {
        
        List<FlightInstance> flightInstancesFound = ArrayList<FlightInstance>();

        for (FlightInstance flightInstance: StorageHandler.flightInstances){
            // comparing dates, departure & arrival airport NAMES
            boolean case1 = DateUtils.isSameDay(flightInstance.getFlightDate(), date);
            boolean case2 = flightInstance.getFlight().getDepartureAirport().getName() == departureAirportName;
            boolean case3 = flightInstance.getFlight().getArrivalAirport().getName() == arrivalAirportName;

            if (case1 && case2 && case3){
                flightInstancesFound.add(flightInstance);
            }
        }
        
        return flightInstancesFound;
    }

    // added by Bayartsogt
    public static List<Reservation> getOwnReservation(Agent agent) {
        List<Reservation> reservations = ArrayList<Reservation>();
    	return agent.getReservation();
    }

    // currently it is just printing // added by Bayartsogt
    public static void getDetailsOfReservation(Reservation reservation) {
        System.out.println("=================")
        System.out.println("Agent ID:" + reservation.agent)
        
        for (Ticket ticket : reservation.getTickets()){
            Utility.viewFlightInstanceDetail(ticket.getFlightInstance());
        }
        System.out.println("=================")
    }

//    public static void main(String[] args) {
//        listAirports();
//
//        Agent agent = new Agent();
//        agent.addPassenger(StorageHandler.getRandomPassenger(1));
//        agent.addPassenger(StorageHandler.getRandomPassenger(2));
//        List<FlightInstance> flightInstances = StorageHandler.generateListFlightInstance(5);
//
//        Passenger passenger = StorageHandler.getRandomPassenger(2);
//        createReservation(agent, passenger, flightInstances);
//    }
}
