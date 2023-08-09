import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class factorial_gui implements KeyListener{
    JTextField txt1,txt2;
    JLabel lbl1;
    JLabel lbl2;

    public void myMethod(){
        JFrame myFrame = new JFrame("Factorial Calculator");
        myFrame.setSize(300, 300);
        myFrame.setVisible(true);
        myFrame.setLayout(new FlowLayout(FlowLayout.TRAILING,80,70));
        myFrame.setResizable(true);
        //myFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        lbl1 = new JLabel("Enter a number");
        txt1 = new JTextField(10);
        lbl2 = new JLabel("Press a key inside here to preform factorial");
        txt2 = new JTextField(10);
        myFrame.add(lbl1);
        myFrame.add(lbl2);
        myFrame.add(txt1);
        myFrame.add(txt2);
        txt2.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }


    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int num1 = Integer.parseInt(txt1.getText());
        int fact = 1;
        int i = 1;
        for(i = num1; i>=1; i--){
            fact = fact * i;
        }
        lbl2.setText(""+fact);
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    public static void main(String[] args) {
        factorial_gui obj1 = new factorial_gui();
        obj1.myMethod();
    }
}
