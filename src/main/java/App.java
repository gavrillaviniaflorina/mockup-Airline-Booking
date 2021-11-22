import model.Person;
import repository.PersonRepository;

import java.util.List;

public class App {

    public static void main(String[] args) {
        PersonRepository pers=new PersonRepository();
        Person person1=new Person("Jne","ne@gamil.com","qwe123","admin","str1");


pers.insert(person1);


List<Person> persons=pers.allPersons();

for(Person p:persons){
    System.out.println(p.toString());
}

    }
}
