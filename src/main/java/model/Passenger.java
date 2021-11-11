package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.swing.plaf.basic.BasicComboBoxUI;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger implements Comparable<Passenger> {
    private int id;
    private String name;
    private String  mobile;
    private String email;
   // private String username;
    private String password;
    private String address;

    public Passenger(String name, String mobile, String email,  String password, String address) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
       // this.username = username;
        this.password = password;
        this.address = address;
    }



    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getName()+","+this.getName()+","+this.getMobile()+","+this.getEmail()+","+this.getPassword()+","+this.getAddress();
        return text;
    }

    @Override

    public boolean equals(Object obj){
        Passenger passenger=(Passenger) obj;
        return passenger.getId()==this.getId();
    }

    @Override
    public int compareTo(Passenger passenger){
        return this.getName().compareTo(passenger.getName());
    }
}
