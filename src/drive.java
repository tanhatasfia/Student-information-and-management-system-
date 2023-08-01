

import javax.swing.*;

public class drive{


    public static void main(String[] args) {
        JFrame frame=new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(710,650);


        frame.add(new login1().getMainpanell3());
        frame.setVisible(true);

    }

}