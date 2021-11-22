package controller;

import model.Airline_Booking;
import repository.AirlineBookingRepository;

public class AirlineBookingController {

    private AirlineBookingRepository airlineBookingRepository;

    public AirlineBookingController() {

        this.airlineBookingRepository=new AirlineBookingRepository();

    }

    public void insert(Airline_Booking airlineBooking){
        airlineBookingRepository.insert(airlineBooking);
    }

    public void delete(String id){
        airlineBookingRepository.delete(id);
    }

    public void updateDescription( String title,String description){
        airlineBookingRepository.updateDescription(title, description);
    }

    public void updateTitle( String old,String title){
        airlineBookingRepository.updateTitle(old, title);
    }

    public void updateDate( String title,String date){
        airlineBookingRepository.updateDate(title,date);
    }

    public void display(){
        for(Airline_Booking airlineBooking: airlineBookingRepository.allBookings()){
            System.out.println(airlineBooking.toString());
        }
    }
}
