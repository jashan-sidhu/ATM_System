package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    JButton getFastcash100, getFastcash500,getFastcash1000, getFastcash2000, getFastcash5000, getFastcash10000, back;

    String pin;
    Fastcash(String pin){
        this.pin = pin;


        ImageIcon background = new ImageIcon("src/icons/atm.jpg");
        Image bgFinal = background.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon res = new ImageIcon(bgFinal);
        JLabel bg = new JLabel(res);
        bg.setBounds(0,0,900,900);
        add(bg);

        JLabel title = new JLabel("Please select the Withdrawal Amount");
        title.setBounds(215,300,700,35);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("system",Font.BOLD,16));
        bg.add(title);

        getFastcash100 = new JButton("Rs. 100");
        getFastcash100.setBounds(170,415,150,30);
        getFastcash100.addActionListener(this);
        bg.add(getFastcash100);

        getFastcash500 = new JButton("Rs. 500");
        getFastcash500.setBounds(355,415,150,30);
        getFastcash500.addActionListener(this);
        bg.add(getFastcash500);

        getFastcash1000 = new JButton("Rs. 1000");
        getFastcash1000.setBounds(170,450,150,30);
        getFastcash1000.addActionListener(this);
        bg.add(getFastcash1000);

        getFastcash2000 = new JButton("Rs. 2000");
        getFastcash2000.setBounds(355,450,150,30);
        getFastcash2000.addActionListener(this);
        bg.add(getFastcash2000);

        getFastcash5000 = new JButton("Rs. 5000");
        getFastcash5000.setBounds(170,485,150,30);
        getFastcash5000.addActionListener(this);
        bg.add(getFastcash5000);

        getFastcash10000 = new JButton("Rs. 10000");
        getFastcash10000.setBounds(355,485,150,30);
        getFastcash10000.addActionListener(this);
        bg.add(getFastcash10000);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        bg.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); // to remove the bar for the window
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Conn connection = new Conn();
            try {
                ResultSet balanceCheck = connection.s.executeQuery("select * from bank where pin = '"+pin+ "'");
                int balance = 0;
                while(balanceCheck.next()){
                    if(balanceCheck.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(balanceCheck.getString("amount"));
                    } else if (balanceCheck.getString("type").equals("Withdrawal")) {
                        balance -= Integer.parseInt(balanceCheck.getString("amount"));
                    }
                }

                if(balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                } else{
                    Date date = new Date();
                    String query = "Insert into bank values('" + pin + "','" + date + "','" + "Withdrawal" + "','" + amount + "')";
                    connection.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " debited successfully. ");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }

            } catch (Exception exception){
                System.out.println(exception);
            }
        }

    }

    public static void main(String[] args){
        new Fastcash("");
    }
}
