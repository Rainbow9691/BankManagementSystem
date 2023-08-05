
package bank.management.system;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class transaction extends JFrame implements ActionListener{
    JButton deposit,withdraw,fastcash,pinchange,ministat,enquiry,exit ;
    String pinnum ;
    public transaction(String pinnum){
        this.pinnum = pinnum ;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg")) ;
        Image i2 =  i1.getImage().getScaledInstance(750,740,Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2) ;
        JLabel Image = new JLabel(i3) ;
        Image.setBounds(0,0,750,740);
        add(Image);
        setSize(750,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(160,245,300, 25);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        Image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(130,343,140,25);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        Image.add(deposit);
        
        withdraw = new JButton("Cash Withdrawl");
        withdraw.setBounds(290,343,140,25);
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        Image.add(withdraw);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(130,370,140,25);
        fastcash.setForeground(Color.black);
        fastcash.addActionListener(this);
        Image.add(fastcash);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(130,397,140,25);
        pinchange.setForeground(Color.black);
        pinchange.addActionListener(this);
        Image.add(pinchange);
        
        ministat = new JButton("Mini Statement");
        ministat.setBounds(290,370,140,25);
        ministat.setForeground(Color.black);
        ministat.addActionListener(this);
        Image.add(ministat);
        
        enquiry = new JButton("Balance Enquiry");
        enquiry.setBounds(290,397,140,25);
        enquiry.setForeground(Color.black);
        enquiry.addActionListener(this);
        Image.add(enquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(290,424,140,25);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        Image.add(exit);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== deposit){
           setVisible(false);
           new deposit(pinnum).setVisible(true) ;
       }
        else if(ae.getSource()==withdraw){
           setVisible(false);
           new withdraw(pinnum).setVisible(true);
       }
        else if(ae.getSource()==fastcash){
           setVisible(true);
           new fastcash(pinnum).setVisible(true);
       }
        else  if(ae.getSource()==pinchange){
           setVisible(false) ;
           new pinchange(pinnum).setVisible(true);
       }
        else  if(ae.getSource()==ministat){
           setVisible(false) ;
           new ministatement(pinnum).setVisible(true);
       }
        else  if(ae.getSource()==enquiry){
           setVisible(false);
           new balanceenquiry(pinnum).setVisible(true);
       }
        else if(ae.getSource()==exit){
           System.exit(0);
       } 
    }
    public static void main(String args[]){
        new transaction("") ;
    }
}
