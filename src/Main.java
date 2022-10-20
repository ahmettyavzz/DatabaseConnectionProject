import DataAccess.abstracts.Database;
import DataAccess.concretes.MySQL;
import DataAccess.concretes.Oracle;
import DataAccess.concretes.PostgreSQL;
import export.ExcelWrite;
import Model.Product;
import export.FileWrite;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products= new ArrayList<>();


         Database myOracle= new Oracle(products);   //listi oracle ile doldurma
         myOracle.connection();

        Database mysql= new MySQL(products);      //listi mysql ile doldurma
        mysql.connection();

        Database myPostgre= new PostgreSQL(products);       //listi postgreye atma
        myPostgre.connection();


        FileWrite excelWrite= new ExcelWrite();     //postgredeki veriyi filea atma
        excelWrite.push();


    }
}