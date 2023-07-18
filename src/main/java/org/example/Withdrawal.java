package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    JButton backButton, withdrawButton;
    JTextField amount;
    String pin;
    Withdrawal(String pin){
        this.pin = pin;

        ImageIcon bg = new ImageIcon("src/icons/atm.jpg");
        Image back = bg.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon background = new ImageIcon(back);
        JLabel image = new JLabel(background);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel title = new JLabel("Enter the amount you want to withdraw");
        title.setFont(new Font("system",Font.BOLD,16));
        title.setBounds(170,300,400,20);
        title.setForeground(Color.WHITE);
        image.add(title);

        amount = new JTextField();
        amount.setBounds(170,350,120,25);
        amount.setFont(new Font("raleway", Font.BOLD,22));
        image.add(amount);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(355,485,150,30);
        image.add(withdrawButton);
        withdrawButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(355,510,150,30);
        image.add(backButton);
        backButton.addActionListener(this);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == withdrawButton){
            String amount = this.amount.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            } else {
                try {
                    Conn connection = new Conn();
                    String query = "Insert into bank values('" + pin + "','" + date + "','" + "Withdrawal" + "','" + amount + "')";
                    connection.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " withdrew successfully. ");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                } catch (Exception exception){
                    System.out.println(exception);
                }
            }

        } else if (e.getSource() == backButton) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }

    }

    public static void main (String[] args){
        new Withdrawal("");
    }
}
