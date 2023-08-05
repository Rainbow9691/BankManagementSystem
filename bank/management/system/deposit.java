
package bank.management.system;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.util.* ;



public class deposit extends JFrame implements ActionListener{
    JTextField depoamount ;
    JButton depobutton,back ;
    String pinnum ;
    
    deposit(String pinnum){
        
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
        
        JLabel depo = new JLabel("Enter the amount you want to deposit") ;
        depo.setBounds(140, 245,500, 30);
        depo.setForeground(Color.white);
        depo.setFont(new Font("Raleway",Font.BOLD,15));
        Image.add(depo);
        
        depoamount = new JTextField() ;
        depoamount.setBounds(140, 290,280,25);
//        depoamount.setForeground(Color.white);
        depoamount.setBackground(Color.white);
        depoamount.setFont(new Font("Raleway",Font.BOLD,15));
        Image.add(depoamount);
        
        depobutton = new JButton("Deposit") ;
        depobutton.setBounds(335,400,90,23);
        depobutton.addActionListener(this);
        Image.add(depobutton);
        
        back = new JButton("Back") ;
        back.setBounds(335,430,90,23);
        back.addActionListener(this);
        Image.add(back);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        try{
            String depoo = depoamount.getText() ;
            Date date = new Date() ;
            if(ae.getSource()==depobutton){
            
                if(depoo.equals("")){
                    JOptionPane.showMessageDialog(null,"Enter amount to be deposit");
                }
                else{
                    conn c5 = new conn();
                    
                    c5.s.executeUpdate("insert into bank values('"+pinnum+"','"+date+"','deposit','"+depoo+"')") ;
                    JOptionPane.showMessageDialog(null,"Rs "+depoo+" Deposited Successfully");
                    setVisible(false);
                    new transaction(pinnum).setVisible(true);
                }
        }
            else if(ae.getSource()==back){
                setVisible(false) ;
                new transaction(pinnum).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new deposit("") ;
    }
}
