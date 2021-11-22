package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Flight implements Comparable<Flight> {

    private int id;
    private String Name;
    private int duration;
    private String date;
    private int noTickets;

    public Flight(String name, int duration, String date, int noTickets) {
        Name = name;
        this.duration = duration;
        this.date = date;
        this.noTickets = noTickets;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getName()+","+this.getDuration()+","+this.getDate()+","+this.getNoTickets();
        return text;

    }

    @Override
    public boolean equals(Object obj){
       Flight flight=(Flight) obj;
        return flight.getId()==this.getId();

    }

    @Override
    public  int compareTo(Flight flight){
        return this.getName().compareTo(flight.getName());
    }

}
