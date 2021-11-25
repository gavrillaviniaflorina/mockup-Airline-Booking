package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Person;
import lombok.RequiredArgsConstructor;

import javax.swing.plaf.basic.BasicComboBoxUI;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger extends Person  {
    private int id;
    private String  mobile;
    private int person_id;


    public Passenger(String name,String email,String password, String address,String mobile,String role,int person_id) {
      super(name,email,password,address,role);
        this.mobile = mobile;
        this.person_id=person_id;

    }




    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getName()+","+this.getMobile()+","+this.getEmail()+","+this.getPassword()+","+this.getAddress()+","+this.getPerson_id();
        return text;
    }

    @Override

    public boolean equals(Object obj){
        Passenger passenger=(Passenger) obj;
        return passenger.getId()==this.getId();
    }


}
