import javax.swing.*;

public class FactorialCalculator{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Factorial Calculator");
        frame.setSize(300,300);
        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(10,2,0,0));
        frame.add(panel);

        JLabel lblNumber = new JLabel("Enter a number");
        panel.add(lblNumber);
        JTextField txtNumber = new JTextField(12);
        panel.add(txtNumber);

        JButton btnCalculate = new JButton("Calculate");
        panel.add(btnCalculate);

        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}