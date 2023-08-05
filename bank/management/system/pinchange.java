
package bank.management.system;

import javax.swing.* ;
import java.util.* ;
import java.awt.* ;
import java.awt.event.* ;

public class pinchange extends JFrame implements ActionListener {
    
    JPasswordField newpin,reenter ;
    JButton change,back ;
    String pinnum ;
    pinchange(String pinnum){
        this.pinnum = pinnum ;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg")) ;
        Image i2 = i1.getImage().getScaledInstance(750, 740, Image.SCALE_DEFAULT) ;
        ImageIcon i3 = new ImageIcon(i2);
         
        JLabel Image = new JLabel(i3);
        Image.setBounds(0, 0, 750, 740);
        add(Image) ;
        setSize(750,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(200, 235, 200, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        Image.add(text);
        
        JLabel pin = new JLabel("New Pin:");
        pin.setBounds(140,275, 200, 30);
        pin.setForeground(Color.white);
        pin.setFont(new Font("Raleway",Font.BOLD,14));
        Image.add(pin);
        
        JLabel repin = new JLabel("Re-enter New Pin:");
        repin.setBounds(140,300, 200, 30);
        repin.setForeground(Color.white);
        repin.setFont(new Font("Raleway",Font.BOLD,14));
        Image.add(repin);
      
        newpin = new JPasswordField() ;
        newpin.setBounds(290,280,130,18);
        newpin.setFont(new Font("Raleway",Font.BOLD,14));
        Image.add(newpin) ;
        
        reenter = new JPasswordField() ;
        reenter.setBounds(290,305,130,18);
        reenter.setFont(new Font("Raleway",Font.BOLD,14));
        Image.add(reenter) ;
        
        change = new JButton("Change") ;
        change.setBounds(340, 400, 90,25);
        change.addActionListener(this);
        Image.add(change);
        
        back = new JButton("Back") ;
        back.setBounds(340, 428, 90,25);
        back.addActionListener(this);
        Image.add(back);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        
       try{
           if(ae.getSource()==back){
            setVisible(false);
            new transaction(pinnum).setVisible(true);
        }
        else if(ae.getSource()==change){
            String npin = newpin.getText() ;
            String nenter = reenter.getText();
            
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Enter the new pin first");

            }
        
            
            else if(npin.equals(nenter)){
                conn c7 = new conn();
                c7.s.executeUpdate("update bank SET pin = '"+npin+"' where pin = '"+pinnum+"'");
                c7.s.executeUpdate("update Login SET pin = '"+npin+"' where pin = '"+pinnum+"'");
                c7.s.executeUpdate("update signupthree SET pin = '"+npin+"' where pin = '"+pinnum+"'");
                JOptionPane.showMessageDialog(null,"Pin changed successfully");
                setVisible(false);
                new transaction(pinnum).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Re-Entered Pin is Wrong");
            }
        }
       }
       catch(Exception e){
           System.out.println(e);
       }
    }
    public static void main(String aegs[]){
        new pinchange("");
    }
}
