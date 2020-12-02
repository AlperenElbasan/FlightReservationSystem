package miu.controllers;

import java.util.*;
import miu.StorageHandler;
import miu.Utility;
import miu.models.*;

import java.util.*;

public class PassengerController {
    // public void createReservation(Passenger passenger, List<Ticket> tickets){
    // 	Reservation reservation = new Reservation();
    // 	passenger.addReservation(reservation);
    	
    // 	System.out.println("added reservation to passenger...");
    // }

    public void getListAirport(){

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
    public static List<Reservation> getOwnReservation(Passenger passenger) {
    	return passenger.getReservation();
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

    public static Reservation makeReservation(Passenger passenger, List<FlightInstance> flightInstances) {
        Reservation reservation = new Reservation();
        for(FlightInstance flightInstance: flightInstances){
            Ticket reservationTicket =
                    new Ticket(StorageHandler.randomTicketNumber(),
                            reservation.getReservationCode(),
                            flightInstance);
            reservation.addTicket(reservationTicket);
        }
        passenger.addReservation(reservation);

        StorageHandler.addReservation(reservation);
        StorageHandler.setTickets(reservation.getReservationCode(), reservation.getTickets());

        return reservation;
    }

    public static void cancelReservation(String reservationCode){
        StorageHandler.removeTickets(reservationCode);
        StorageHandler.removeReservation(reservationCode);
    }

    public static void confirmAndPurchase(String reservationCode, Boolean status){
        if(status) {
            Reservation reservation = StorageHandler.getReservationByCode(reservationCode);
            reservation.confirmed();
            StorageHandler.updateReservation(reservation);
        } else {
            cancelReservation(reservationCode);
        }
    }

    public static void main(String[] args) {
        //TODO: implement cases of passenger here.
        Utility.ExampleOuput("Passenger Hello world");

        List<FlightInstance> FInstance = StorageHandler.generateListFlightInstance(10);
        Passenger passenger = StorageHandler.getRandomPassenger(2);

        Reservation reservation = makeReservation(passenger, FInstance);


    }
}
