package hospital.management;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame{
    JTable table;
    Room(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/roomm.png"));
        Image i12=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i22=new ImageIcon(i12);
        JLabel label=new JLabel(i22);
        label.setBounds(600,200,200,200);
        panel.add(label);

        table=new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(90,156,163));
        panel.add(table);
        try{
            conn c=new conn();
            String q="select * from Room";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        JLabel label1=new JLabel("Room No");
        label1.setBounds(12,15,80,15);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Availability");
        label2.setBounds(135,15,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3=new JLabel("Price");
        label3.setBounds(260,15,80,15);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4=new JLabel("Bed Type");
        label4.setBounds(380,15,80,15);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JButton b1=new JButton("Back");
        b1.setBounds(200,500,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(b1);
        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Room();
    }


}
