package repository;

import model.Flight;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightRepositoryTest {

    @Test public void TestInsert(){
        Flight flight1=new Flight("NewYork-LosAngeles",120,"22/11/2021",100);
        Flight flight2=new Flight("Paris-London",60,"22/11/2021",200);
        Flight flight3=new Flight("Seol-Tokyo",180,"22/11/2021",500);


        FlightRepository flightRepository=new FlightRepository();
        flightRepository.insert(flight1);
        flightRepository.insert(flight2);
        flightRepository.insert(flight3);

        List<Flight> flightList=flightRepository.allFlights();

        assertEquals(true,flightList.contains(flight1));
        assertEquals(true,flightList.contains(flight2));
        assertEquals(true,flightList.contains(flight3));
    }

}