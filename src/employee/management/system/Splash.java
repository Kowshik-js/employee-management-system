package employee.management.system;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        //to display image from source folder
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        //to define the size of image
        Image i2=i1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT);

        ImageIcon i3=new ImageIcon(i2);
        //to put into frame
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);


        //size
        setSize(1170,650);
        //frame left to right
        setLocation(200,50);
        setLayout(null);
        setVisible(true);

        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        new Splash();
    }
}
