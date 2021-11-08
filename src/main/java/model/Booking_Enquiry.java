package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking_Enquiry implements Comparable<Booking_Enquiry>{

    private int id;
    private String title;
    private String description;
    private String date;

    public Booking_Enquiry(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.getId()+","+this.getTitle()+","+this.getDescription()+","+this.getDate();
        return text;
    }

    @Override
    public boolean equals(Object obj){
        Booking_Enquiry booking_enquiry=(Booking_Enquiry) obj;
                return booking_enquiry.getId()==this.getId();
    }

    @Override
    public int compareTo(Booking_Enquiry booking_enquiry){
        return this.getDate().compareTo(booking_enquiry.getDate());
    }


}
