import java.awt.*;
import java.awt.event.*;

public class MouseAdapterExample extends MouseAdapter {

    Frame myFrame;
    MouseAdapterExample()
    {
        myFrame = new Frame("Mouse Adapter Example");
        myFrame.addMouseListener(this);
        myFrame.setSize(300,300);
        myFrame.setLayout(null);
        myFrame.setVisible(true);
    }
    public void mouseClicked(MouseEvent e)
    {
        Graphics myGraphics = myFrame.getGraphics();
        myGraphics.setColor(Color.BLUE);
        myGraphics.fillRect(e.getX(), e.getY(), 20, 10);
    }

    public static void main(String[] args) {
        new MouseAdapterExample();
    }
}
