package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pin;
    JButton back;
    BalanceEnquiry(String pin){
        this.pin = pin;

        ImageIcon background = new ImageIcon("src/icons/atm.jpg");
        Image bgFinal = background.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon res = new ImageIcon(bgFinal);
        JLabel bg = new JLabel(res);
        bg.setBounds(0,0,900,900);
        add(bg);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        bg.add(back);

        Conn connection = new Conn();
        int balance = 0;
        try{
            ResultSet balanceCheck = connection.s.executeQuery("select * from bank where pin = '"+pin+ "'");
            while(balanceCheck.next()) {
                if (balanceCheck.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(balanceCheck.getString("amount"));
                } else if (balanceCheck.getString("type").equals("Withdrawal")) {
                    balance -= Integer.parseInt(balanceCheck.getString("amount"));
                }
            }
        } catch (Exception exception){
            System.out.println(exception);
        }

        JLabel accountBalance = new JLabel("Your current Account Balance is Rs. "+balance);
        accountBalance.setBounds(170,300,400,30);
        accountBalance.setForeground(Color.WHITE);
        accountBalance.setFont(new Font("system",Font.BOLD,16));
        bg.add(accountBalance);



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
        }

    }

    public static void main (String[] args){
        new BalanceEnquiry("");
    }
}
