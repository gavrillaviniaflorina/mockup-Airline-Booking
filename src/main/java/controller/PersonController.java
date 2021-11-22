package controller;

import model.Person;
import repository.PersonRepository;

public class PersonController {

    private PersonRepository personRepository;

    public PersonController() {

        personRepository=new PersonRepository();
    }

    public void insert(Person person){

        personRepository.insert(person);

    }

    public void delete(Person person){
        personRepository.delete(person.getName());
    }

    public void updateRole(String name, String role){
        personRepository.updateRole(name,role);
    }

    public void  updateNewRole(String old_role, String role){
        personRepository.updateNewRole(old_role, role);
    }

    public void updateAddress(String name, String address){
        personRepository.updateAddress(name,address);
    }

    public void display(){
        for(Person person: personRepository.allPersons()){
            System.out.println(person.toString());
        }
    }
}
