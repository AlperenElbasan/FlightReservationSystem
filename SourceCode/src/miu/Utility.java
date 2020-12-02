package miu;

import miu.models.FlightInstance;
import miu.models.Passenger;

import java.util.Scanner;

public class Utility {
    public static void ExampleOuput(String input){
        System.out.println(input);
    }

    public static void viewFlightInstanceDetail(FlightInstance flightInstance){
        System.out.println("=======================");
        System.out.println(flightInstance.getFlight().getDepartureAirport().getName() + " --> " +
                flightInstance.getFlight().getArrivalAirport().getName());
        System.out.println("Flight Date: " +
                flightInstance.getFlightDate() + ", " +
                flightInstance.getFlight().getDepartureTime() + "-->" +
                flightInstance.getFlight().getArrivalTime());
        System.out.println("=======================");
    }

    public static void viewPassengerDetail(Passenger passenger){
        System.out.println("=======================");
        System.out.println("FirstName: " + passenger.getFirstName());
        System.out.println("LastName: " + passenger.getLastName());
        System.out.println("BirthDate: " + passenger.getBirthDate());
        System.out.println("Email: " + passenger.getEmail());
        System.out.println("=======================");
    }
}
