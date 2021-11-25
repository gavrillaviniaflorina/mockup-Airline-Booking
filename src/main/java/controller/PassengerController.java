package controller;

import model.Passenger;
import repository.PassengerRepository;

public class PassengerController {

    private PassengerRepository passengerRepository;

    public PassengerController() {

        this.passengerRepository= new PassengerRepository();
    }

    public void insert(Passenger passenger){
        passengerRepository.insert(passenger);
    }

    public void delete(String name){
        passengerRepository.delete(name);
    }

    public void updateMobile( String name,String mobile){
        passengerRepository.updateMobile(name, mobile);
    }

    public void updateEmail( String name,String email){
        passengerRepository.updateEmail(name, email);
    }

    public void updateAddress( String name,String address){
        passengerRepository.updateAddress(name, address);
    }

    public void dispaly(){

        for(Passenger passenger: passengerRepository.allPassengers()){
            System.out.println(passenger.toString());
        }
    }

    public int personPassenger(int person_id){
        for(Passenger passenger: passengerRepository.allPassengers()){
            if(passenger.getPerson_id()==person_id){
                return passenger.getPerson_id();
            }
        }
        return -1;
    }
}
