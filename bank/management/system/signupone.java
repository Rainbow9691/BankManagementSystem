package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class signupone extends JFrame implements ActionListener {

    long random;
    JTextField name, father, Email, address, city, state, Pin;
    JButton next;
    JRadioButton male, female, other, married, unmarried, other1;
    JDateChooser dateChooser;

    signupone() {
        setLayout(null);
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;
        setLocation(300, 10);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setSize(730, 900);
        setVisible(true);
        getContentPane().setBackground(Color.white);

        JLabel formno = new JLabel("APPLICATION FORM NO." + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 35));
        formno.setBounds(90, 30, 600, 40);
        add(formno);

        JLabel personal = new JLabel("Page no. 1 : Personal Details");
        personal.setFont(new Font("Raleway", Font.BOLD, 20));
        personal.setBounds(190, 90, 500, 30);
        add(personal);

        JLabel Name = new JLabel("Name:");
        Name.setFont(new Font("Raleway", Font.BOLD, 17));
        Name.setBounds(70, 150, 200, 30);
        add(Name);

        JLabel Father = new JLabel("Father's Name:");
        Father.setFont(new Font("Raleway", Font.BOLD, 17));
        Father.setBounds(70, 190, 200, 30);
        add(Father);

        JLabel Dob = new JLabel("Date of Birth:");
        Dob.setFont(new Font("Raleway", Font.BOLD, 17));
        Dob.setBounds(70, 230, 200, 30);
        add(Dob);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 17));
        gender.setBounds(70, 270, 200, 30);
        add(gender);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 17));
        email.setBounds(70, 310, 200, 30);
        add(email);

        JLabel Marital = new JLabel("Marital Status:");
        Marital.setFont(new Font("Raleway", Font.BOLD, 17));
        Marital.setBounds(70, 350, 200, 30);
        add(Marital);

        JLabel Address = new JLabel("Address:");
        Address.setFont(new Font("Raleway", Font.BOLD, 17));
        Address.setBounds(70, 390, 200, 30);
        add(Address);

        JLabel City = new JLabel("City:");
        City.setFont(new Font("Raleway", Font.BOLD, 17));
        City.setBounds(70, 430, 200, 30);
        add(City);

        JLabel State = new JLabel("State:");
        State.setFont(new Font("Raleway", Font.BOLD, 17));
        State.setBounds(70, 470, 200, 30);
        add(State);

        JLabel pin = new JLabel("Pincode:");
        pin.setFont(new Font("Raleway", Font.BOLD, 17));
        pin.setBounds(70, 510, 200, 30);
        add(pin);

        name = new JTextField();
        name.setBounds(280, 150, 290, 25);
        name.setFont(new Font("Arial", Font.BOLD, 17));
        add(name);

        father = new JTextField();
        father.setBounds(280, 190, 290, 25);
        father.setFont(new Font("Arial", Font.BOLD, 17));
        add(father);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(280, 230, 290, 30);
        add(dateChooser);
//         TextField dob = new TextField() ;
//        dob.setBounds(280,230 ,290,25);
//        dob.setFont(new Font("Arial",Font.BOLD,17));
//        add(dob);

//        TextField genderstat = new TextField();
//        genderstat.setBounds(280, 270, 290, 25);
//        genderstat.setFont(new Font("Arial", Font.BOLD, 17));
//        add(genderstat);
        male = new JRadioButton("Male");
        male.setBounds(280, 270, 70, 20);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(380, 270, 80, 20);
        female.setBackground(Color.white);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(490, 270, 100, 20);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        Email = new JTextField();
        Email.setBounds(280, 310, 290, 25);
        Email.setFont(new Font("Arial", Font.BOLD, 17));
        add(Email);

//        TextField marital = new TextField();
//        marital.setBounds(280, 350, 290, 25);
//        marital.setFont(new Font("Arial", Font.BOLD, 17));
//        add(marital);
        married = new JRadioButton("Married");
        married.setBounds(280, 350, 70, 20);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(380, 350, 100, 20);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other1 = new JRadioButton("Other");
        other1.setBounds(490, 350, 100, 20);
        other1.setBackground(Color.white);
        add(other1);

        ButtonGroup marital = new ButtonGroup();
        marital.add(married);
        marital.add(unmarried);
        marital.add(other1);

        address = new JTextField();
        address.setBounds(280, 390, 290, 25);
        address.setFont(new Font("Arial", Font.BOLD, 17));
        add(address);

        city = new JTextField();
        city.setBounds(280, 430, 290, 25);
        city.setFont(new Font("Arial", Font.BOLD, 17));
        add(city);

        state = new JTextField();
        state.setBounds(280, 470, 290, 25);
        state.setFont(new Font("Arial", Font.BOLD, 17));
        add(state);

        Pin = new JTextField();
        Pin.setBounds(280, 510, 290, 25);
        Pin.setFont(new Font("Arial", Font.BOLD, 17));
        add(Pin);

        next = new JButton("Next");
        next.setBounds(450, 570, 120, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBackground(Color.red);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String namen = name.getText();
        String fathern = father.getText();
        String email = Email.getText();
        String addressn = address.getText();
        String cityn = city.getText();
        String staten = state.getText();
        String pin = Pin.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        } else if (other.isSelected()) {
            gender = "other";
        }

        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other1.isSelected()) {
            marital = "Other";
        }

        try {
            if (name.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                conn c1 = new conn();
                String query = "insert into signup values('" + formno + "','" + namen + "','" + fathern + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + addressn + "','" + staten + "','" + cityn + "','" + pin + "')";
                c1.s.executeUpdate(query);
                new signuptwo(formno).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String args[]) {
        new signupone().setVisible(true);
    }
}
