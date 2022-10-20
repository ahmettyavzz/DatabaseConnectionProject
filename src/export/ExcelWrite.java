package export;

import Model.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ExcelWrite implements FileWrite{
    private static final String url="C:\\Users\\ahmet yavuz\\Desktop\\fromGlobalUser.xlsx";
    XSSFWorkbook wb= new XSSFWorkbook();
    XSSFSheet cs= wb.createSheet("from postgre");

    int rowNo=0;
    int columnNo=0;
    public void push()  {



            try{
                Connection connection = DriverManager.getConnection("jdbc:postgresql://89.252.189.2:5432/global_user","postgres","imoh");
                Statement statement=connection.createStatement();
                ResultSet resultSet=statement.executeQuery("Select* FROM products");


                while(resultSet.next()){

                    Row row= cs.createRow(rowNo++);


                    Cell id = row.createCell(columnNo++);
                    id.setCellValue( resultSet.getInt("id"));

                    Cell productId = row.createCell(columnNo++);
                    productId.setCellValue( resultSet.getInt("product_id"));

                    Cell productName = row.createCell(columnNo++);
                    productName.setCellValue( resultSet.getString("product_name"));

                    Cell category = row.createCell(columnNo++);
                    category.setCellValue(resultSet.getString("category") );
                    columnNo=0;

                }
            } catch (Exception e){
                e.printStackTrace();
            }

        try {
            FileOutputStream data= new FileOutputStream(url);
            wb.write(data);
            wb.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
