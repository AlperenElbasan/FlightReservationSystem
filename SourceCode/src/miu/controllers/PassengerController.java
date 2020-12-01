package miu.controllers;

import miu.Utility;

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
    	// View list of own reservations
    	
    	return passenger.getReservations();
    }
    
    public List<Reservation> getDetailsOfReservation(Reservation reservation) {
    	
    }

    public static void main(String[] args) {
        //TODO: implement cases of passenger here.
        Utility.ExampleOuput("Passenger Hello world");
    }

}
