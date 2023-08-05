
package bank.management.system;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.*;
import java.sql.* ;

public class Login extends JFrame implements ActionListener {
    JButton login,vanish,addacc ;
    TextField cardtext ;
   
    JPasswordField pintext ;
   
    Login(){
        
        setTitle("Automated teller machine");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bankimage.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3) ;
        add(lable);
        setSize(800,520) ;
        setVisible(true) ;
        setLocation(200 , 100) ;
        lable.setBounds(40,20,100,100);
        getContentPane().setBackground(Color.white);
        JLabel text = new JLabel("Welcome To ATM");
        text.setBounds(200,50,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);
       
        JLabel cardno = new JLabel("Card no.");
        cardno.setBounds(120,170,150,40);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        add(cardno);
        cardtext = new TextField();
        cardtext.setBounds(290,175,280,35);
        add(cardtext);
        cardtext.setFont(new Font("Raleway",Font.BOLD,20));
        JLabel pin = new JLabel("Pin no.");
        pin.setBounds(120,235,150,40);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
       add(pin);
      
        pintext = new JPasswordField();
        pintext.setBounds(290,240,280,35);
        add(pintext);
        pintext.setFont(new Font("Raleway",Font.BOLD,25));
        
        login = new JButton("Sign in");
        login.setBounds(290,310,125, 30);
        login.addActionListener(this);
        add(login);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        vanish = new JButton("Clear All");
        vanish.setBounds(445,310,125, 30);
        vanish.addActionListener(this);
        add(vanish);
        vanish.setBackground(Color.BLACK);
        vanish.setForeground(Color.white);
        addacc = new JButton("Sign up");
        addacc.setBounds(290,365,280, 30);
        addacc.addActionListener(this);
        add(addacc);
        addacc.setBackground(Color.BLACK);
        addacc.setForeground(Color.white);
    }
    public void actionPerformed(ActionEvent ae){
         
       try{  
       if(ae.getSource()==login){
            String cardt = cardtext.getText() ;
         String pint = pintext.getText() ;
           conn c4 = new conn();
           
           String query4 = "select * from login where Card_Number = '"+cardt+"' and Pin = '"+pint+"'" ;
        
           ResultSet rs =  c4.s.executeQuery(query4);
            if(rs.next()){
                setVisible(false);
              new  transaction(pint).setVisible(true);
            }
            
            else if(cardt.equals("")){
               JOptionPane.showMessageDialog(null,"Enter Card Number!!!");
               return ;
           }
           else if(pint.equals("")){
               JOptionPane.showMessageDialog(null,"Enter pin Number!!!");
               return ;
           }else {
                JOptionPane.showMessageDialog(null,"Incorrect cardnumber or pin");
            }
        }
       }catch(Exception e){
            System.out.println(e);
        }
           
           
       
        if (ae.getSource()==vanish){
           cardtext.setText("");
           pintext.setText("");
       }
       else if(ae.getSource()==addacc){
           setVisible(false);
           new signupone().setVisible(true);
       }
       
    
    
    }
    public static void main(String args[]){
        new Login();
    }
}
