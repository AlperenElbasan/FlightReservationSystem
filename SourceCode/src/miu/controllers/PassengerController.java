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

    public static List<Reservation> getOwnReservation(Passenger passenger) {
    	return passenger.getReservation();
    }

    // currently it is just printing
    public static void getDetailsOfReservation(Reservation reservation) {
        System.out.println("=================")
        System.out.println("Agent ID:" + reservation.agent)
        
        for (Ticket ticket : reservation.getTickets()){
            Utility.viewFlightInstanceDetail(ticket.getFlightInstance());
        }
        System.out.println("=================")
    }

    public static Reservation makeReservation(List<FlightInstance> flightInstances) {
        Scanner Input = new Scanner(System.in);  // Create a Scanner object
        Reservation reservation = new Reservation();
        for(FlightInstance flightInstance: flightInstances){
            Ticket reservationTicket =
                    new Ticket(StorageHandler.randomTicketNumber(), StorageHandler.randomReservationCode(), flightInstance);
            reservation.addTicket(reservationTicket);
        }
        return reservation;
    }

    public static void cancelReservation(Reservation reservation){
        reservation.cancel();
    }

    public static void confirmAndPurchase(Reservation reservation, boolean Status){
        if(Status){
            reservation.confirmed();
        } else {
            reservation.cancel();
        }
    }

    public static void main(String[] args) {
        //TODO: implement cases of passenger here.
        Utility.ExampleOuput("Passenger Hello world");

        List<FlightInstance> FInstance = StorageHandler.generateListFlightInstance(10);
        Reservation reservation = makeReservation(FInstance);


    }
}
