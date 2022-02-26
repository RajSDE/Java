import java.sql.*;
public class ConnectionJDBC {
    public static void main(String[] args){
        try{
            //  Load the Driver
            Class.forName("com.mysql.jdbc.Driver");
            //  Creating a connection
            String url="jdbc:mysql://localhost:3306/rajdatabase";
            String username="root";
            String password="root123";
            Connection con = DriverManager.getConnection(url,username,password);
            if(con.isClosed()){
                System.out.println("Connection is closed....");
            }else{
                System.out.println("Connection Created....");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
