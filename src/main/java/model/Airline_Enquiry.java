package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airline_Enquiry implements Comparable<Airline_Enquiry>{

    private int id;
    private String type;
    private String title;
    private String description;
    private String date;

    public Airline_Enquiry(String type, String title, String description, String date) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getType()+","+this.getTitle()+","+this.getDescription()+","+this.getDate();
        return text;
    }

    @Override
    public boolean equals(Object obj){
        Airline_Enquiry airline_enquiry=(Airline_Enquiry) obj;
        return airline_enquiry.getId()==this.getId();
    }

    @Override
    public int compareTo(Airline_Enquiry airline_enquiry){
        return this.getTitle().compareTo(airline_enquiry.getTitle());
    }
}
