package repository;

import model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryTest {

    @Test
    public void testInsertDelete(){
        Person person1=new Person("Mary Jane","e@gamil.com","qwe123","admin","str1");
        Person person2=new Person("Katy Perry","kp@gamil.com","qwe123","admin","str1");
        Person person3=new Person("Leonardo Dicaprio","ld@gamil.com","qwe123","admin","str1");

        PersonRepository persons=new PersonRepository();
        persons.insert(person1);
        persons.insert(person2);
        persons.insert(person3);

        List<Person> personList=persons.allPersons();
        assertEquals(true,personList.contains(person1));
        assertEquals(true,personList.contains(person2));
        assertEquals(true,personList.contains(person3));

        persons.delete(person1.getName());
        persons.delete(person2.getName());
        persons.delete(person3.getName());

        personList=persons.allPersons();
        assertEquals(false,personList.contains(person1));
        assertEquals(false,personList.contains(person2));
        assertEquals(false,personList.contains(person3));


    }
    @Test
    public void testUpdateRole(){
        Person person1=new Person("Mary Jane","e@gamil.com","qwe123","admin","str1");
        Person person2=new Person("Katy Perry","kp@gamil.com","qwe123","admin","str1");
        Person person3=new Person("Leonardo Dicaprio","ld@gamil.com","qwe123","admin","str1");

        PersonRepository persons=new PersonRepository();
        persons.insert(person1);
        persons.insert(person2);
        persons.insert(person3);

        List<Person> personList=persons.allPersons();
        assertEquals(true,personList.contains(person1));
        assertEquals(true,personList.contains(person2));
        assertEquals(true,personList.contains(person3));


        persons.updateRole(person1.getName(),"user");
        persons.updateRole(person2.getName(),"user");
        persons.updateRole(person3.getName(),"user");


       personList=persons.allPersons();
        assertEquals(true,personList.contains(person1));
        assertEquals(true,personList.contains(person2));
        assertEquals(true,personList.contains(person3));

        persons.delete(person1.getName());
        persons.delete(person2.getName());
        persons.delete(person3.getName());

        personList=persons.allPersons();
        assertEquals(false,personList.contains(person1));
        assertEquals(false,personList.contains(person2));
        assertEquals(false,personList.contains(person3));
    }

   @Test
    public void testUpdateNewRole(){
        Person person1=new Person("Mary Jane","e@gamil.com","qwe123","admin","str1");
        Person person2=new Person("Katy Perry","kp@gamil.com","qwe123","admin","str1");
        Person person3=new Person("Leonardo Dicaprio","ld@gamil.com","qwe123","admin","str1");

        PersonRepository persons=new PersonRepository();
        persons.insert(person1);
        persons.insert(person2);
        persons.insert(person3);

        List<Person> personList=persons.allPersons();
        assertEquals(true,personList.contains(person1));
        assertEquals(true,personList.contains(person2));
        assertEquals(true,personList.contains(person3));


        persons.updateNewRole(person1.getRole(),"user");
        persons.updateRole(person2.getRole(),"user");
        persons.updateRole(person3.getRole(),"user");


        personList=persons.allPersons();
        assertEquals(true,personList.contains(person1));
        assertEquals(true,personList.contains(person2));
        assertEquals(true,personList.contains(person3));

        persons.delete(person1.getName());
        persons.delete(person2.getName());
        persons.delete(person3.getName());

        personList=persons.allPersons();
        assertEquals(false,personList.contains(person1));
        assertEquals(false,personList.contains(person2));
        assertEquals(false,personList.contains(person3));
    }

   @Test
    public void testUpdateAddress(){
       Person person1=new Person("Mary Jane","e@gamil.com","qwe123","admin","str1");
       Person person2=new Person("Katy Perry","kp@gamil.com","qwe123","admin","str1");
       Person person3=new Person("Leonardo Dicaprio","ld@gamil.com","qwe123","admin","str1");

       PersonRepository persons=new PersonRepository();
       persons.insert(person1);
       persons.insert(person2);
       persons.insert(person3);

       List<Person> personList=persons.allPersons();
       assertEquals(true,personList.contains(person1));
       assertEquals(true,personList.contains(person2));
       assertEquals(true,personList.contains(person3));


       persons.updateNewRole(person1.getName(),"str2");
       persons.updateRole(person1.getName(),"str2");
       persons.updateRole(person1.getName(),"str2");


       personList=persons.allPersons();
       assertEquals(true,personList.contains(person1));
       assertEquals(true,personList.contains(person2));
       assertEquals(true,personList.contains(person3));

       persons.delete(person1.getName());
       persons.delete(person2.getName());
       persons.delete(person3.getName());

       personList=persons.allPersons();
       assertEquals(false,personList.contains(person1));
       assertEquals(false,personList.contains(person2));
       assertEquals(false,personList.contains(person3));
  }

}