package controller;

import model.Flight;
import repository.FlightRepository;

import java.util.ArrayList;
import java.util.List;

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

    public void updateNoTickets( String name,int number){
        flightRepository.updateNoTickets(name, number);
    }

    public void display(){
        for(Flight flight: flightRepository.allFlights()){
            System.out.println(flight.toString());
        }
    }

    public Flight flightId(int id){
        for(Flight flight: flightRepository.allFlights()){
            if(flight.getId()==id){
                return flight;
            }
        }
        return new Flight(-1,"",-1,"",-1);
    }

    public List<Flight> allFlights(){
        return flightRepository.allFlights();
    }

    public List<Flight> searchFlight(String name){
        List<Flight> flightList=new ArrayList<>();
        for(Flight flight:flightRepository.allFlights()){
            if(flight.getName().equals(flight)){
                flightList.add(flight);
            }
        }
        return flightList;
    }
}
