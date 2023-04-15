import javax.swing.*;
public class SettingFrames 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        JButton button = new JButton("click");
        button.setBounds(150, 150, 100, 40);
        frame.add(button);
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
