package miu.controllers;

import miu.Utility;

public class PassengerController {
    public void createReservation(){
    	Reservation reservation = new Reservation(?);
    }

    public void cancelReservation(){

    }

    public void getListAirport(){

    }
    
    public void getFlightsOnDate(Date departureAirport, Date arrivalAirport, Date date) {
    	
    }
    
    public List<Reservation> getOwnReservation(Passenger passenger) {
    	return passenger.getReservations();
    }

    public static void main(String[] args) {
        //TODO: implement cases of passenger here.
        Utility.ExampleOuput("Passenger Hello world");
    }

}
