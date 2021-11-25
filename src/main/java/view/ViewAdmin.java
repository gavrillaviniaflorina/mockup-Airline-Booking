package view;

import controller.FlightController;
import controller.PersonController;
import controller.TicketController;
import model.Flight;
import model.Person;
import model.Ticket;

import java.util.List;
import java.util.Scanner;

public class ViewAdmin {

    private Person person;
    private Scanner scanner;
    private PersonController personController;
    private TicketController ticketController;
    private FlightController flightController;


    public ViewAdmin(Person person) {
        this.person = person;
        this.scanner=new Scanner(System.in);
        this.personController=new PersonController();
        this.ticketController=new TicketController();
        this.flightController=new FlightController();
    }

    private String meniu()
    {
        String text="";
        text+="Press 0 to log out\n";
        text+="Press 1 to add a person\n";
        text+="Press 2 to change a person's role\n";
        text+="Press 3 to delete a person \n";
        text+="Press 4 to add a ticket\n";
        text+="Press 45to change the passenger id of a ticket\n";
        text+="Press 6 to delete a ticket\n";
        text+="Press 7 to add a flight\n";
        text+="Press 8 to delete a flight\n";
        text+="Press 9 to change the duration of a flight\n";
        text+="Press 10 to change the number of tickets of a flight\n";
        text+="Press 11 to see al the persons\n";
        text+="Press 12 to see al the tickets\n";
        text+="Press 13 to see al the flights\n";



        return text;


    }


    public void play(){


        System.out.println(meniu());
        boolean run=true;
        while(run==true){
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 0:
                run=false;
                break;
                case 1:
                    insertPerson();
                    break;
                case 2:
                    updateRolePerson();
                    break;
                case 3:
                    deletePerson();
                    break;
                case 4:
                    insertTicket();
                    break;
                case 5:
                    updateTicket();
                    break;
                case 6:
                    deleteTicket();
                    break;
                case 7:
                    insertFlight();
                    break;
                case 8:
                    deleteFlight();
                    break;
                case 9:
                    updateFlight();
                    break;
                case 10:
                    displayPerson();
                    break;

                case 11:
                    displayTicket();
                    break;
                case 12:
                    displayTicket();
                    break;
                default:
                    meniu();
                    break;





            }
        }

    }


    public void insertPerson(){

        String email="";
        System.out.println("Please add the name");
        String name =scanner.nextLine();
        System.out.println("Please add the role");
        String role=scanner.nextLine();


        int ok=0;
        while (ok==0) {
            System.out.println("Please add the email");
           email=scanner.nextLine();
            if (personController.personEmail(email).getId() != -1) {
                System.out.println("This email is used!");
            }else{
                ok=1;
            }
        }

        System.out.println("Please add the password");
        String password=scanner.nextLine();

        System.out.println("Please add the address");
        String address=scanner.nextLine();


        Person person1=new Person(name,email,password,address,role);
        personController.insert(person1);
        System.out.println("The person was added");
    }

    public void updateRolePerson(){
        System.out.println("Please introduce the name");
        String name=scanner.nextLine();

        if(personController.personName(name).getId()==-1){
            System.out.println("This name does not exist");
        }else{
            System.out.println("Please write the new role");
            String role=scanner.nextLine();
            personController.updateRole(name, role);
            System.out.println("The role was changed");
        }

    }

    public void deletePerson(){
        System.out.println("Please write the name of the person you want to delete");
        String name=scanner.nextLine();
        if(personController.personName(name).getId()==-1){
            System.out.println("This name does not exist");
        }else {

            personController.delete(name);
            System.out.println("The person was deleted");
        }
        }

    public void insertTicket(){

        System.out.println("Please add the description");
        String desc=scanner.nextLine();

        System.out.println("Please add the date");
        String date=scanner.nextLine();

        System.out.println("Please add the passenger id");
        int id=Integer.parseInt(scanner.nextLine());

        Ticket ticket=new Ticket(desc,id,date);

        ticketController.insert(ticket);
        System.out.println("The ticket was added");
    }

    public void updateTicket(){
        System.out.println("Please write the id of the ticket");
        int id=Integer.parseInt(scanner.nextLine());
        if(ticketController.ticketId(id).getId()==-1){
            System.out.println("The ticket does not exist!");
        }else{
            System.out.println("Please write the new passenger id");
            int pId=Integer.parseInt(scanner.nextLine());
            ticketController.updateCustomerId(id,pId);
            System.out.println("The ticket was updated");
        }
    }

    public void deleteTicket(){
        System.out.println("Please write the id of the ticket");
        int id=Integer.parseInt(scanner.nextLine());
        if(ticketController.ticketId(id).getId()==-1){
            System.out.println("The ticket does not exist!");
        }else {
            ticketController.delete(id);
            System.out.println("The ticket was deleted");

        }
        }

    public void insertFlight(){
        System.out.println("Please add the name");
        String name=scanner.nextLine();

        System.out.println("Please add the duration");
        int duration=Integer.parseInt(scanner.nextLine());

        System.out.println("Please add the date");
        String date=scanner.nextLine();

        System.out.println("Please add the number of tickets");
        int no=Integer.parseInt(scanner.nextLine());

        flightController.insert(new Flight(name ,duration, date ,no));
        System.out.println("The flight was added");
    }

    public void deleteFlight(){
        System.out.println("Please write the id of the flight");
        int id=Integer.parseInt(scanner.nextLine());
        if(flightController.flightId(id).getId()==-1){
            System.out.println("The flight does not exist!");
        }else{
            flightController.delete(flightController.flightId(id).getName());
        }
    }

    public void updateFlight(){
        System.out.println("Please write the id of the flight");
        int id=Integer.parseInt(scanner.nextLine());
        if(flightController.flightId(id).getId()==-1){
            System.out.println("The flight does not exist!");
        }else{
            System.out.println("Please write the new number of tickets");
            int no=Integer.parseInt(scanner.nextLine());
            flightController.updateNoTickets(flightController.flightId(id).getName(),no);
            System.out.println("The number of tickets was updated");
        }
    }

    public void displayPerson(){

        List<Person> personList=personController.allPersons();
        for(Person person:personList){
            System.out.println(person.toString());
        }

    }

    public void displayFlight(){
        List<Flight> flightList=flightController.allFlights();
        for(Flight flight:flightList){
            System.out.println(flight.toString());
        }
    }

    public void displayTicket(){
        List<Ticket> ticketList=ticketController.allTickets();
        for(Ticket ticket:ticketList){
            System.out.println(ticket.toString());
        }
    }
    }



