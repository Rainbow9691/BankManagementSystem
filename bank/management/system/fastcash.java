package bank.management.system;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.util.Date ;
import java.sql.* ;
 
public class fastcash extends JFrame implements ActionListener{
    JButton deposit,withdraw,fastcash,pinchange,ministat,enquiry,exit ;
    String pinnum ;
     fastcash(String pinnum){
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
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(130,343,140,25);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        Image.add(deposit);
        
        withdraw = new JButton("Rs 500");
        withdraw.setBounds(290,343,140,25);
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        Image.add(withdraw);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(130,370,140,25);
        fastcash.setForeground(Color.black);
        fastcash.addActionListener(this);
        Image.add(fastcash);
        
        pinchange = new JButton("Rs 2000");
        pinchange.setBounds(130,397,140,25);
        pinchange.setForeground(Color.black);
        pinchange.addActionListener(this);
        Image.add(pinchange);
        
        ministat = new JButton("Rs 5000");
        ministat.setBounds(290,370,140,25);
        ministat.setForeground(Color.black);
        ministat.addActionListener(this);
        Image.add(ministat);
        
        enquiry = new JButton("Rs 10000");
        enquiry.setBounds(290,397,140,25);
        enquiry.setForeground(Color.black);
        enquiry.addActionListener(this);
        Image.add(enquiry);
        
        exit = new JButton("Back");
        exit.setBounds(290,424,140,25);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        Image.add(exit);
    }
    public void actionPerformed(ActionEvent ae){
              if(ae.getSource()==exit){
                  setVisible(false) ;
                  new transaction(pinnum).setVisible(true);
              }  else{
                  String amount = ((JButton)ae.getSource()).getText().substring(3) ;
   
           Date date = new Date() ;
           conn c6 = new conn();
           try{
             ResultSet rs =  c6.s.executeQuery("select * from bank where pin = '"+pinnum+"'");
             int balance = 0 ;
            while(rs.next()){
               if(rs.getString("Account_type").equals("deposit")){
                   balance += Integer.parseInt(rs.getString("Amount") ) ;
                  
               }
               else {
                   balance -= Integer.parseInt(rs.getString("Amount"));
               }
            }
                 
               if(ae.getSource() != exit && balance<Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficiant Balance");
                   return ;
               }
               else{
                   c6.s.executeUpdate("insert into bank values('"+pinnum+"','"+date+"','Withdrawl','"+amount+"')");
                   JOptionPane.showMessageDialog(null,"Rs "+amount+" debited successfully");
                   setVisible(false);
                   new transaction(pinnum).setVisible(true);
               }
            
       }
       catch(Exception e){
           System.out.println(e);
       }
              }
    }
    public static void main(String args[]){
        new fastcash("") ;
    }
}
