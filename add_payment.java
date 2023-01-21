import com.opencsv.CSVWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class add_payment {
    private JPanel paymentpanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JTable table1;
    private JTextField textField4;
    private JButton addAllButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public add_payment() {

        Object[] colomns = {"Name", "emp ID", " credit"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(colomns);
        table1.setModel(model);
        table1.getColumnModel().getColumn(0).setPreferredWidth(115);
        table1.getColumnModel().getColumn(1).setPreferredWidth(90);
        table1.getColumnModel().getColumn(2).setPreferredWidth(60);

        table1.setRowHeight(40);
        table1.setBackground(Color.cyan);

        Object[] rows = new Object[3];
        final String[] XX1 = new String[1];
        table1 = new JTable();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               XX1[0]=textField4.getText();
                rows[0] = String.valueOf(comboBox1.getSelectedItem());
                rows[1] = textField2.getText();
                rows[2] = String.valueOf(comboBox2.getSelectedItem());
                model.addRow(rows);
            }
        });


        addAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CSVWriter wr1=null;
                try {
                    wr1=new CSVWriter(new FileWriter("payment.csv",true));

                    String m1[]=new String[27];
                    m1[0]=XX1[0];

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
                            m1[k]= (String) data[i][j];
                            k++;
                        }
                    }


                    wr1.writeNext(m1);
                    wr1.flush();



                }catch(IOException io){
                    io.printStackTrace();

                }
            }
        });
    }

    public JPanel getPaymentpanel() {
        return paymentpanel;
    }
}