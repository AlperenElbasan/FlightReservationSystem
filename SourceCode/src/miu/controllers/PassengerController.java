package miu.controllers;

import miu.Utility;
import miu.models.Passenger;
import miu.models.Reservation;

import java.util.List;

public class PassengerController {
    public void createReservation(){
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
