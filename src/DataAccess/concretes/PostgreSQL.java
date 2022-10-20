package DataAccess.concretes;

import DataAccess.abstracts.Database;
import Model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class PostgreSQL implements Database {

    List<Product> products;
    public PostgreSQL(List<Product>  products) {
        System.out.println("PostgreSQL DB");
        this.products=products;
    }

    @Override
    public void connection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://89.252.189.2:5432/global_user","postgres","imoh");


            for (int i=0;i<products.size();i++){
                String sql=String.format("insert into %s(product_id,product_name,category) VALUES ('%s','%s','%s');","products"
                        ,products.get(i).getProductId(),products.get(i).getProductName(),products.get(i).getCategory());
                Statement statement=connection.createStatement();
                statement.execute(sql);
            }



        }catch (Exception e){
            System.out.println(e.getMessage());        }

    }
}
