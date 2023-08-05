package bank.management.system;

//import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.* ;

public class signuptwo extends JFrame implements ActionListener{
    
    JLabel religion,category,income,education,qualification,occupation,pan,aadhar,senior,existing ;
    JComboBox rel,cat,inco,edu,occu ;
    JTextField varpan,varaadhar ;
    JRadioButton syes,sno,eyes,eno ;
    String formno ;
    JButton next ;

    signuptwo(String formno) {
        this.formno = formno ;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
        setSize(790, 850);
        setVisible(true);
        setLocation(200, 0);
        getContentPane().setBackground(Color.white);
        JLabel additional = new JLabel("Page 2 : Additional Details");
        additional.setBounds(150, 35, 550, 40);
        additional.setFont(new Font("Raleway", Font.BOLD, 35));
        add(additional);

        religion = new JLabel("Religion:");
        religion.setBounds(70,120,130,30);
        religion.setFont(new Font("Raleway", Font.BOLD,22));
        add(religion);
        
        String varreligion[] = {"Hindu","Muslim","Sikh","Christian","Other"} ;
        rel = new JComboBox(varreligion);
        rel.setBounds(300,120,370,30);
        rel.setFont(new Font("Raleway", Font.BOLD,18));
        rel.setBackground(Color.white);
        add(rel);

        category = new JLabel("Category:");
        category.setBounds(70,170, 130, 30);
        category.setFont(new Font("Raleway", Font.BOLD,22));
        add(category);
        
         String varcategory[] = {"General","OBC","SC","ST","Other"} ;
        cat = new JComboBox(varcategory);
        cat.setBounds(300,170,370,30);
        cat.setFont(new Font("Raleway", Font.BOLD,18));
        cat.setBackground(Color.white);
        add(cat);

        income = new JLabel("Income:");
        income.setBounds(70,220, 130, 30);
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        add(income);
        
        String varincome[] = {"Null","less than 1,50,000","less than 2,50,000","less than 5,00,000","Up to 10,000,00"} ;
        inco = new JComboBox(varincome);
        inco.setBounds(300,220,370,30);
        inco.setFont(new Font("Raleway", Font.BOLD,18));
        inco.setBackground(Color.white);
        add(inco);

        education = new JLabel("Educational");
        education.setBounds(70,270, 130, 30);
        education.setFont(new Font("Raleway", Font.BOLD, 22));
        add(education);
        
        qualification = new JLabel("Qualification:");
        qualification.setBounds(70,300, 150, 30);
        qualification.setFont(new Font("Raleway", Font.BOLD, 22));
        add(qualification);
        
        String vareducation[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"} ;
        edu = new JComboBox(vareducation);
        edu.setBounds(300,300,370,30);
        edu.setFont(new Font("Raleway", Font.BOLD,18));
        edu.setBackground(Color.white);
        add(edu);

        occupation = new JLabel("Occupation:");
        occupation.setBounds(70,360, 150, 30);
        occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        add(occupation);
        
         String varoccupation[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"} ;
        occu = new JComboBox(varoccupation);
        occu.setBounds(300,360,370,30);
        occu.setFont(new Font("Raleway", Font.BOLD,18));
        occu.setBackground(Color.white);
        add(occu);

        pan = new JLabel("Pan Number:");
        pan.setBounds(70,420, 150, 30);
        pan.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pan);
        
        varpan = new JTextField();
        varpan.setBounds(300,420,370,30);
        varpan.setBackground(Color.white);
        varpan.setFont(new Font("Raleway",Font.BOLD,18));
        add(varpan);

        aadhar = new JLabel("Aadhar No:");
        aadhar.setBounds(70,470, 150, 30);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 22));
        add(aadhar);
        
        varaadhar = new JTextField();
        varaadhar.setBounds(300,470,370,30);
        varaadhar.setBackground(Color.white);
        varaadhar.setFont(new Font("Raleway",Font.BOLD,18));
        add(varaadhar);

        senior = new JLabel("Senior:");
        senior.setBounds(70,515, 130, 30);
        senior.setFont(new Font("Raleway", Font.BOLD, 22));
        add(senior);
        
        syes = new JRadioButton("Yes") ;
        syes.setBounds(320,515, 90, 30);
        syes.setFont(new Font("Raleway",Font.BOLD,18));
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No") ;
        sno.setBounds(440,515, 70, 30);
        sno.setFont(new Font("Raleway",Font.BOLD,18));
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup seniorgrp = new ButtonGroup();
        seniorgrp.add(syes);
        seniorgrp.add(sno);
        
        
        existing = new JLabel("Existing Account:");
        existing.setBounds(70,555, 190, 30);
        existing.setFont(new Font("Raleway", Font.BOLD, 22));
        add(existing);
        
        eyes = new JRadioButton("Yes") ;
        eyes.setBounds(320,555, 90, 30);
        eyes.setFont(new Font("Raleway",Font.BOLD,18));
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No") ;
        eno.setBounds(440,555, 70, 30);
        eno.setFont(new Font("Raleway",Font.BOLD,18));
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup existgrp = new ButtonGroup();
        existgrp.add(eyes);
        existgrp.add(eno);
        
        next = new JButton("Next");
        next.setBounds(550, 610, 120, 30);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBackground(Color.red);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next) ;
      

    }

    signuptwo(long random) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public void actionPerformed(ActionEvent ae){
       
       String srel = (String) rel.getSelectedItem();
       String scat = (String) cat.getSelectedItem();
       String sinco = (String) inco.getSelectedItem();
       String sedu = (String) edu.getSelectedItem();
       String soccu = (String) occu.getSelectedItem();
       
       String seniorcitizen = "" ;
       if(syes.isSelected()){
           seniorcitizen = "Yes" ;
       }
       else if(sno.isSelected()){
           seniorcitizen = "No" ;
       }
       
        String existingacc = "" ;
       if(eyes.isSelected()){
           existingacc = "Yes" ;
       }
       else if(eno.isSelected()){
           existingacc = "No" ;
       }
       
       String span = varpan.getText() ;
       String saadhar = varaadhar.getText();
       
       try{
           if(varaadhar.getText().equals("")){
               JOptionPane.showMessageDialog(null,"This field is required");
           }
           else{
           conn c2 = new conn();
           String query1 = "insert into signuptwo values('"+formno+"','"+srel+"','"+scat+"','"+sinco+"','"+sedu+"','"+soccu+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingacc+"')";
           c2.s.executeUpdate(query1);
           
           }
           setVisible(false);
           new signupthree(formno).setVisible(true);
       }
       catch(Exception ex){
           ex.printStackTrace();
       }
    }
    

    public static void main(String args[]) {
        new signuptwo("").setVisible(true);
    }
}
