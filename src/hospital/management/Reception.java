package hospital.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){
        JPanel panel2=new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(5,160,1525,670);
        panel2.setBackground(new Color(109,164,170));
        add(panel2);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icons/dr.png"));
        Image i11=imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i11);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(1300,0,250,250);
        panel1.add(label);

        ImageIcon i12=new ImageIcon(ClassLoader.getSystemResource("icons/amb.png"));
        Image i1=i12.getImage().getScaledInstance(300,100,Image.SCALE_DEFAULT);
        ImageIcon i22=new ImageIcon(i1);
        JLabel label2=new JLabel(i22);
        label2.setBounds(1000,50,300,100);
        panel1.add(label2);

        JButton b1=new JButton("Add New Patient");
        b1.setBounds(30,15,200,30);
        b1.setBackground(new Color(246,215,118));
        panel1.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NEW_PATIENT();
            }
        });

        JButton b2=new JButton("Room");
        b2.setBounds(30,58,200,30);
        b2.setBackground(new Color(246,215,118));
        panel1.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton b3=new JButton("Department");
        b3.setBounds(30,100,200,30);
        b3.setBackground(new Color(246,215,118));
        panel1.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton b4=new JButton("All Employee Info");
        b4.setBounds(270,15,200,30);
        b4.setBackground(new Color(246,215,118));
        panel1.add(b4);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });

        JButton b5=new JButton("Patient Info");
        b5.setBounds(270,58,200,30);
        b5.setBackground(new Color(246,215,118));
        panel1.add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ALL_Patient_Info();
            }
        });

        JButton b6=new JButton("Patient Discharge");
        b6.setBounds(270,100,200,30);
        b6.setBackground(new Color(246,215,118));
        panel1.add(b6);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new patient_discharge();
            }
        });

        JButton b7=new JButton("Update Patient Details");
        b7.setBounds(510,15,200,30);
        b7.setBackground(new Color(246,215,118));
        panel1.add(b7);
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new update_patient_details();
            }
        });
        JButton b8=new JButton("Hospital Ambulance");
        b8.setBounds(510,58,200,30);
        b8.setBackground(new Color(246,215,118));
        panel1.add(b8);
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });

        JButton b9=new JButton("Search Room");
        b9.setBounds(510,100,200,30);
        b9.setBackground(new Color(246,215,118));
        panel1.add(b9);
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchRoom();
            }
        });

        JButton b10=new JButton("Logout");
        b10.setBounds(750,15,200,30);
        b10.setBackground(new Color(246,215,118));
        panel1.add(b10);
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
            }
        });





        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(1950,1090);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();
    }
}
