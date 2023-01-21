import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class add_course {
    private static String s;
    private JPanel courserapanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JTable table1;
    private JTextField textField3;
    private JTextField textFieldd4;
    private JTextField textFieldd5;
    private JButton button2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    private JButton submitButton;



    public add_course() {



        Object [] colomns={"Name","emp ID"," credit"};
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(colomns);
        table1.setModel(model);
        table1.getColumnModel().getColumn(0).setPreferredWidth(210);
        table1.getColumnModel().getColumn(1).setPreferredWidth(90);
        table1.getColumnModel().getColumn(2).setPreferredWidth(80);
        table1.setRowHeight(40);

        table1.setBackground(Color.cyan);


        Object []rows=new Object[3];
        final String[] XX = new String[1];
        final String[] YY = new String[1];
        String aar2[]=new String[27];

        table1=new JTable();
        String aar1[]=new String[27];
        button1.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                XX[0] =textFieldd5.getText();
                YY[0] =String.valueOf(comboBox1.getSelectedItem());
                rows[0] = textField1.getText();
                rows[1] = textField2.getText();
                rows[2] = String.valueOf(comboBox2.getSelectedItem());
                model.addRow(rows);}
            });




        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CSVWriter wr=null;



                try {
                    wr=new CSVWriter(new FileWriter("temp5.csv",true));

                    String m[]=new String[27];
                      m[0]=XX[0];
                      m[1]=YY[0];
                    int k=2;
                    int row_index = model.getRowCount(), col_index = model.getColumnCount();
                    Object[][] data =new Object[row_index][col_index];
                    for(int i=0;i<row_index;i++)
                    {
                        for(int j=0;j<col_index;j++)
                        {
                            data[i][j]=model.getValueAt(i, j);
                        }
                    }
                    for(int i=0;i<row_index;i++)
                    {
                        for(int j=0;j<col_index;j++)
                        {
                            m[k]= (String) data[i][j];
                            k++;
                        }
                    }


                    wr.writeNext(m);
                    wr.flush();



                }catch(IOException io){
                    io.printStackTrace();

                }

            }
        });
    }







    public JPanel getCourserapanel() {
        return courserapanel;
    }


}

