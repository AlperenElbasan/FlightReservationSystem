package miu.controllers;

import miu.Utility;
import miu.models.*;
import miu.StorageHandler;

public class AdminController {
    private int name;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    // added by Bayartsogt
    public static void createPassenger(String firstName, String lastName,
                                       Date birthDate, String email,
                                       Address residenceAddress) {

        StorageHandler.passengers.add(new Passenger(firstName, lastName, birthDate, email, residenceAddress));
    }
    // Passenger CRUD
    public static void readPassenger(Passenger passenger){
        Utility.viewPassengerDetail(passenger); // do we need to find passenger and show it??
    }
    public static void updatePassengerFirstName(Passenger passenger, String firstName){
        passenger.setFirstName(firstName);
    }
    public static void updatePassengerLastName(Passenger passenger, String lastName){
        passenger.setLastName(lastName);
    }
    public static void updatePassengerEmail(Passenger passenger, String email){
        passenger.setEmail(email);
    }
    public static void deletePassenger(Passenger passenger){
        StorageHandler.passengers.remove(passenger);
    }

    // Agent CRUD
    public static void readAgent(Agent agent){
        Utility.viewPassengerDetail(passenger); // do we need to find passenger and show it??
    }
    public static void updateAgentFirstName(Agent agent, String firstName){
        agent.setFirstName(firstName);
    }
    public static void updateAgentLastName(Agent agent, String lastName){
        agent.setLastName(lastName);
    }
    public static void updateAgentEmail(Agent agent, String email){
        agent.setEmail(email);
    }
    public static void deleteAgent(Agent agent){
        StorageHandler.agents.remove(agent);
    }

    // Airport CRUD
    public static void readAirport(Airport airport){
        System.out.println("=== READ AIRPORT ===");
        System.out.println(airport.toString());
        System.out.println("====================");
    }
    public static void updateAirportName(Airport airport, String name){
        airport.setName(name);
    }
    public static void updateAirportCode(Airport airport, String code){
        airport.setCode(code);
    }
    public static void updateAirportAddress(Airport airport, Address address){
        airport.setAddress(address);
    }
    public static void deleteAirport(Airport airport){
        StorageHandler.airports.remove(airport);
    }

    // Airline CRUD
    public static void readAirline(Airline airline){
        System.out.println("=== READ AIRPORT ===");
        System.out.println(airline.toString());
        System.out.println("====================");
    }
    public static void updateAirlineName(Airline airline, String name){
        airline.setName(name);
    }
    public static void updateAirlineCode(Airline airline, String code){
        airline.setCode(code);
    }
    public static void updateAirlinegetHistory(Airline airline, String history){
        airline.setAddress(history);
    }
    public static void deleteAirline(Airline airline){
        StorageHandler.airlines.remove(airline);
    }

    public static void main(String[] args) {
        //TODO: implement cases of passenger here.
        Utility.ExampleOuput("AdminController Hello world");
    }


}
