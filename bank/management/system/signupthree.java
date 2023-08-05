package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class signupthree extends JFrame implements ActionListener {

    JRadioButton saving, fixdeposit, currentacc, recurring;
    JCheckBox card, intbank, mobbank, cheqbook, email, estate, declare;
    JButton clear, submit;
    String formno;

    signupthree(String formno) {
        this.formno = formno;
        setLayout(null);
        setSize(770, 850);
        setVisible(true);
        getContentPane().setBackground(Color.white);

        setLocation(220, 0);
        JLabel accdetails = new JLabel("Page 3 : Account Details");
        accdetails.setBounds(210, 10, 450, 40);
        accdetails.setFont(new Font("Raleway", Font.BOLD, 30));
        add(accdetails);

        JLabel acctype = new JLabel("Account Type");
        acctype.setBounds(90, 80, 200, 30);
        acctype.setFont(new Font("Raleway", Font.BOLD, 23));
        add(acctype);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(100, 120, 200, 30);
        saving.setBackground(Color.white);
        saving.setFont(new Font("Raleway", Font.BOLD, 17));
        add(saving);

        fixdeposit = new JRadioButton("Fixed Deposit Account");
        fixdeposit.setBounds(330, 120, 300, 30);
        fixdeposit.setBackground(Color.white);
        fixdeposit.setFont(new Font("Raleway", Font.BOLD, 17));
        add(fixdeposit);

        currentacc = new JRadioButton("Current Account");
        currentacc.setBounds(100, 160, 200, 30);
        currentacc.setBackground(Color.white);
        currentacc.setFont(new Font("Raleway", Font.BOLD, 17));
        add(currentacc);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setBounds(330, 160, 300, 30);
        recurring.setBackground(Color.white);
        recurring.setFont(new Font("Raleway", Font.BOLD, 17));
        add(recurring);

        ButtonGroup acctyp = new ButtonGroup();
        acctyp.add(saving);
        acctyp.add(fixdeposit);
        acctyp.add(currentacc);
        acctyp.add(recurring);

        JLabel cardno = new JLabel("Card Number");
        cardno.setBounds(90, 220, 200, 30);
        cardno.setFont(new Font("Raleway", Font.BOLD, 22));
        add(cardno);

        JLabel carddemo = new JLabel("XXXX-XXXX-XXXX-4184");
        carddemo.setBounds(340, 220, 450, 30);
        carddemo.setFont(new Font("Raleway", Font.BOLD, 20));
        add(carddemo);

        JLabel digit = new JLabel("Your 16 Digit Card Number");
        digit.setBounds(90, 245, 450, 25);
        digit.setFont(new Font("Raleway", Font.BOLD, 12));
        add(digit);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(90, 290, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pin);

        JLabel pindemo = new JLabel("XXXX");
        pindemo.setBounds(340, 290, 200, 30);
        pindemo.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pindemo);

        JLabel pindigit = new JLabel("Your 4 Digit Password");
        pindigit.setBounds(90, 315, 450, 25);
        pindigit.setFont(new Font("Raleway", Font.BOLD, 12));
        add(pindigit);

        JLabel service = new JLabel("Services Required:");
        service.setBounds(90, 365, 300, 30);
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        add(service);

        card = new JCheckBox("ATM CARD");
        card.setBounds(90, 410, 200, 30);
        card.setBackground(Color.white);
        card.setFont(new Font("Raleway", Font.BOLD, 16));
        add(card);

        intbank = new JCheckBox("Internet Banking");
        intbank.setBounds(370, 410, 300, 30);
        intbank.setBackground(Color.white);
        intbank.setFont(new Font("Raleway", Font.BOLD, 16));
        add(intbank);

        mobbank = new JCheckBox("Mobile Banking");
        mobbank.setBounds(90, 450, 300, 30);
        mobbank.setBackground(Color.white);
        mobbank.setFont(new Font("Raleway", Font.BOLD, 16));
        add(mobbank);

        cheqbook = new JCheckBox("Cheque Book");
        cheqbook.setBounds(90, 490, 300, 30);
        cheqbook.setBackground(Color.white);
        cheqbook.setFont(new Font("Raleway", Font.BOLD, 16));
        add(cheqbook);

        email = new JCheckBox("EMAIL & SMS Alerts ");
        email.setBounds(370, 450, 450, 30);
        email.setBackground(Color.white);
        email.setFont(new Font("Raleway", Font.BOLD, 16));
        add(email);

        estate = new JCheckBox("E-Statement");
        estate.setBounds(370, 490, 300, 30);
        estate.setBackground(Color.white);
        estate.setFont(new Font("Raleway", Font.BOLD, 16));
        add(estate);

        declare = new JCheckBox("I hereby declares that the above entered detailes are correct to the best of my knowledge");
        declare.setBounds(90, 540, 600, 30);
        declare.setBackground(Color.white);
        declare.setFont(new Font("Raleway", Font.BOLD, 12));
        add(declare);

        submit = new JButton("Submit");
        submit.setBounds(180, 590, 120, 30);
        submit.setFont(new Font("Raleway", Font.BOLD, 18));
        submit.setBackground(Color.red);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        clear = new JButton("Cancel");
        clear.setBounds(400, 590, 120, 30);
        clear.setFont(new Font("Raleway", Font.BOLD, 18));
        clear.setBackground(Color.red);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
    }

    public void actionPerformed(ActionEvent ae) {

        String a1 = "";
        if (saving.isSelected()) {
            a1 = "saving Account";
        } else if (fixdeposit.isSelected()) {
            a1 = "Fixed deposit Account";

        } else if (currentacc.isSelected()) {
            a1 = "Current Account";
        } else if (recurring.isSelected()) {
            a1 = "Recurring Deposit Account";
        }
        Random random = new Random();
        long fir = Math.abs(random.nextLong() % 90000000L) + 8815912000000000L;
        String cardnum = "" + Math.abs(fir);

        long pir = Math.abs(random.nextLong() % 9000L) + 1000L;
        String pinnum = "" + Math.abs(pir);
        
       

        String facility = "";
        if (card.isSelected()) {
            facility = facility + "ATM CARD";
        } else if (intbank.isSelected()) {
            facility = facility + "Internet Banking";
        } else if (mobbank.isSelected()) {
            facility = facility + "Mobile Banking";
        } else if (cheqbook.isSelected()) {
            facility = facility + "Cheque Book";
        } else if (email.isSelected()) {
            facility = facility + "Email & SMS Alerts ";
        } else if (estate.isSelected()) {
            facility = facility + "E-Statement";
        } else if (ae.getSource() == clear) {

        }
        try {
            if (ae.getSource() == submit) {
                if (a1.equals("")) {
                    JOptionPane.showMessageDialog(null, "select account type");
                    
                }
                else {
                    conn c3 = new conn();

                    String query3 = "insert into signupthree values('" + formno + "','" + a1 + "','" + cardnum + "','" + pinnum + "','" + facility + "')";
                    String query4 = "insert into login values('" + formno + "','" + cardnum + "','" + pinnum + "')";
                    c3.s.executeUpdate(query3);
                    c3.s.executeUpdate(query4);
                    JOptionPane.showMessageDialog(null, "Card number:" + cardnum + "\nPin:" + pinnum);
                    setVisible(false);
                    new deposit(pinnum).setVisible(true) ;
                }
            } else if (ae.getSource() == clear) {
                setVisible(false) ;
                new Login().setVisible(true) ;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new signupthree("");
    }
}
