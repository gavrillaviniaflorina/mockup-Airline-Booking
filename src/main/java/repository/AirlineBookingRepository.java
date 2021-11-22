package repository;
import model.Airline_Booking;
import model.Passenger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AirlineBookingRepository {


    private String JdbcURl="jdbc:mysql://localhost:3306/airline";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public AirlineBookingRepository(){
        try {
            connection = DriverManager.getConnection(JdbcURl, username, password);
            statement = connection.createStatement();
            // System.out.println("S-a conectat");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void executeStatement(String execute){

        try{
            statement.execute(execute);

        }catch (SQLException e){
            System.out.println("Nu am reusit "+ execute);
        }
    }

    public void insert(Airline_Booking airlineBooking){
        String insert="";
        insert+="insert into airline_booking ( description,title,person_id,date) values (";
        insert+=String.format("'%s','%s',%d,'%s",airlineBooking.getDescription(),airlineBooking.getTitle(),airlineBooking.getPerson_id(),airlineBooking.getDate());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(String id){
        String delete="";
        delete+=String.format("delete from airline_booking where id=%d",id);
        delete+=";";
        executeStatement(delete);
    }

    public void updateDescription( String title,String description){

        String update="";
        update+=String.format("update airline_booking set description='%s'",description);
        update+=String.format("where title='%s'",title);
        executeStatement(update);
    }


    public void updateTitle( String old,String title){

        String update="";
        update+=String.format("update airline_booking set title='%s'",title);
        update+=String.format("where title='%s'",old);
        executeStatement(update);
    }

    public void updateDate( String title,String date){

        String update="";
        update+=String.format("update airline_booking set date='%s'",date);
        update+=String.format("where title='%s'",title);
        executeStatement(update);
    }

    private ResultSet all(){

        executeStatement("select * from airline_booking");


        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Airline_Booking> allBookings(){

        ResultSet set=all();
        List<Airline_Booking> booking=new ArrayList<>();
        try{
            while(set.next()){
               booking.add(new Airline_Booking(set.getString(1),set.getString(2),set.getString(3),set.getInt(4)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return booking;
    }

}
