package DataAccess.concretes;

import DataAccess.abstracts.Database;
import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class PostgreSQL implements Database {

    private User user=new User();
    List<User> users;
    public PostgreSQL(List<User>  users) {
        System.out.println("PostgreSQL DB");
        this.users=users;
    }

    @Override
    public void connection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/user","postgres","12345");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("Select* FROM user_table");

            while(resultSet.next()){
                User user=new User();

                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);


            }

        }catch (Exception e){
            System.out.println(e.getMessage());        }

    }
}
