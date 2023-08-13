import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FactorialAndSquaringApp extends JFrame {
    private JTextField inputTextField;
    private JLabel resultLabel;

    public FactorialAndSquaringApp() {
        setTitle("Factorial and Squaring Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inputTextField = new JTextField(10);
        resultLabel = new JLabel();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                calculateFactorial();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                calculateSquare();
            }
        });

        add(new JLabel("Enter a number: "));
        add(inputTextField);
        add(calculateButton);
        add(resultLabel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculateFactorial() {
        String inputText = inputTextField.getText();
        try {
            int number = Integer.parseInt(inputText);
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            resultLabel.setText("Factorial of " + number + " is " + factorial);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Enter a valid number.");
        }
    }

    private void calculateSquare() {
        String inputText = inputTextField.getText();
        try {
            int number = Integer.parseInt(inputText);
            int square = number * number;
            resultLabel.setText("Square of " + number + " is " + square);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FactorialAndSquaringApp();
            }
        });
    }
}
