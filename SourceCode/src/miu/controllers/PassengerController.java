package miu.controllers;

import java.util.*;
import miu.StorageHandler;
import miu.Utility;
import miu.models.*;

import java.util.*;

public class PassengerController {
    public void createReservation(Passenger passenger, List<Ticket> tickets){
    	Reservation reservation = new Reservation(tickets);
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

    public static Reservation makeReservation(List<FlightInstance> flightInstances) {
        Scanner Input = new Scanner(System.in);  // Create a Scanner object
        Reservation reservation = new Reservation(null);
        for(FlightInstance flightInstance: flightInstances){
            Ticket reservationTicket =
                    new Ticket(StorageHandler.randomNumber(), StorageHandler.randomNumber(), flightInstance);
            reservation.addTicket(reservationTicket);
        }
        return reservation;
    }

    public static void cancelReservation(Reservation reservation){

    }



    public static void main(String[] args) {
        //TODO: implement cases of passenger here.
        Utility.ExampleOuput("Passenger Hello world");

        List<FlightInstance> FInstance = StorageHandler.generateListFlightInstance(10);
        Reservation reservation = makeReservation(FInstance);
    }
}
