import DataAccess.abstracts.Database;
import DataAccess.concretes.MySQL;
import DataAccess.concretes.Oracle;
import DataAccess.concretes.PostgreSQL;
import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products= new ArrayList<>();


        // Database myOracle= new Oracle(products);
        // myOracle.connection();

        Database mysql= new MySQL(products);      //arrayi doldurma
        mysql.connection();

        Database myPostgre= new PostgreSQL(products);       //arrayi postgreye atma
        myPostgre.connection();



    }
}