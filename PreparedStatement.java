// import java.sql.*;
// import java.io.*;

// public class PreparedStatement {
//     public static void main(String[] args) {
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             Connection con = DriverManager.getConnection(
//                     "jdbc:mysql://localhost:3306/university", "root","" );

//             PreparedStatement st = (PreparedStatement) con.prepareStatement("SELECT * from students");
//             ResultSet rs = st.executeQuery();
//             while (rs.next())
//                 System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//             con.close();
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }

//     private ResultSet executeQuery() {
//         return null;
//     }

    
// }
// wap to select all stuents information from student table using prepared statement.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class PreparedStatement {
   public static void main(String args[]) {

   	String QUERY = "SELECT sid,name, address, phone_no FROM students";
      Connection c = null;
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/university", "root","" );

           Statement stmt = c.createStatement();
           ResultSet rs = stmt.executeQuery(QUERY);
           while(rs.next()){
            //Display values
            System.out.print("ID: " + rs.getInt("sid"));
            System.out.print(", Name: " + rs.getString("name"));
            System.out.print(", Address: " + rs.getString("address"));
            System.out.println(", Phonenumber: " + rs.getString("phone_no"));
         }
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      // System.out.println("Opened database successfully");
   }
}