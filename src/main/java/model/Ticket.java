package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor


public class Ticket implements Comparable<Ticket> {

    private int id;
    private String description;
    private int customer_id;
    private String date;

    public Ticket(String description, int customer_id, String date) {
        this.description = description;
        this.customer_id = customer_id;
        this.date = date;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getDescription()+","+this.getCustomer_id()+","+this.getDate();
        return text;
    }

    @Override
    public boolean equals(Object obj){
        Ticket ticket=(Ticket) obj;
        return this.getId()==ticket.getId();
    }

    @Override
    public int compareTo(Ticket ticket){
        if(ticket.getDate().compareTo(ticket.getDate())==1){
            return 1;
        }else if(ticket.getDate().compareTo(ticket.getDate())==-1){
            return -1;
        }else{
            return 0;
        }
    }

}
