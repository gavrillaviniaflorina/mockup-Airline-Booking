package repository;

import model.Passenger;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassengerRepositoryTest {

    @Test
    public void testInsert(){
        Passenger passenger1=new Passenger("Mary Jane","e@gamil.com","qwe123","str1","0722","admin");

        PassengerRepository passengerRepository=new PassengerRepository();
        passengerRepository.insert(passenger1);

        List<Passenger> passengerList=passengerRepository.allPassengers();
        assertEquals(true,passengerList.contains(passenger1));
    }

}