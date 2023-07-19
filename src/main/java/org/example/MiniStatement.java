package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String pin;
    JButton back;
    JLabel title, card, mini;
    MiniStatement(String pin){
        setTitle("Mini-Statement");
        this.pin = pin;

        setLayout(null);

        title = new JLabel("National Bank");
        title.setBounds(135,20 ,200,20);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("system",Font.BOLD,16));
        add(title);

        card = new JLabel();
        card.setBounds(20,80 ,300,20);
        card.setForeground(Color.BLACK);
        card.setFont(new Font("system",Font.BOLD,12));
        add(card);

        mini = new JLabel();
        mini.setBounds(20,140 ,400,200);
        mini.setForeground(Color.BLACK);
        mini.setFont(new Font("system",Font.BOLD,12));
        add(mini);

        Conn connection = new Conn();
        try{
            ResultSet resultSet = connection.s.executeQuery("select * from login where pin = '"+pin+ "'");
            while(resultSet.next()) {
                card.setText("Card Number: "+ resultSet.getString("card_number").substring(0,4) + "XXXXXXXX" + resultSet.getString("card_number").substring(12) );
            }
        } catch (Exception exception){
            System.out.println(exception);
        }

        try{
            ResultSet resultSet = connection.s.executeQuery("select * from bank where pin = '"+pin+ "'");
            while(resultSet.next()) {
                mini.setText(mini.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br/><br/><html>");
            }
        } catch (Exception exception){
            System.out.println(exception);
        }

        back = new JButton("Back");
        back.setBounds(135,550,150,30);
        back.addActionListener(this);
        add(back);

        setSize(400,600);
        setLocation(20,20);
        setUndecorated(true); // to remove the bar for the window
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    public static void main(String[] args){
        new MiniStatement("");
    }
}
