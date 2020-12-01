package miu.controllers;

import java.util.List;

import miu.StorageHandler;
import miu.Utility;
import miu.models.*;

public class AgentController {
    public static void listAirports() {
		StorageHandler.createRandomAirports(10);
		List<Airport> airports = StorageHandler.airports;
		for (Airport airport: airports)
			System.out.println(airport);
	}

	public static void makeReservation(Agent agent, List<FlightInstance> flightInstances) {
        Reservation reservation = new Reservation(agent.getUuid());
        for (FlightInstance f: flightInstances) {
            Ticket t = new Ticket(
                    StorageHandler.randomNumber(),
                    String.valueOf(StorageHandler.randomNumber()),
                    f);
            reservation.addTicket(t);
        }

        //Save to storage then we can show
        StorageHandler.addReservation(reservation);
    }

    public static void cancelReservation(Agent agent, Reservation reservation) {
        reservation.cancel();
    }
    
    public static void main(String[] args) {
        Utility.ExampleOuput("AgentController Hello world");
        listAirports();

        // Create agent
        Agent agent = new Agent();
        agent.addPassenger(StorageHandler.getRandomPassenger(1));
        agent.addPassenger(StorageHandler.getRandomPassenger(2));

        List<FlightInstance> flightInstances = StorageHandler.generateListFlightInstance(5);
        makeReservation(agent, flightInstances);
    }
}
