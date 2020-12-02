package miu.controllers;

import java.util.*;
import miu.StorageHandler;
import miu.Utility;
import miu.models.*;

import java.util.*;

public class PassengerController {
    public void createReservation(Passenger passenger, List<Ticket> tickets){
    	Reservation reservation = new Reservation();
    	passenger.addReservation(reservation);
    	
    	System.out.println("added reservation to passenger...");
    }

    public void cancelReservation(){

    }

    public void getListAirport(){

    }

    public void getFlightsOnDate(Date departureAirport, Date arrivalAirport, Date date) {

    }

    public List<Reservation> getOwnReservation(Passenger passenger) {
    	return passenger.getReservation();
    }
    

    public List<Reservation> getDetailsOfReservation(Reservation reservation) {
    	return null;
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
