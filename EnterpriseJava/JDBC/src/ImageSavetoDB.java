import java.sql.*;
import java.io.*;

public class ImageSavetoDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdatabase", "root", "root123");
            // create table iamges(id int primary key auto_increment, pic blog);
            // blog -- binary large object
            
            String query = "insert into images(pic) value(?)";

            PreparedStatement pstmt = con.prepareStatement(query);
            FileInputStream files = new FileInputStream("pic.png");

            pstmt.setBinaryStream(1,files, files.available());
            pstmt.executeUpdate();

            System.out.println("Done...");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
