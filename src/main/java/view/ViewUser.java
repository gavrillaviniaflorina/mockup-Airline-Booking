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
    }

    public void play(){

    }
}


