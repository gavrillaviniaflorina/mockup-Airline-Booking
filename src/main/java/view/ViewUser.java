package view;

import controller.*;
import model.Person;
import model.Ticket;

import java.util.List;
import java.util.Scanner;

public class ViewUser {
    private Scanner scanner;
    private Person person;
    private AirlineBookingController airlineBookingController;
    private TicketController ticketController;
    private FlightController flightController;
    private PersonController personController;
    private PassengerController passengerController;

    public ViewUser(Person person) {
        this.person = person;
        this.scanner=new Scanner(System.in);
        this.personController=new PersonController();
        this.airlineBookingController=new AirlineBookingController();
        this.flightController=new FlightController();
        this.ticketController=new TicketController();
        this.passengerController=new PassengerController();
    }

    private String meniu()
    {
        String text="";
        text+="Press 0 to log out\n";
        text+="Press 1 to see all your tickets\n";
        text+="Press 2 to search a flight \n";
        text+="Press 3 to change your password\n";
        text+="Press 4 to book a ticket\n";
        text+="Press 5 to buy a ticket\n";

        return text;


    }
    public void play(){

    }

    private void allTickets(){
        System.out.println("Please write your name");
        String name=scanner.nextLine();
        Person person= personController.personName(name);
        if(person.getId()==1){
            System.out.println("Incorrect name");
        }else{
            List<Ticket> ticketList=ticketController.passengerTicket(passengerController.personPassenger(person.getId()));
            if(ticketList.isEmpty()){
                System.out.println("You don't have any tickets");
            }else{

            for(Ticket ticket:ticketList) {
                System.out.println(ticket);
            }
            }
        }
    }


}


