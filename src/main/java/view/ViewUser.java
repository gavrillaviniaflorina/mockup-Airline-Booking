package view;

import controller.AirlineBookingController;
import controller.FlightController;
import controller.PersonController;
import model.Person;

import java.util.Scanner;

public class ViewUser {
    private Scanner scanner;
    private Person person;
    private AirlineBookingController airlineBookingController;
    private FlightController flightController;
    private PersonController personController;

    public ViewUser(Person person) {
        this.person = person;
        this.scanner=new Scanner(System.in);
        this.personController=new PersonController();
        this.airlineBookingController=new AirlineBookingController();
        this.flightController=new FlightController();
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


}


