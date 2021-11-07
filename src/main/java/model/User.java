package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements Comparable<User> {
 private int id;
 private int role_id;
 private String name;
 private String email;
 private String adress;


    public User(int role_id, String name, String email, String adress) {
        this.role_id = role_id;
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getRole_id()+","+this.getName()+","+this.getEmail()+","+this.getAdress();
        return text;
    }

    @Override
    public boolean equals(Object obj){
        User user=(User)obj;
       return user.getId()==this.getId();

    }

    @Override
    public int compareTo(User user){
        if(this.getName().compareTo(user.getName())==1){
            return 1;
        }else if(this.getName().compareTo(user.getName())==-1){
            return -1;
        }
        return 0;

    }
}
