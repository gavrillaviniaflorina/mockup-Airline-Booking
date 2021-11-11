package repository;
import model.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/airline";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public PassengerRepository(){
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

    public void insert(Passenger passenger){
        String insert="";
        insert+="insert into passenger ( name,mobile,email,password,address) values (";
        insert+=String.format("'%s','%s','%s','%s','%s'", passenger.getName(),passenger.getMobile(),passenger.getEmail(),passenger.getPassword(),passenger.getAddress());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(String name){
        String delete="";
        delete+=String.format("delete from passenger where name='%s'",name);
        delete+=";";
        executeStatement(delete);
    }

    public void updateMobile( String name,String mobile){

        String update="";
        update+=String.format("update passenger set mobile='%s'",mobile);
        update+=String.format("where name='%s'",name);
        executeStatement(update);
    }

    public void updateEmail( String name,String email){

        String update="";
        update+=String.format("update passenger set email='%s'",email);
        update+=String.format("where name='%s'",name);
        executeStatement(update);
    }

    public void updateAddress( String name,String address){

        String update="";
        update+=String.format("update passenger set address='%s'",address);
        update+=String.format("where name='%s'",name);
        executeStatement(update);
    }

    private ResultSet all(){

        executeStatement("select * from passenger");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Passenger> allPassengers(){

        ResultSet set=all();
        List<Passenger> passengers=new ArrayList<>();
        try{
            while(set.next()){
               passengers.add(new Passenger(set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return passengers;
    }

}
