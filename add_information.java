import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class add_information {
    JTextField textField1;
     JTextField textField2;
     JTextField textField3;
     JTextField textField4;
     JTextField textField5;
    private JButton addCourseButton;
    private JButton addPaymentButton;
    private JLabel label1;
    private JPanel panelaad;
    private JTextField textField6;
    private JButton submitButton;
    private JPasswordField passwordField1;
    private JComboBox comboBox1;
    public String kala;
     class Invalidemailandphoneexception extends Exception{

        public Invalidemailandphoneexception(String s)
        {
            // Call constructor of parent Exception
            super(s);

        }
    }
    class myexception extends Exception{

        public myexception(String s)
        {
            // Call constructor of parent Exception
            super(s);

        }
    }
    public void productCheck(int weight) throws Invalidemailandphoneexception{
        if(weight>1){
            if(weight!=11){
            throw new Invalidemailandphoneexception("phonenumber Invalid");}
        }
    }
    public void productCheck2(String la) throws Invalidemailandphoneexception{
        if(!la.contains("@")){
            throw new Invalidemailandphoneexception("emailid Invalid");
        }
    }
    int flag=0;
    public void chckfile(String kaal) throws myexception {
        CSVReader rdd = null;
        String[] nextRecord1;

        try {
            rdd = new CSVReader(new FileReader("temp2.csv"));
            while ((nextRecord1 = rdd.readNext()) != null) {
                if (nextRecord1[1].equals(kaal)) {
                    flag = 1;
                    break;
                }
            }

        } catch (FileNotFoundException e) {


            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        if (flag == 1) {
            throw new myexception("ID already exists");
        }

    }
    public add_information(){

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String ss=textField4.getText();
                String aaa=textField6.getText();
                String zz=textField2.getText();

                try {
                    productCheck(aaa.length());
                } catch (Invalidemailandphoneexception invalidemailandphoneexception) {
                    invalidemailandphoneexception.printStackTrace();
                }
                try {
                    productCheck2(ss);
                } catch (Invalidemailandphoneexception invalidemailandphoneexception) {
                    invalidemailandphoneexception.printStackTrace();
                }

                try {
                    chckfile(zz);
                } catch (add_information.myexception myexception) {
                    myexception.printStackTrace();
                }
                if(ss.contains("@") && aaa.length()==11 && flag==0) {

                    JOptionPane.showMessageDialog(null, "successfully added");
                    CSVWriter wr=null;
                    CSVReader ed=null;

                    String aar[]=new String[6];
                    try {
                        wr=new CSVWriter(new FileWriter("temp2.csv",true));


                        aar[0]=textField1.getText();
                        aar[1]=textField2.getText();
                        aar[2]=String.valueOf(comboBox1.getSelectedItem());
                        aar[3]=textField4.getText();
                        aar[4]=passwordField1.getText();
                        String s=new String(textField6.getText());
                        aar[5]=s;
                        wr.writeNext(aar);
                        wr.flush();



                    }catch(IOException io){
                        io.printStackTrace();

                    }


                }
                else
                {
                    JOptionPane.showMessageDialog(null,"something wrong with email or phone number or ID already exists");
                }

            }
        });



    }

    public JPanel getPanelaad() {
        return panelaad;
    }

    public JTextField getTextField5() {
        return textField5;
    }




}
