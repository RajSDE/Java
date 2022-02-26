import java.sql.*;
public class CreatingTable {
    public static void main(String[] args) {
       try{
           Class.forName("com.mysql.jdbc.Driver");

           String url = "jdbc:mysql://localhost:3306/rajdatabase";
           String username = "root";
           String password = "root123";

           Connection con = DriverManager.getConnection(url, username, password);

           String q = "create table MyInfo(uID int (20) primary key auto_increment, First_Name varchar(200) not null, Last_Name varchar(50))";

           Statement stat = con.createStatement();
           stat.executeUpdate(q);
           System.out.println("Table created successfully...");
           con.close();
       }
       catch(Exception e){
           e.printStackTrace();
       } 
    }
}
