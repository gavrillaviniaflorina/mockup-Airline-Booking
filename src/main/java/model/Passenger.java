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


    public Passenger(String name,String email,String password, String address,String mobile,String role) {
      super(name,email,password,address,role);
        this.mobile = mobile;

    }




    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getName()+","+this.getMobile()+","+this.getEmail()+","+this.getPassword()+","+this.getAddress();
        return text;
    }

    @Override

    public boolean equals(Object obj){
        Passenger passenger=(Passenger) obj;
        return passenger.getId()==this.getId();
    }


}
