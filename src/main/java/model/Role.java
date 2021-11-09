package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor


public class Role implements Comparable<Role> {

    private int id;
    private String title;
    private String description;

    public Role(String role_title, String description) {
        this.title = role_title;
        this.description = description;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getTitle()+","+this.getDescription();
        return text;
    }

    @Override
    public boolean equals(Object obj){
        Role role=(Role) obj;
        return role.getId()==this.getId();
    }

    @Override
    public int compareTo(Role role){
        if(this.getTitle().compareTo(role.getTitle())==1) {
            return 1;
        }else if(this.getTitle().compareTo(role.getTitle())==-1){
                    return -1;
                }else{
            return 0;
        }
    }


}
