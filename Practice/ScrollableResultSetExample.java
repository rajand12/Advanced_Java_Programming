import java.sql.*;

public class ScrollableResultSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Create a scrollable and updatable Statement
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, // Scrollable
                    ResultSet.CONCUR_UPDATABLE // Updatable
            );

            // Execute a query
            String query = "SELECT * FROM your_table";
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate over the result set (scroll forward)
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Move to the second row and update it
            resultSet.absolute(2); // Move to the 2nd row (assuming at least two rows exist)
            resultSet.updateString("name", "UpdatedName");
            resultSet.updateInt("age", 30);
            resultSet.updateRow();

            // Insert a new row
            resultSet.moveToInsertRow();
            resultSet.updateInt("id", 4);
            resultSet.updateString("name", "NewPerson");
            resultSet.updateInt("age", 25);
            resultSet.insertRow();

            // Close the result set and statement
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
