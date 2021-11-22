package repository;
import model.Ticket;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TicketRepository {
    private String JdbcURl="jdbc:mysql://localhost:3306/airline";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public TicketRepository(){
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

    public void insert(Ticket ticket){
        String insert="";
        insert+="insert into ticket (description, customer_id, date) values (";
        insert+=String.format("'%s',%d,'%s'",ticket.getDescription(),ticket.getPassenger_id(),ticket.getDate());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(String id){
        String delete="";
        delete+=String.format("delete form ticket where id=%d");
        delete+=";";
        executeStatement(delete);


    }

    public void updateDescription(int id, String description){
        String update="";
        update+=String.format("update ticket set description='%s'",description);
        update+=String.format("where id=%d",id);
        executeStatement(update);
    }

    public void updateCustomerId(int id, int customer_id){
        String update="";
        update+=String.format("update ticket set customer_id=%d",customer_id);
        update+=String.format("where id=%d",id);
        executeStatement(update);
    }

    public void updateNewCustomerId(int old, int customer_id){
        String update="";
        update+=String.format("update ticket set customer_id=%d",customer_id);
        update+=String.format("where customer_id=%d",old);
        executeStatement(update);
    }

    public void updateDate(int id, String date){
        String update="";
        update+=String.format("update ticket set date='%s'",date);
        update+=String.format("where id=%d",id);
        executeStatement(update);
    }

    public void updateNewDate(String old, String date){
        String update="";
        update+=String.format("update ticket set date='%s'",date);
        update+=String.format("where date='%s'",old);
        executeStatement(update);
    }

    private ResultSet all(){

        executeStatement("select * from ticket");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Ticket> allTickets(){

        ResultSet set=all();
        List<Ticket> tickets=new ArrayList<>();
        try{
            while(set.next()){
                tickets.add(new Ticket(set.getString(1),set.getInt(2),set.getString(3)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return tickets;
    }


}
