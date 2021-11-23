package view;

import controller.PersonController;
import model.Person;

import java.util.Scanner;

public class ViewLogin {

    private Scanner scanner;
    private PersonController personController;

    public ViewLogin() {

        this.scanner=new Scanner(System.in);
        this.personController=new PersonController();
    }

    private String meniu(){
        String text="";
        text+="Press 0 for exit\n";
        text+="Press 1 for login\n";
        return text;

    }

    private  void login(){
        System.out.println("Please select your role(adimn,user)");
        String role=scanner.nextLine();
        if(role.equals("adimn")==false && role.equals("user")==false){
            System.out.println("Invalid role");
        }else{
            System.out.println("Your email:");
            String email=scanner.nextLine();
            System.out.println("Your password");
            String password=scanner.nextLine();

            Person person= personController.personEmail(email);

            if(role.equals("admin")){
                if(person.getPassword().equals(password)==false || person.getRole().equals("admin")==false){
                    System.out.println("Incorect email or password");
                }else{
                    ViewAdmin admin=new ViewAdmin(person);
                    admin.play();
                }
            }else if(role.equals("user")){
                if(person.getPassword().equals(password)==false || person.getRole().equals("user")==false){
                    System.out.println("Incorect email or password");
                }else{
                    ViewUser user=new ViewUser(person);
                    user.play();
                }
            }
        }
    }

    public void play(){
        System.out.println(meniu());
        boolean run=true;
        while(run) {
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere) {
                case 0:
                    run = false;
                    break;
                case 1:
                    login();
                    break;
                default:
                    System.out.println(meniu());
            }
        }
    }
}


