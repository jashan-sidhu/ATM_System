package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener {


    JTextField panNumber,aadharNumber;
    JButton next;
    JRadioButton seniorYes, seniorNo, existingYes, existingNo;
    JComboBox religionBox,categoryBox,educationBox, occupationBox,incomeBox;
    String formNo;

    SignupTwo(String formNo){
        this.formNo = formNo;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");


        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100,140,100,30);
        add(religion);

        String religions[] = {"Hindu","Muslim","Sikh","Buddhist","Others"};
        religionBox = new JComboBox(religions);
        religionBox.setBounds(300,140,400,30);
        add(religionBox);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100,190,200,30);
        add(category);

        String categories[] = {"General","OBC","SC","ST","Others"};
        categoryBox = new JComboBox(categories);
        categoryBox.setBounds(300,190,400,30);
        add(categoryBox);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,240,200,30);
        add(income);

        String iccomeList[] = {"Null","< 1,50,000","< 2,00,000","< 5,00,000","Upto 10,00,000"};
        incomeBox = new JComboBox(iccomeList);
        incomeBox.setBounds(300,240,400,30);
        add(incomeBox);

        JLabel gender = new JLabel("Educational ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,315,200,30);
        add(email);

        String educationLevels[] = {"Non-Graduate","Graduate","Post Graduate","Doctorate"};
        educationBox = new JComboBox(educationLevels);
        educationBox.setBounds(300,315,400,30);
        add(educationBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100,390,200,30);
        add(occupation);

        String occupationLevels[] = {"Salaried","Self-Employed","Business","Retired","Student"};
        occupationBox = new JComboBox(occupationLevels);
        occupationBox.setBounds(300,390,400,30);
        add(occupationBox);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100,440,200,30);
        add(pan);

        panNumber = new JTextField();
        panNumber.setFont(new Font("Raleway", Font.BOLD, 14));
        panNumber.setBounds(300,440,400,30);
        add(panNumber);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);

        aadharNumber = new JTextField();
        aadharNumber.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharNumber.setBounds(300,490,400,30);
        add(aadharNumber);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100,540,200,30);
        add(senior);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300,540,100,30);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(450,540,100,30);
        add(seniorNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorNo);
        seniorGroup.add(seniorYes);

        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        existingYes = new JRadioButton("Yes");
        existingYes.setBounds(300,590,100,30);
        add(existingYes);

        existingNo = new JRadioButton("No");
        existingNo.setBounds(450,590,100,30);
        add(existingNo);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(existingNo);
        existingGroup.add(existingYes);

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
        new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String religion = (String) religionBox.getSelectedItem();
        String category = (String) categoryBox.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String education = (String) educationBox.getSelectedItem();;
        String occupation = (String) occupationBox.getSelectedItem();
        String seniorCitizen = null;
        if(seniorYes.isSelected()){
            seniorCitizen = "Yes";
        } else if (seniorNo.isSelected()) {
            seniorCitizen = "No";
        }
        String existingAccount = null;
        if(existingYes.isSelected()){
            existingAccount = "Yes";
        } else if (existingNo.isSelected()) {
            existingAccount = "No";
        }

        String pan = panNumber.getText();
        String aadhar = aadharNumber.getText();

        try{
            if(religion.equals("")){
                JOptionPane.showMessageDialog(null,"Religion is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+ formNo +"','" + religion +"','" + category +"','" + income +"','" + education +"','" + occupation +"','" + seniorCitizen +"','"+ existingAccount +"','"+ pan +"','" + aadhar +"')";
                c.s.executeUpdate(query);
            }

        } catch (Exception exception){
            System.out.println(exception);
        }

    }
}
