package controller;

import model.Ticket;
import repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

public class TicketController {

    private TicketRepository ticketRepository;

    public TicketController() {

        this.ticketRepository=new TicketRepository();
    }
    public void insert(Ticket ticket){
        ticketRepository.insert(ticket);
    }

    public void delete(int id){
        ticketRepository.delete(id);
    }

    public void updateDescription(int id, String description){
        ticketRepository.updateDescription(id,description);
    }

    public void updateCustomerId(int id, int passenger_id){
        ticketRepository.updateNewPassengerId(id,passenger_id);
    }

    public void updateDate(int id, String date){
        ticketRepository.updateDate(id,date);
    }

    public void updateNewDate(String old, String date){
        ticketRepository.updateNewDate(old, date);
    }

    public void display(){
        for(Ticket ticket: ticketRepository.allTickets()){
            System.out.println(ticket.toString());
        }
    }

    public Ticket ticketId(int id){
        for(Ticket ticket: ticketRepository.allTickets()) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
                return new Ticket(-1,"",-1,"");


    }

    public List<Ticket> allTickets(){
        return ticketRepository.allTickets();
    }

    public List<Ticket> passengerTicket(int id){
        List<Ticket> ticketList=new ArrayList<>();
        for(Ticket ticket:allTickets()){
            if(ticket.getPassenger_id()==id){
                ticketList.add(ticket);

            }
        }
        return ticketList;
    }
}
