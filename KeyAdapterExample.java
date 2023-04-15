import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KeyAdapterExample  extends KeyAdapter {
    JTextField txt1, txt2, txt3;
    JLabel lbl1, lbl2, lbl3;

    public void myMethod()  {
        JFrame myFrame = new JFrame("Key Adapter Example");
        myFrame.setSize(600, 600);
        myFrame.setResizable(true);
        myFrame.setVisible(true);
        myFrame.getContentPane().setLayout(null);

        lbl1 = new JLabel("Enter something");
        
        lbl1.setBounds(90, 100, 150, 30);
        myFrame.add(lbl1);

        

        txt1 = new JTextField();
        txt1.setText("");
        txt1.setBounds(150, 100, 120, 20);
        myFrame.add(txt1);
        txt1.addKeyListener(this);

        
        
        lbl2 = new JLabel();
        lbl2.setBounds(90, 400, 150, 30);
        myFrame.add(lbl2);
    }

    public void keyPressed(KeyEvent e) {
         lbl2.setText("Key Pressed");
    }

    public static void main(String[] args) {
        KeyAdapterExample obj1 = new KeyAdapterExample();
        obj1.myMethod();
    }

}