package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.swing.plaf.basic.BasicComboBoxUI;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Permission implements Comparable<Permission>{

    private int id;
    private int role_id;
    private String title;
    private String description;

    public Permission(int role_id, String title, String description) {
        this.role_id = role_id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getRole_id()+","+this.getRole_id()+","+this.getTitle()+","+this.getDescription();
        return text;
    }

    @Override
    public boolean equals(Object obj){
        Permission permission=(Permission) obj;
        return this.getId()==permission.getId();
    }

    @Override
    public int compareTo(Permission permission){
        if(this.getTitle().compareTo(permission.getTitle())==1){
            return 1;
        }else if(this.getTitle().compareTo(permission.getTitle())==-1){
            return -1;
        }else{
            return 0;
        }
    }
}
