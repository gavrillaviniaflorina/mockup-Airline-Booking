package view;

import controller.FlightController;
import controller.PersonController;
import controller.TicketController;
import model.Person;

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
        text+="Press 3 to add a ticket\n";
        text+="Press 4 to change the passenger id of a ticket\n";
        text+="Press 5 to delete a ticket\n";
        text+="Press 6 to add a flight\n";
        text+="Press 7 to delete a flight\n";
        text+="Press 8 to change the duration of a flight\n";
        text+="Press 9 to change the duration of a flight\n";
        text+="Press 10 to change the number of tickets of a flight\n";



        return text;


    }


    public void play(){

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

    }
}
