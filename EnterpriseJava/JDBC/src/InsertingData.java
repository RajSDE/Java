import java.sql.*;

public class InsertingData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/rajdatabase";
            String username = "root";
            String password = "root123";

            Connection con = DriverManager.getConnection(url, username, password);

            String queryInsert = "insert into myinfo(First_Name,Last_Name) values (?,?)";

            PreparedStatement pstmt = con.prepareStatement(queryInsert);
            
            pstmt.setString(1, "Raj");
            pstmt.setString(2, "Singh");
            
            pstmt.executeUpdate();
            System.out.println("Data Inserted successfully...");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
