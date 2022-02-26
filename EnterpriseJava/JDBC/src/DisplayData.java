import java.sql.*;

public class DisplayData {
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdatabase", "root", "root123");

            String query = "select* from myinfo";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);

            while(set.next()){
                int id = set.getInt(1);
                System.out.print("\tID: "+id);
                String fname = set.getString(2);
                System.out.print("\tFirst Name: "+fname);
                String lname = set.getString(3);
                System.out.print("\tLast Name: "+lname);
                System.out.println();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
