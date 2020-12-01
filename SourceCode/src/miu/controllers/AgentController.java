package miu.controllers;

import java.util.List;

import miu.StorageHandler;
import miu.Utility;
import miu.models.Agent;
import miu.models.Airport;
import miu.models.FlightInstance;

public class AgentController {
    public static void listAirports() {
		StorageHandler.createRandomAirports(10);
		List<Airport> airports = StorageHandler.airports;
		for (Airport airport: airports)
			System.out.println(airport);
	}

	public static void makeReservation(Agent agent, List<FlightInstance> flightInstances) {

    }

    public static void main(String[] args) {
        Utility.ExampleOuput("AgentController Hello world");
        listAirports();

        Agent agent = new Agent();
        agent.addPassenger(StorageHandler.getRandomPassenger(1));
        agent.addPassenger(StorageHandler.getRandomPassenger(2));
        List<FlightInstance> flightInstances = StorageHandler.generateListFlightInstance(5);
        makeReservation(agent, flightInstances);
    }
}
