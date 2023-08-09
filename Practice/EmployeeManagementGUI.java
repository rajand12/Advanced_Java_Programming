
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;

public class EmployeeManagementGUI {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    private static Connection connection;

    public static void main(String[] args) {
            createAndShowGUI();
            connectToDatabase();
    }

    private static void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected to the database!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't connect");
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Employee Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create labels and text fields for name, age, salary, and phone
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(5);

        JLabel salaryLabel = new JLabel("Salary:");
        JTextField salaryField = new JTextField(10);

        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField(15);

        // Create buttons for insert, update, delete, and select
        JButton insertButton = new JButton("Insert");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton selectButton = new JButton("Select");

        // Add components to the frame
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(salaryLabel);
        inputPanel.add(salaryField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(insertButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(selectButton);

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                double salary = Double.parseDouble(salaryField.getText());
                String phone = phoneField.getText();

                insertEmployee(name, age, salary, phone);
            }
        });

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEmployees();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int employeeIdToUpdate = 2; // Example: Employee ID to update
                int newAge = 35;

                updateEmployeeAge(employeeIdToUpdate, newAge);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int employeeIdToDelete = 2; // Example: Employee ID to delete

                deleteEmployee(employeeIdToDelete);
            }
        });

        // ... Add components to the frame as in the previous example ...

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void insertEmployee(String name, int age, double salary, String phone) {
        try {
            String insertQuery = "INSERT INTO employees (name, age, salary, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setDouble(3, salary);
            preparedStatement.setString(4, phone);
            preparedStatement.executeUpdate();

            System.out.println("Employee inserted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void showEmployees() {
        try {
            String selectQuery = "SELECT * FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);

            System.out.println("Employees:");
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");
                String phone = resultSet.getString("phone");

                System.out.println("ID: " + employeeId + ", Name: " + name + ", Age: " + age + ", Salary: " + salary + ", Phone: " + phone);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void updateEmployeeAge(int employeeId, int newAge) {
        try {
            String updateQuery = "UPDATE employees SET age = ? WHERE employee_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, newAge);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();

            System.out.println("Employee age updated successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void deleteEmployee(int employeeId) {
        try {
            String deleteQuery = "DELETE FROM employees WHERE employee_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();

            System.out.println("Employee deleted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
