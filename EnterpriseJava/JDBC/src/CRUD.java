import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD{

 public static void main(String[] args) throws ClassNotFoundException, SQLException {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdatabase", "root", "root123");
  Statement st=con.createStatement(); // step-3
  //st.execute("create table demotable(abc varchar2(20),xyz varchar2(10))");// create
  
  /*int result=st.executeUpdate("insert into demotable values('abc3','xyz3')");
  if(result==1)
   System.out.println("Insertion successfull");
  else
   System.out.println("Insertion unsuccessfull");
  */
  /*int result = st.executeUpdate("update demotable set xyz='xyz'");
  System.out.println(result + "Records Updated");*/
  /*int result = st.executeUpdate("delete from demotable where abc='abc2'");
  if(result==0)
   System.out.println("Deletion unsuccessfull");
  else
   System.out.println(result + "Records Deleted");*/
  
  ResultSet rs=st.executeQuery("Select * from demotable");// step-4 // execute()--  executeQuery()--- executeUpdate()
  while(rs.next()) // step-5
  {
   System.out.println("abc= " + rs.getString(1));
   System.out.println("xyz= " + rs.getString(2));
  }
  con.close();//step-6

 }

}
