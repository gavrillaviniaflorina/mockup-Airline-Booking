package controller;

import model.Ticket;
import repository.TicketRepository;

public class TicketController {

    private TicketRepository ticketRepository;

    public TicketController() {

        this.ticketRepository=new TicketRepository();
    }
    public void insert(Ticket ticket){
        ticketRepository.insert(ticket);
    }

    public void delete(String id){
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
}
