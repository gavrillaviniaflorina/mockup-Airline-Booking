package repository;


import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/airline";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public UserRepository(){
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

    public void insert(User user){
        String insert="";
        insert+="insert into user (role_id, name, email, adress) values (";
        insert+=String.format("%d,'%s','%s','%s'",user.getRole_id(),user.getName(),user.getEmail(),user.getAdress());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(String name){
        String delete="";
        delete+=String.format("delete form user where name='%s'");
        delete+=";";
        executeStatement(delete);


    }

    public void updateRoleId(String name, int role_id){
        String update="";
        update+=String.format("update user set role_id=%d",role_id);
        update+=String.format("where name='%s'",name);
        executeStatement(update);
    }

    public void updateNewRoleId(int old_role, int role_id){
        String update="";
        update+=String.format("update user set role_id=%d",role_id);
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

    public List<User> allUsers(){

        ResultSet set=all();
        List<User> users=new ArrayList<>();
        try{
            while(set.next()){
                users.add(new User(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4), set.getString(5)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return users;
    }
}
