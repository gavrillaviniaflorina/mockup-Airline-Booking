package repository;
import model.Permission;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PermissionRepository {
    private String JdbcURl="jdbc:mysql://localhost:3306/airline";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public PermissionRepository(){
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


    public void insert(Permission permission){
        String insert="";
        insert+="insert into permission (role_id, title, description ) values (";
        insert+=String.format("%d,'%s','%s'",permission.getRole_id(), permission.getTitle(),permission.getDescription());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(String title){
        String delete="";
        delete+=String.format("delete from permission where title='%s'",title);
        delete+=";";
        executeStatement(delete);
    }

    public void updateTitle( String old,String title){

        String update="";
        update+=String.format("update permission set title='%s'",title);
        update+=String.format("where title='%s'",old);
        executeStatement(update);
    }

    public void updateDesccription( String title,String description){

        String update="";
        update+=String.format("update permission set description='%s'",description);
        update+=String.format("where title='%s'",title);
        executeStatement(update);
    }

    private ResultSet all(){

        executeStatement("select * from permission");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Permission> allPermissions(){

        ResultSet set=all();
        List<Permission> permissions=new ArrayList<>();
        try{
            while(set.next()){
               permissions.add(new Permission(set.getInt(1),set.getString(2),set.getString(3)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return permissions;
    }
}
