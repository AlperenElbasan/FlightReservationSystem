package miu.controllers;

import java.util.ArrayList;
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
