

import javax.swing.*;
import java.util.Scanner;

public class drive{
    public static String kala;




    public static void main(String[] args) {

        JFrame frame=new JFrame();

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(710,650);


        frame.add(new login1().getMainpanell3());


     
        frame.setVisible(true);


    }

}