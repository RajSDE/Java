import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class UpdateData {
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdatabase", "root", "root123");

            String query = "update myinfo set First_Name=?, Last_Name=? where uID=?";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Enter First Name: ");
            String fname = br.readLine();

            System.out.print("Enter Last Name: ");
            String lname = br.readLine();

            System.out.print("Enter the user Id: ");
            int id = Integer.parseInt(br.readLine());

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();
            System.out.println("Changes Done...");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
