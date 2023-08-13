import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class TextAndColorExample extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set background color
        setBackground(Color.WHITE);

        // Draw text with a special font
        Font specialFont = new Font("Monospaced", Font.BOLD, 24);
        g2d.setFont(specialFont);

        // Create an AttributedString to apply attributes to parts of the text
        AttributedString attributedString = new AttributedString("Hello, Java!");
        attributedString.addAttribute(TextAttribute.FONT, specialFont);
        attributedString.addAttribute(TextAttribute.FOREGROUND, Color.RED, 0, 5); // Apply red color to the first 5 characters

        // Draw the attributed string
        g2d.drawString(attributedString.getIterator(), 50, 50);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Text and Color Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TextAndColorExample());
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}