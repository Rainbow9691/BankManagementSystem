
package bank.management.system;

import javax.swing.* ;
import java.awt.* ;
import java.sql.* ;
import java.awt.event.*;

public class balanceenquiry extends JFrame implements ActionListener{
    
    JButton back ;
    String pinnum ;
    balanceenquiry(String pinnum){
        this.pinnum = pinnum ;
        setLayout(null);
        setSize(750,900);
        setLocation(300,0);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 740, Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        
        JLabel Image = new JLabel(i3);
        Image.setBounds(0, 0, 750, 740);
        add(Image);
        int  balance = 0 ;
        
        
        back = new JButton("Back");
        back.setBounds(340, 428, 90,25);
        back.addActionListener(this);
        Image.add(back);
        
        try{   
        conn c7 = new conn() ;
            ResultSet rs = c7.s.executeQuery("select * from bank where pin = '"+pinnum+"'");
          
          while(rs.next()){
              if(rs.getString("Account_type").equals("deposit")){
                  balance += Integer.parseInt(rs.getString("Amount"));
              }
              else{
                  balance -= Integer.parseInt(rs.getString("Amount"));
              }
              
          }
        }
        catch(Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("Your Current Account Balance Is Rs "+balance);
        text.setBounds(130,230, 400, 30);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        text.setForeground(Color.white);
        Image.add(text);
    }
        public void actionPerformed(ActionEvent ae){
            
                setVisible(false) ;
                new transaction(pinnum).setVisible(true);
           
        }

        
    
    public static void main(String args[]){
        new balanceenquiry("");
    }
    
}