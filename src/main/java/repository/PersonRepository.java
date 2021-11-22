package repository;


import model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PersonRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/airline";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public PersonRepository(){
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

    public void insert(Person person){
        String insert="";
        insert+="insert into person (role_id, name, email, adress) values (";
        insert+=String.format("'%s','%s','%s',%d",person.getName(),person.getEmail(),person.getAdress(),person.getRole());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(String name){
        String delete="";
        delete+=String.format("delete form person where name='%s'");
        delete+=";";
        executeStatement(delete);


    }

    public void updateRoleId(String name, String role){
        String update="";
        update+=String.format("update person setrole='%s'",role);
        update+=String.format("where name='%s'",name);
        executeStatement(update);
    }

    public void updateNewRoleId(String old_role, String role){
        String update="";
        update+=String.format("update person set role='%s",role);
        update+=String.format("where role=%d",old_role);
        executeStatement(update);
    }

    public void updateAddress(String name, String address){
        String update="";
        update+=String.format("update user set address='%s'",address);
        update+=String.format("where name='%s'",name);
        executeStatement(update);
    }

    private ResultSet all(){

        executeStatement("select * from user");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Person> allUsers(){

        ResultSet set=all();
        List<Person> users=new ArrayList<>();
        try{
            while(set.next()){
                users.add(new Person(set.getInt(1),set.getString(2),set.getString(3), set.getString(4),set.getString(5)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return users;
    }
}
