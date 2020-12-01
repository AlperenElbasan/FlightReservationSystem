package miu.controllers;

import java.util.List;

import miu.StorageHandler;
import miu.Utility;
import miu.models.Airport;

public class AgentController {

    //TODO methods here
	public static void listAirports() {
		StorageHandler.createRandomAirports(10);
		List<Airport> airports = StorageHandler.airports;
		for (Airport airport: airports)
			System.out.println(airport);
	}


    public static void main(String[] args) {
        //TODO: implement cases of passenger here.
        Utility.ExampleOuput("AgentController Hello world");
        
        listAirports();
    }


}
