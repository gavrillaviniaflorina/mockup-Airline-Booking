package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airline_Booking implements Comparable<Airline_Booking>{

    private int id;
    private String description;
    private String title;
    private String date;
    private int passenger_id;


    public Airline_Booking(String description, String title, String date, int passenger_id) {
        this.description = description;
        this.title = title;
        this.date = date;
        this.passenger_id = passenger_id;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getDescription()+","+this.getTitle()+","+this.getDate()+","+this.getPassenger_id();
        return text;
    }

    @Override
    public boolean equals(Object obj){
        Airline_Booking airline_booking=(Airline_Booking) obj;
        return airline_booking.getId()==this.getId();

    }

    @Override
    public int compareTo(Airline_Booking airline_booking){
        return this.getTitle().compareTo(airline_booking.getTitle());
    }


}
