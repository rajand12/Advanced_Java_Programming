import java.net.URL;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.AttributedString;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.font.TextAttribute;
public class SwingBasics {

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("My Frame");


    myFrame.setSize(400,400);

    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    myFrame.setVisible(true);

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    myFrame.add(panel);
    JLabel myLabel = new JLabel("This is a example label", null, 0);

    panel.add(myLabel,BorderLayout.CENTER);

    JButton myButton = new JButton("Click ME", null);

    panel.add(myButton,BorderLayout.NORTH);

    // Graphics g = panel.getGraphics();
    // g.setColor(Color.RED);
    // g.fillRect(100, 100, 20, 20);

    Font font = new Font("Monospaced",Font.BOLD,25);
        AttributedString str = new AttributedString("Hello World");
        str.addAttribute(TextAttribute.FONT, font);


        // URL imageUrl =SwingBasics.class.getResource("abc.jpeg");    
        ImageIcon img = new ImageIcon("abc.jpeg");
        
        JLabel lbl = new JLabel(img);
        panel.add(lbl);
    }




}

    
    

