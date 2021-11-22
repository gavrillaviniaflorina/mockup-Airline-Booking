package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person implements Comparable<Person> {
 private int id;
 private String name;
 private String email;
 private String password;
 private String address;
 private String role;


    public Person( String name, String email, String password,String address,String role) {

        this.name = name;
        this.email = email;
        this.password=password;
        this.address = address;
        this.role=role;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getName()+","+this.getEmail()+","+this.getPassword()+","+this.getAddress()+","+this.getRole();
        return text;
    }

    @Override
    public boolean equals(Object obj){
        Person user=(Person)obj;
       return user.getId()==this.getId();

    }

    @Override
    public int compareTo(Person user){
        if(this.getName().compareTo(user.getName())==1){
            return 1;
        }else if(this.getName().compareTo(user.getName())==-1){
            return -1;
        }
        return 0;

    }
}
