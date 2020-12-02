package miu.unittest;

import miu.StorageHandler;
import miu.controllers.PassengerController;
import miu.models.FlightInstance;
import miu.models.Passenger;
import miu.models.Reservation;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassengerControllerTest {
    private final PassengerController passengerController = new PassengerController();

	@Test
    void createReservation() {

    }

    @Test
    void testCreateReservation() {
    }

    @Test
    void cancelReservation() {
    }

    @Test
    void getListAirport() {
    }

    @Test
    void getFlightsOnDate() {
    }

    @Test
    void getOwnReservation() {
    }

    @Test
    void getDetailsOfReservation() {
    }

    @Test
    void makeReservation() {
        Passenger passenger = StorageHandler.getRandomPassenger(1);
        List<FlightInstance> flightInstanceList = StorageHandler.generateListFlightInstance(10);

        Reservation reservation = passengerController.makeReservation(passenger,flightInstanceList);

    }

    @Test
    void testCancelReservation() {
    }

    @Test
    void confirmAndPurchase() {
    }
}