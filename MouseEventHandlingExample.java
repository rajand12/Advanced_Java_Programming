import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class MouseEventHandlingExample implements MouseListener
{
    Label label1, label2;
    Frame myFrame;
    String myText;
    MouseEventHandlingExample()
    {
        myFrame = new Frame("Java Mouse Listener Example");
        label1 = new Label("Demo for mouse event",Label.CENTER);
        label2 = new Label();
        myFrame.setLayout(new FlowLayout());
        myFrame.add(label1);
        myFrame.add(label2);
        myFrame.addMouseListener(this);
        myFrame.setSize(350,220);
        myFrame.setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        public void mouseClicked(MouseEvent ev)
        {
            myText = "The mouse button is clicked";
            label2.setText(myText);
            myFrame.setVisible(true);
        }
        public void mouseEntered(MouseEvent ev)
        {
            myText = "The mouse has entered the area of window";
            label2.setText(myText);
            myFrame.setVisible(true);
        }
        public void mouseExited(MouseEvent ev)
        {
            myText = "The mouse has exited the area of window";
            label2.setText(myText);
            myFrame.setVisible(true);
        }
        public void mousePressed(MouseEvent ev)
        {
            myText = "The mouse button is being pressed";
            label2.setText(myText);
            myFrame.setVisible(true);
        }
        public void mouseReleased(MouseEvent ev)
        {
            myText = "The mouse button is released";
            label2.setText(myText);
            myFrame.setVisible(true);
        }
        public static void main(String[] args) 
        {
           new MouseEventHandlingExample(); 
        }

}

