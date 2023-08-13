import javax.sql.rowset.*;
import java.sql.*;

public class RowSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try {
            // Create a CachedRowSet
            CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();

            // Set connection properties
            rowSet.setUrl(url);
            rowSet.setUsername(user);
            rowSet.setPassword(password);

            // Set command and execute query
            rowSet.setCommand("SELECT * FROM your_table");
            rowSet.execute();

            // Process the data
            while (rowSet.next()) {
                int id = rowSet.getInt("id");
                String name = rowSet.getString("name");
                int age = rowSet.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Update the data (assuming there's an "age" column in the table)
            rowSet.absolute(1); // Move to the first row
            rowSet.updateInt("age", 30); // Update the age
            rowSet.updateRow(); // Commit the update

            // Close the RowSet
            rowSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
