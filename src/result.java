import com.opencsv.CSVWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class result {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTable table1;
    private JButton ADDButton;
    private JButton addAllButton;
    private JPanel mainpanel5;

    public result() {


        Object [] colomns={"Name","emp ID"};
        DefaultTableModel model= new DefaultTableModel();
        model.setColumnIdentifiers(colomns);
        table1.setModel(model);
        table1.getColumnModel().getColumn(0).setPreferredWidth(110);
        table1.getColumnModel().getColumn(1).setPreferredWidth(70);

        table1.setRowHeight(40);

        table1.setBackground(Color.cyan);
        Object []rows=new Object[2];
        final String[] XX = new String[1];
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XX[0] =textField1.getText();
                rows[0] = textField2.getText();
                rows[1] = textField3.getText();
                model.addRow(rows);

            }
        });
        addAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CSVWriter wr=null;



                try {
                    wr=new CSVWriter(new FileWriter("result.csv",true));

                    String m[]=new String[27];
                    m[0]=XX[0];

                    int k=1;
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

    public JPanel getMainpanel5() {
        return mainpanel5;
    }
}
