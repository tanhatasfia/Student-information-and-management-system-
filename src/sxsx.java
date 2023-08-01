import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sxsx {
    private JPanel panel1;
    private JButton resisterNewStudentButton;
    private JButton courseRegistrationButton;
    private JButton resultButton;
    private JButton updateBillHistoryButton;
    private JButton j1;


    public sxsx() {
        resisterNewStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame framee = new JFrame();
                framee.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                framee.setSize(900, 700);


                framee.add(new add_information().getPanelaad());
                framee.setVisible(true);

            }
        });

        courseRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2=new JFrame();
                frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame2.setSize(1000,700);


                frame2.add(new add_course().getCourserapanel());
                frame2.setVisible(true);

            }
        });
        updateBillHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4=new JFrame();
                frame4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame4.setSize(900,700);


                frame4.add(new add_payment().getPaymentpanel());
                frame4.setVisible(true);}



        });
        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame9=new JFrame();
                frame9.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame9.setSize(900,600);


                frame9.add(new result().getMainpanel5());
                frame9.setVisible(true);}



        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
