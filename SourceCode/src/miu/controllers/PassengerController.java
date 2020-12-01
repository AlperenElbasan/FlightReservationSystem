package miu.controllers;

import java.util.*;
import miu.StorageHandler;
import miu.Utility;
import miu.models.Agent;
import miu.models.FlightInstance;
import miu.models.Passenger;
import miu.models.Reservation;

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
        //TODO: implement cases of passenger here.
        Utility.ExampleOuput("Passenger Hello world");
        StorageHandler storageHandler = new StorageHandler();
        List<FlightInstance> FInstance = storageHandler.generateListFlightInstance(10);
        makeReservation(FInstance);
    }
}
