package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingRadio, currentRadio, fdRadio, recurringRadio;
    JCheckBox atmBox, internetBox, mobileBox, emailBox, chequeBox, eBox, declarationBox;

    JButton submit, cancel;

    String formNo;
    SignupThree(String formNo){
        this.formNo = formNo;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");


        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(280,40,400,40);
        add(accountDetails);

        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100,140,200,30);
        add(accountType);

        savingRadio = new JRadioButton("Saving Account");
        savingRadio.setFont(new Font("Raleway", Font.BOLD, 16));
        savingRadio.setBounds(100,180,200,20);
        add(savingRadio);

        fdRadio = new JRadioButton("Fixed Deposit Account");
        fdRadio.setFont(new Font("Raleway", Font.BOLD, 16));
        fdRadio.setBounds(350,180,300,20);
        add(fdRadio);

        currentRadio = new JRadioButton("Current Account");
        currentRadio.setFont(new Font("Raleway", Font.BOLD, 16));
        currentRadio.setBounds(100,220,200,20);
        add(currentRadio);

        recurringRadio = new JRadioButton("Recurring Deposit Account");
        recurringRadio.setFont(new Font("Raleway", Font.BOLD, 16));
        recurringRadio.setBounds(350,220,300,20);
        add(recurringRadio);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(savingRadio);
        accountGroup.add(fdRadio);
        accountGroup.add(currentRadio);
        accountGroup.add(recurringRadio);

        JLabel cardNum = new JLabel("Card Number:");
        cardNum.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNum.setBounds(100,300,200,30);
        add(cardNum);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-1234");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330,300,350,30);
        add(number);

        JLabel cDetails = new JLabel("Your 16 digit Card Number");
        cDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cDetails.setBounds(100,330,300,20);
        add(cDetails);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pDetails = new JLabel("Your 4 digit Pin Number");
        pDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pDetails.setBounds(100,400,300,20);
        add(pDetails);

        JLabel cardPin = new JLabel("XXXX");
        cardPin.setFont(new Font("Raleway", Font.BOLD, 22));
        cardPin.setBounds(330,370,350,30);
        add(cardPin);

        JLabel servicesRequired = new JLabel("Services Required:");
        servicesRequired.setFont(new Font("Raleway", Font.BOLD, 22));
        servicesRequired.setBounds(100,450,350,30);
        add(servicesRequired);

        atmBox = new JCheckBox("ATM CARD");
        atmBox.setFont(new Font("Raleway", Font.BOLD, 16));
        atmBox.setBounds(100,500,200,30);
        add(atmBox);

        internetBox = new JCheckBox("INTERNET BANKING");
        internetBox.setFont(new Font("Raleway", Font.BOLD, 16));
        internetBox.setBounds(350,500,200,30);
        add(internetBox);

        mobileBox = new JCheckBox("MOBILE BANKING");
        mobileBox.setFont(new Font("Raleway", Font.BOLD, 16));
        mobileBox.setBounds(100,550,200,30);
        add(mobileBox);

        emailBox = new JCheckBox("EMAIL & SMS ALERT");
        emailBox.setFont(new Font("Raleway", Font.BOLD, 16));
        emailBox.setBounds(350,550,200,30);
        add(emailBox);

        chequeBox = new JCheckBox("CHEQUE BOOK");
        chequeBox.setFont(new Font("Raleway", Font.BOLD, 16));
        chequeBox.setBounds(100,600,200,30);
        add(chequeBox);

        eBox = new JCheckBox("E-STATEMENT");
        eBox.setFont(new Font("Raleway", Font.BOLD, 16));
        eBox.setBounds(350,600,200,30);
        add(eBox);

        declarationBox = new JCheckBox("I hearby declare that the above entered details are correct to the best of my knowledge");
        declarationBox.setFont(new Font("Raleway", Font.BOLD, 12));
        declarationBox.setBounds(100,680,600,30);
        add(declarationBox);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850,820); //to create the frame
        setLocation(350,0);
        setVisible(true);
    }

    public static void main(String[] args){
        new SignupThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String accountType = null;

            if(savingRadio.isSelected()){
                accountType = "Saving Account";
            } else if (fdRadio.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (currentRadio.isSelected()) {
                accountType = "Current Account";
            } else if (recurringRadio.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNum = "" + Math.abs((random.nextLong() % 90000000L) + 5070849000000000L);

            String pinNum = "" + Math.abs((random.nextInt() % 9000) + 1000);

            String facility = "";
            if(atmBox.isSelected()){
                facility = facility + "ATM CARD ";
            }
            if(chequeBox.isSelected()){
                facility = facility + "CHEQUE BOOK ";
            }
            if(emailBox.isSelected()){
                facility = facility + "EMAIL & SMS ALERTS ";
            }
            if(mobileBox.isSelected()){
                facility = facility + "MOBILE BANKING ";
            }
            if(internetBox.isSelected()){
                facility = facility + "INTERNET BANKING ";
            }
            if(eBox.isSelected()){
                facility = facility + "E-STATEMENT";
            }


            try {
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                } else {
                    Conn connection = new Conn();
                    String query = "insert into signupthree values('" + formNo +"','" + accountType +"','" + cardNum +"','" + pinNum +"','" + facility +"')";
                    String loginQuery = "insert into login values('" + formNo +"','" + cardNum +"','" + pinNum +"')";
                    connection.s.executeUpdate(query);
                    connection.s.executeUpdate(loginQuery);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNum + "\n Pin: " + pinNum);
                    setVisible(false);
                    new Login().setVisible(true);

                }

            } catch (Exception exception){
                System.out.println(exception);
            }

        } else if (e.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
