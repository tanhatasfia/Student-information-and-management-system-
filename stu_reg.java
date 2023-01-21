import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class stu_reg {

    private JPanel stu_reg_course;
    private JPanel panel1;
    private JButton submitButton;
    public   JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton submitButton1;
    private JTextField textField4;
    private JButton submitButton2;
    private JComboBox comboBox1;

    public void setUser(String user) {
        this.textField1.setText(user);
        this.textField3.setText(user);
        this.textField4.setText(user);

    }


    public stu_reg() {



        textField1.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);

                Object [] colomns={"course-Name","course-code"," credit-hour"};
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        String jj=textField1.getText();
                        String pp=String.valueOf(comboBox1.getSelectedItem());
                        CSVReader rd=null;
                        String[] nextRecord;
                        int flag=0;
                        try {
                            rd = new CSVReader(new FileReader("temp5.csv"));
                            Object[][]course = new Object[6][3];
                            while ((nextRecord = rd.readNext()) != null) {
                                if (nextRecord[0].equals(jj) && nextRecord[1].equals(pp)) {
                                    int k=2;
                                    for(int i=0;i<6;i++)
                                    {
                                        for(int j=0;j<3;j++)
                                        {
                                            course[i][j]=nextRecord[k];
                                            k++;
                                        }
                                    }
                                    flag = 1;
                                    break;
                                }
                            }
                            if (flag == 1) {

                                for(int i=0;i<6;i++)
                                {
                                    for(int j=0;j<3;j++)
                                    {
                                        System.out.print(course[i][j]+" ");

                                    }
                                    System.out.println();
                                }
                                JTable table = new JTable(course,colomns);
                                Font font = new Font("Verdana", Font.PLAIN, 12);
                                table.setFont(font);
                                table.setRowHeight(30);
                                JFrame frame = new JFrame();
                                frame.setSize(600, 400);
                                frame.add(new JScrollPane(table));
                                frame.setVisible(true);


                            } else {
                                JOptionPane.showMessageDialog(null, "your courses havent been registered yet ");
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
                });

        Object [] colomns3={"sem-time","semester-amount"," payment_"};
        submitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jj=textField3.getText();

                CSVReader rd=null;
                String[] nextRecord;
                int flag=0;
                try {
                    rd = new CSVReader(new FileReader("payment.csv"));
                    Object[][]course = new Object[6][3];
                    while ((nextRecord = rd.readNext()) != null) {
                        if (nextRecord[0].equals(jj)) {
                            int k=1;
                            for(int i=0;i<6;i++)
                            {
                                for(int j=0;j<3;j++)
                                {
                                    course[i][j]=nextRecord[k];
                                    k++;
                                }
                            }
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) {

                        for(int i=0;i<6;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                System.out.print(course[i][j]+" ");

                            }
                            System.out.println();
                        }
                        JTable table = new JTable(course,colomns3);
                        Font font = new Font("Verdana", Font.PLAIN, 12);
                        table.setFont(font);
                        table.setRowHeight(30);
                        JFrame frame = new JFrame();
                        frame.setSize(600, 400);
                        frame.add(new JScrollPane(table));
                        frame.setVisible(true);


                    } else {
                        JOptionPane.showMessageDialog(null, "your info has not been added yet");
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
        });
        Object [] colomns2={"Sem-Name","cgpa"};
        submitButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jj=textField4.getText();

                CSVReader rd=null;
                String[] nextRecord;
                int flag=0;
                try {
                    rd = new CSVReader(new FileReader("result.csv"));
                    Object[][]course2 = new Object[6][2];
                    while ((nextRecord = rd.readNext()) != null) {
                        if (nextRecord[0].equals(jj)) {
                            int k=1;
                            for(int i=0;i<6;i++)
                            {
                                for(int j=0;j<2;j++)
                                {
                                    course2[i][j]=nextRecord[k];
                                    k++;
                                }
                            }
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) {

                        for(int i=0;i<6;i++)
                        {
                            for(int j=0;j<2;j++)
                            {
                                System.out.print(course2[i][j]+" ");

                            }
                            System.out.println();
                        }
                        JTable table = new JTable(course2,colomns2);
                        Font font = new Font("Verdana", Font.PLAIN, 12);
                        table.setFont(font);
                        table.setRowHeight(30);
                        JFrame frame = new JFrame();
                        frame.setSize(600, 400);
                        frame.add(new JScrollPane(table));
                        frame.setVisible(true);


                    } else {
                        JOptionPane.showMessageDialog(null, "your info hasnt been added yet");
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
        });
    }
    public JPanel getStu_reg_course(){
        return stu_reg_course;
    }
}
