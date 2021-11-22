package repository;

import model.Passenger;
import model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {

    @Test
    public void testInsertDelete(){


        Passenger passenger=new Passenger("name","email","password","address","mobile","role");

        PassengerRepository passengerRepository=new PassengerRepository();
        passengerRepository.insert(passenger);
        Ticket ticket1=new Ticket("ceva", passenger.getId(),"20/10/2021");
        Ticket ticket2=new Ticket("ceva", passenger.getId(),"20/10/2021");
        Ticket ticket3=new Ticket("ceva", passenger.getId(),"20/10/2021");

        TicketRepository ticketRepository=new TicketRepository();
        ticketRepository.insert(ticket1);
        ticketRepository.insert(ticket2);
        ticketRepository.insert(ticket3);

        List<Ticket> ticketList=ticketRepository.allTickets();
        assertEquals(true,ticketList.contains(ticket1));
        assertEquals(true,ticketList.contains(ticket1));
        assertEquals(true,ticketList.contains(ticket1));

        passengerRepository.delete(passenger.getName());
            }

}