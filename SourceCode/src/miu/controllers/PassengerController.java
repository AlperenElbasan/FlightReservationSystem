package miu.controllers;

import java.util.*;
import miu.StorageHandler;
import miu.Utility;
import miu.models.Agent;
import miu.models.FlightInstance;
import miu.models.Passenger;
import miu.models.Reservation;

import java.util.List;

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

    public static void makeReservation(List<FlightInstance> flightInstances) {
        Reservation reservation = new Reservation(0);
        System.out.println("Please select your ");

    }

    public void viewFlightInstanceDetail(FlightInstance flightInstance){
        System.out.println("=======================");
        System.out.println(flightInstance.getFlight().getNumber() + ": " +
                flightInstance.getFlight().getDepartureAirport() + " --> " +
                flightInstance.getFlight().getArrivalAirport());
        System.out.println();
        System.out.println("=======================");
    }
    public static void main(String[] args) {
        //TODO: implement cases of passenger here.
        Utility.ExampleOuput("Passenger Hello world");
        StorageHandler storageHandler = new StorageHandler();
        List<FlightInstance> FInstance = storageHandler.generateListFlightInstance(10);

    }



}
