package miu;

import miu.models.FlightInstance;

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
}
