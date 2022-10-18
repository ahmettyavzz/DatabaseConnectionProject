package DataAccess.concretes;

import DataAccess.abstracts.Database;
import Model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


public class Oracle implements Database {

    List<Product> products;
    public Oracle(List<Product>  products) {
        System.out.println("Oracle DB");
        this.products=products;
    }
    @Override
    public void connection() {
        try{
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//89.252.189.203:1521/orcl","HEDEFLIMSJSELF","Omreon789");
            Statement statement=connection.createStatement();

             ResultSet resultSet=statement.executeQuery("SELECT * FROM HEDEFLIMSJSELF.CAMPAIGN");

            while(resultSet.next()){
                Product products1=new Product();

                products1.setProductId(resultSet.getInt("ID"));
                products1.setProductName(resultSet.getString("FIRST_PARAM"));
                products1.setCategory(resultSet.getString("SECOND_PARAM"));
                products.add(products1);



            }

         //   System.out.println("basarili");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
