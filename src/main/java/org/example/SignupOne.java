package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;


public class SignupOne extends JFrame implements ActionListener {

    long randomNo;
    JTextField nameTextField,fNameTextField,emailTextField,addressTextField,stateTextField,cityTextField,pinTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, others;
    JDateChooser dateChooser;

    SignupOne(){

        setLayout(null);

        Random rand = new Random();
        randomNo = Math.abs(((rand.nextLong() % 9000L) + 1000L)); // to make the random number four digit

        JLabel formNo = new JLabel("APPLICATION FORM NO. " + randomNo);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel fName = new JLabel("Father's Name:");
        fName.setFont(new Font("Raleway", Font.BOLD, 20));
        fName.setBounds(100,190,200,30);
        add(fName);

        fNameTextField = new JTextField();
        fNameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fNameTextField.setBounds(300,190,400,30);
        add(fNameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("MM/dd/yyyy");
        dateChooser.setBounds(300,240,400,30);
        dateChooser.getJCalendar().setPreferredSize(new Dimension(550, 200));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,120,30);
        add(male);

        female =  new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup(); // adding in the group to select 1 at a time
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel maritial = new JLabel("Marital Status:");
        maritial.setFont(new Font("Raleway", Font.BOLD, 20));
        maritial.setBounds(100,390,200,30);
        add(maritial);

        married = new JRadioButton("Married");
        married.setBounds(300,390,120,30);
        add(married);

        unmarried =  new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,120,30);
        add(unmarried);

        others =  new JRadioButton("Other");
        others.setBounds(630,390,120,30);
        add(others);

        ButtonGroup maritialGroup = new ButtonGroup(); // adding in the group to select 1 at a time
        genderGroup.add(married);
        genderGroup.add(unmarried);
        genderGroup.add(others);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(620,660,100,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850,800); // create frame
        setLocation(350,10); // set initial location
        setVisible(true); //to set it visible



    }


    public static void main(String[] args){
        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = "" + randomNo;
        String name = nameTextField.getText();
        String fname = fNameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String enmail = emailTextField.getText();
        String maritalStatus = null;
        if(married.isSelected()){
            maritalStatus = "Married";
        } else if (unmarried.isSelected()) {
            maritalStatus = "Unmarried";
        } else if (others.isSelected()) {
            maritalStatus = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno +"','" + name +"','" + fname +"','" + dob +"','" + gender +"','" + enmail +"','" + maritalStatus +"','" + address +"','"+ city +"','"+ state +"','" + pin +"')";
                c.s.executeUpdate(query);
            }

        } catch (Exception exception){
            System.out.println(exception);
        }

    }
}
