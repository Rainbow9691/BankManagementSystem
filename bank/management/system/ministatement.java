
package bank.management.system;


import javax.swing.* ;
import java.awt.* ;
import java.sql.* ;
import java.awt.event.* ;

public class ministatement extends JFrame implements ActionListener{
    
    JButton back ;
    String pinnum ;
    ministatement(String pinnum){
        this.pinnum = pinnum ;
        setLayout(null);
        setSize(400,650);
        setLocation(400,20);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("State  Bank  Of  India"); 
        text.setBounds(110,30, 200, 30);
        text.setForeground(Color.black);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        add(text);
        
        JLabel card = new JLabel("") ;
        card.setBounds(30,100,300, 30);
        card.setForeground(Color.black);
        card.setFont(new Font("Raleway",Font.BOLD,15));
        add(card);
        
        JLabel pin = new JLabel("Pin Number:       XXXX") ;
        pin.setBounds(30,135,200, 30);
        pin.setForeground(Color.black);
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        add(pin);
        
        JLabel mini = new JLabel() ;
        
        
        
        try{
            conn c8 = new conn();
            ResultSet rs = c8.s.executeQuery("select * from login where pin = '"+pinnum+"'");
            
            while(rs.next()){
                card.setText("Card Number:     "+rs.getString("Card_Number").substring(0,4)+"XXXXXXXX"+ rs.getString("Card_Number").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            int balance = 0 ;
            conn c9 = new conn() ;
            ResultSet rs = c9.s.executeQuery("select * from bank where pin = '"+pinnum+"'") ;
            
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Account_Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><br>" + "<html>");
                if(rs.getString("Account_Type").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("Amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("Amount"));
                
                }
                
            }
            JLabel balancen = new JLabel("Your Current Account Balance: "+balance) ;
            balancen.setBounds(30, 520, 300, 30);
            balancen.setFont(new Font("Raleway",Font.BOLD,15));
            add(balancen);
        }
        catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,190, 500,300);
//        mini.setForeground(Color.black);
        mini.setFont(new Font("Raleway",Font.BOLD,13));
         add(mini);
         
         back = new JButton("Back") ;
         back.setBounds(140, 570, 90, 30);
         back.setBackground(Color.black);
         back.setForeground(Color.white);
         back.setFont(new Font("Raleway",Font.BOLD,15));
         back.addActionListener(this);
         add(back);
         
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== back){
            setVisible(false);
            new transaction(pinnum).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new ministatement("") ;
    }
    
}
