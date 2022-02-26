import java.sql.*;
import java.io.*;
public class InsertDynamicInput {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/rajdatabase";
            String username = "root";
            String password = "root123";

            Connection con = DriverManager.getConnection(url, username, password);

            String queryInsert = "insert into myinfo(First_Name,Last_Name) values (?,?)";

            PreparedStatement pstmt = con.prepareStatement(queryInsert);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Enter First Name: ");
            String fname = br.readLine();
            System.out.print("Enter Last Name: ");
            String lname = br.readLine();

            
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            
            pstmt.executeUpdate();
            System.out.println("Data Inserted successfully...");

            ResultSet rs = pstmt.executeQuery("Select * from myinfo");
            while(rs.next())
            {
             System.out.print("First Name: " + rs.getString(2));
             System.out.println("\t,Last Name: " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
