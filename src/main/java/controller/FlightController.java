package controller;

import model.Flight;
import repository.FlightRepository;

public class FlightController {

    private FlightRepository flightRepository;

    public FlightController() {
        this.flightRepository=new FlightRepository();
    }

    public void insert(Flight flight){
        flightRepository.insert(flight);
    }

    public void delete(String name){
        flightRepository.delete(name);
    }

    public void updateNoTickets( String name,String number){
        flightRepository.updateNoTickets(name, number);
    }

    public void display(){
        for(Flight flight: flightRepository.allFlights()){
            System.out.println(flight.toString());
        }
    }
}
