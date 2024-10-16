package hospital.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {
    JButton b1,b2,b3;
    update_patient_details(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image i1=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1=new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2=new JLabel("Name");
        label2.setBounds(25,88,100,20);
        label2.setFont(new Font("Tahoma",Font.PLAIN,16));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(248,85,100,25);
        panel.add(choice);

        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }
        catch (Exception E){
            E.printStackTrace();
        }

        JLabel label3=new JLabel("Room Number");
        label3.setBounds(25,129,150,20);
        label3.setFont(new Font("Tahoma",Font.PLAIN,16));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textFieldRoomNo=new JTextField();
        textFieldRoomNo.setBounds(248,129,140,20);
        panel.add(textFieldRoomNo);

        JLabel label4=new JLabel("IN-Time : ");
        label4.setBounds(25,174,100,20);
        label4.setFont(new Font("Tahoma",Font.PLAIN,16));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textFieldINTime=new JTextField();
        textFieldINTime.setBounds(248,174,100,20);
        panel.add(textFieldINTime);

        JLabel label5=new JLabel("Amount Paid(Rs) : ");
        label5.setBounds(25,216,140,20);
        label5.setFont(new Font("Tahoma",Font.PLAIN,16));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textFieldAmount=new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);

        JLabel label6=new JLabel("Pending Amount(Rs) : ");
        label6.setBounds(25,261,200,20);
        label6.setFont(new Font("Tahoma",Font.PLAIN,16));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textFieldPending=new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        panel.add(textFieldPending);

        b1=new JButton("CHECK");
        b1.setBounds(281,378,89,23);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q="select * from patient_info where Name='"+id+"'";
                try{
                    conn c=new conn();
                    ResultSet resultset=c.statement.executeQuery(q);
                    while(resultset.next()){
                        textFieldRoomNo.setText(resultset.getString("Room_Number"));
                        textFieldINTime.setText(resultset.getString("Time"));
                        textFieldAmount.setText(resultset.getString("Deposite"));

                    }
                    ResultSet resultSet1=c.statement.executeQuery("select * from Room where room_no='"+textFieldRoomNo.getText()+"'");
                    while(resultSet1.next()){
                        String price=resultSet1.getString("Price");
                        int amountPaid=Integer.parseInt(price)-Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);

                    }
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        b2=new JButton("UPDATE");
        b2.setBounds(56,378,89,23);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        panel.add(b2);

        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c=new conn();
                    String q=choice.getSelectedItem();
                    String room=textFieldRoomNo.getText();
                    String time=textFieldINTime.getText();
                    String amount=textFieldAmount.getText();
                    c.statement.executeUpdate("update patient_info set Room_Number='"+room+"',Time='"+time+"',Deposite='"+amount+"' where Name='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    panel.add(b2);
                    setVisible(false);
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton b3=new JButton("BACK");
        b3.setBounds(170,378,89,23);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.black);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(b3);

        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new update_patient_details();
    }
}
