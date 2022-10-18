package DataAccess.concretes;

import DataAccess.abstracts.Database;
import Model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class MySQL implements Database {
    List<Product> products;
    public MySQL(List<Product>  products) {
        System.out.println("MYSQL DB");
        this.products=  products;
    }

    @Override
    public void connection() {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat-app-db","root","prolab");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("Select* FROM products");

            while(resultSet.next()){
                Product product=new Product();

                product.setProductId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("products_name"));
                product.setCategory(resultSet.getString("category"));
                products.add(product);


            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
