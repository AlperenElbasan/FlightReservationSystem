package miu.unittest;

import miu.StorageHandler;
import miu.controllers.AgentController;
import miu.models.*;
import org.junit.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AgentControllerTest {
    AgentController agentCtr = new AgentController();
    @Test
    void makeReservation() {
        Agent agent = new Agent();
        agent.addPassenger(StorageHandler.getRandomPassenger(1));
        agent.addPassenger(StorageHandler.getRandomPassenger(2));
        List<FlightInstance> flightInstances = StorageHandler.generateListFlightInstance(5);
        Passenger passenger = StorageHandler.getRandomPassenger(2);
        Reservation re = AgentController.createReservation(agent, passenger, flightInstances);

        assertEquals(re, StorageHandler.getReservationByCode(re.getReservationCode()), "true");
    }

    @org.junit.jupiter.api.Test
    void listAirports() {
    }

    @org.junit.jupiter.api.Test
    void createReservation() {
    }

    @org.junit.jupiter.api.Test
    void cancelReservation() {
    }

    @org.junit.jupiter.api.Test
    void confirmAndPurchase() {
    }
}