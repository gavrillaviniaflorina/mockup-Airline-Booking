package repository;



import model.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class FlightRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/airline";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public FlightRepository(){
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

    public void insert(Flight flight){
        String insert="";
        insert+="insert into flight (name,duration, date,noTickets) values (";
        insert+=String.format("'%s',%d,'%s',%d", flight.getName(),flight.getDuration(),flight.getDate(),flight.getNoTickets());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(String name){
        String delete="";
        delete+=String.format("delete from flight where name='%s",name);
        delete+=";";
        executeStatement(delete);
    }

    public void updateNoTickets( String name,int number){

        String update="";
        update+=String.format("update flight set noTickets=%d",number);
        update+=String.format("where name='%s'",name);
        executeStatement(update);
    }

    private ResultSet all(){

        executeStatement("select * from flight");


        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Flight> allFlights(){

        ResultSet set=all();
        List<Flight> flights=new ArrayList<>();
        try{
            while(set.next()){
               flights.add(new Flight(set.getString(1),set.getInt(2),set.getString(3),set.getInt(4)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return flights;
    }

}
