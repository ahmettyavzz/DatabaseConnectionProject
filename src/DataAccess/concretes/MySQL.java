package DataAccess.concretes;

import DataAccess.abstracts.Database;
import Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class MySQL implements Database {
    private User user=new User();
    List<User> users;
    public MySQL(List<User>  users) {
        System.out.println("MYSQL DB");
        this.users=users;
    }

    @Override
    public void connection() {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat-app-db","root","prolab");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("Select* FROM user_table");

            while(resultSet.next()){
                User user=new User();

                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);

                System.out.println(resultSet.getString("username"));

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
