import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class login1 {
    private JPanel mainpanell3;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JComboBox comboBox1;
    private JButton LOGINButton;


    public login1() {
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jj=textField1.getText();
                String pp=new String(passwordField1.getText());
                String xx=String.valueOf(comboBox1.getSelectedItem());
                if(xx.equals("ADMIN"))
                {
                    CSVReader rd=null;
                    String[] nextRecord;
                    int flag=0;
                    try {
                        rd = new CSVReader(new FileReader("page1.csv"));
                        while ((nextRecord = rd.readNext()) != null) {
                            if (nextRecord[0].equals(jj) && nextRecord[1].equals(pp)) {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1) {
                            JOptionPane.showMessageDialog(null, "Logged in ");
                            JFrame frameee = new JFrame();
                            frameee.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                            frameee.setSize(900, 700);



                            frameee.add(new sxsx().getPanel1());

                            frameee.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "This account doesnot exist");
                        }
                    }

                     catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (CsvValidationException csvValidationException) {
                        csvValidationException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else
                {
                    CSVReader rdd=null;
                    String[] nextRecord1;
                    int flag=0;
                    try {
                        rdd = new CSVReader(new FileReader("temp2.csv"));
                        while ((nextRecord1 = rdd.readNext()) != null) {
                            if (nextRecord1[0].equals(jj) && nextRecord1[4].equals(pp)) {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1) {
                            JOptionPane.showMessageDialog(null, "Logged in ");

                        } else {
                            JOptionPane.showMessageDialog(null, "This account doesnot exist");
                        }
                    }

                    catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (CsvValidationException csvValidationException) {
                        csvValidationException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
    }

    public JPanel getMainpanell3() {
        return mainpanell3;
    }
}
