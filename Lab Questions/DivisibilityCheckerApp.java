import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DivisibilityCheckerApp extends JFrame {
    private JTextField inputTextField;
    private JLabel resultLabel;

    public DivisibilityCheckerApp() {
        setTitle("Divisibility Checker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        inputTextField = new JTextField(10);
        resultLabel = new JLabel();

        inputTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
                    checkDivisibility();
                }
            }
        });

        add(new JLabel("Enter a number: "));
        add(inputTextField);
        add(resultLabel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void checkDivisibility() {
        String inputText = inputTextField.getText();
        try {
            int number = Integer.parseInt(inputText);
            if (number % 5 == 0) {
                resultLabel.setText(number + " is divisible by 5.");
            } else {
                resultLabel.setText(number + " is not divisible by 5.");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DivisibilityCheckerApp();
            }
        });
    }
}
