package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Pinchange extends JFrame implements ActionListener {
    JButton back,change;
    JTextField newPinText;
    JPasswordField reEnterNewPinText;

    String pin;
    Pinchange(String pin){
        this.pin = pin;


        ImageIcon background = new ImageIcon("src/icons/atm.jpg");
        Image bgFinal = background.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon res = new ImageIcon(bgFinal);
        JLabel bg = new JLabel(res);
        bg.setBounds(0,0,900,900);
        add(bg);

        JLabel title = new JLabel("CHANGE YOUR PIN");
        title.setBounds(250,280,500,35);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("system",Font.BOLD,16));
        bg.add(title);

        JLabel newPin = new JLabel("New Pin");
        newPin.setBounds(165,320,500,35);
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("system",Font.BOLD,16));
        bg.add(newPin);

        newPinText = new JTextField();
        newPinText.setBounds(330,320,180,25);
        newPinText.setFont(new Font("raleway",Font.BOLD,16));
        bg.add(newPinText);

        JLabel reEnterNewPin = new JLabel("Re Enter New Pin");
        reEnterNewPin.setBounds(165,360,500,35);
        reEnterNewPin.setForeground(Color.WHITE);
        reEnterNewPin.setFont(new Font("system",Font.BOLD,16));
        bg.add(reEnterNewPin);

        reEnterNewPinText = new JPasswordField();
        reEnterNewPinText.setBounds(330,360,180,25);
        reEnterNewPinText.setFont(new Font("raleway",Font.BOLD,16));
        bg.add(reEnterNewPinText);

        change = new JButton("Change Pin");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        bg.add(change);

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
        } else if (e.getSource() == change){
            Conn connection = new Conn();
            try{
                String newPin = newPinText.getText();
                String reEnterPin = reEnterNewPinText.getText();
                if(newPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the new pin");
                    return;
                }
                if(!newPin.equals(reEnterPin)){
                    JOptionPane.showMessageDialog(null,"Entered Pin does not match");
                    return;
                }

                String updateBank = "update bank set pin = '" + newPin + "' where pin ='"+ pin+"'";
                String updateLogin = "update login set pin = '" + newPin + "' where pin ='"+ pin+"'";
                String updateSignupThree = "update signupthree set pin_number = '" + newPin + "' where pin_number ='"+ pin+"'";

                connection.s.executeUpdate(updateBank);
                connection.s.executeUpdate(updateLogin);
                connection.s.executeUpdate(updateSignupThree);

                JOptionPane.showMessageDialog(null,"Pin changed successfully");
                setVisible(false);
                new Transaction(newPin).setVisible(true);


            }catch (Exception exception){
                System.out.println(exception);
            }
        }

    }

    public static void main(String[] args){
        new Pinchange("");
    }
}
