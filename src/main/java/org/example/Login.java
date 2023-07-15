package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("ATM"); // to set the title of the frame

        setLayout(null); // to override the default layout of the frame

       /*
        ImageIcon background = new ImageIcon("src/icons/backbg.png");
        JLabel bgLabel = new JLabel(background);
        setContentPane(bgLabel); //to set the background of the frame
        */
        getContentPane().setBackground(Color.white);

        ImageIcon rawLogoImage = new ImageIcon("src/icons/bank.png");
        Image image = rawLogoImage.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); // to scale the image in the frame
        ImageIcon finalLogoImage = new ImageIcon(image); // to convert image to imageIcon
        JLabel logoLabel = new JLabel(finalLogoImage); //add the image to the label
        logoLabel.setBounds(70,10,100,100);
        add(logoLabel); // to add in the frame and display the image

        JLabel header = new JLabel("Welcome to the ATM");
        header.setFont(new Font("Osward", Font.BOLD, 38));
        header.setBounds(200,40,400,40);
        add(header);

        JLabel cardNum = new JLabel("Card No: ");
        cardNum.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNum.setBounds(120,150,150,30);
        add(cardNum);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.GRAY);
        login.addActionListener(this); //to catch the event of the button
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.GRAY);
        clear.addActionListener(this); //to catch the event of the button
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.GRAY);
        signup.addActionListener(this); //to catch the event of the button
        add(signup);

        setSize(800,480); // to create the frame
        setVisible(true); // to show the frame
        setLocation(350,200); // to change the initial opening place of the frame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (e.getSource() == login) {
            Conn connection = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber  = pinTextField.getText();

            String query = "select * from login where card_number = '" + cardNumber + "' and pin = '" + pinNumber +"'";
            try {
               ResultSet resultSet = connection.s.executeQuery(query);

               if(resultSet.next()){
                   setVisible(false);
                   new Transaction(pinNumber).setVisible(true);
               } else {
                   JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
               }


            } catch (Exception exception){
                System.out.println(exception);
            }


        } else if (e.getSource() == signup) {
            setVisible(false); // to close the current frame
            new SignupOne().setVisible(true); // create a object of the sign up class and set visible to true to display
        }
    }
    public static void main(String[] args){
        new Login();
    }


}
