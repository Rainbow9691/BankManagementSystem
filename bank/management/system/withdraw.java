

package bank.management.system;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.util.Date ;
import java.sql.* ;



public class withdraw extends JFrame implements ActionListener{
    JTextField withdrwamount ;
    JButton withdrwbutton,back ;
    String pinnum ;
    
    withdraw(String pinnum){
        
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
//        setUndecorated(true);
        setVisible(true);
        
        JLabel depo = new JLabel("Enter the amount you want to withdrawl") ;
        depo.setBounds(132, 245,500, 30);
        depo.setForeground(Color.white);
        depo.setFont(new Font("Raleway",Font.BOLD,15));
        Image.add(depo);
        
        withdrwamount = new JTextField() ;
        withdrwamount.setBounds(140, 290,280,25);
//        depoamount.setForeground(Color.white);
        withdrwamount.setBackground(Color.white);
        withdrwamount.setFont(new Font("Raleway",Font.BOLD,15));
        Image.add(withdrwamount);
        
        withdrwbutton = new JButton("withdrawl") ;
        withdrwbutton.setBounds(325,400,100,23);
        withdrwbutton.addActionListener(this);
        Image.add(withdrwbutton);
        
        back = new JButton("Back") ;
        back.setBounds(325,430,100,23);
        back.addActionListener(this);
        Image.add(back);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String withdr = withdrwamount.getText() ;
        
        if(withdr.equals("")){
            JOptionPane.showMessageDialog(null,"Write the Withdrawl Amount First !!!");
           
        }else{

         if(ae.getSource()==back){
                  setVisible(false) ;
                  new transaction(pinnum).setVisible(true);
              }  else{
                
   
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
               if(ae.getSource() != back && balance<Integer.parseInt(withdr)){
                   JOptionPane.showMessageDialog(null,"Insufficiant Balance");
                   return ;
               }
               else{
                   c6.s.executeUpdate("insert into bank values('"+pinnum+"','"+date+"','Withdrawl','"+withdr+"')");
                   JOptionPane.showMessageDialog(null,"Rs "+withdr+" debited successfully");
                   setVisible(false);
                   new transaction(pinnum).setVisible(true);
               }
            
       }
       catch(Exception e){
           System.out.println(e);
       }
              }
       
    }
    }
    
    public static void main(String args[]){
        new withdraw("") ;
    }
}
