import java.sql.*;

public class PreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Create a PreparedStatement
            String query = "INSERT INTO your_table (name, age) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set parameters
            preparedStatement.setString(1, "John");
            preparedStatement.setInt(2, 25);

            // Execute the update (for INSERT, UPDATE, DELETE, etc.)
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " rows affected.");

            // Close the PreparedStatement
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
