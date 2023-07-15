package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdrawal,fastcash, miniStatement, balance, pinChange, exit;
    String pin;
    Transaction(String pin){
        this.pin = pin;

        ImageIcon background = new ImageIcon("src/icons/atm.jpg");
        Image bgFinal = background.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon res = new ImageIcon(bgFinal);
        JLabel bg = new JLabel(res);
        bg.setBounds(0,0,900,900);
        add(bg);

        JLabel title = new JLabel("Please select the Transaction");
        title.setBounds(215,300,700,35);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("system",Font.BOLD,16));
        bg.add(title);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        bg.add(deposit);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(355,415,150,30);
        bg.add(withdrawal);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        bg.add(fastcash);

        miniStatement = new JButton("MIni-Statement");
        miniStatement.setBounds(355,450,150,30);
        bg.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,485,150,30);
        bg.add(pinChange);

        balance = new JButton("Balance Inquiry");
        balance.setBounds(355,485,150,30);
        bg.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        bg.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); // to remove the bar for the window
        setVisible(true);


    }
    public static void main(String[] args){
        new Transaction("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }
    }
}