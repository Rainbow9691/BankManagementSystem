
package bank.management.system;

import java.sql.* ;

public class conn {
    Connection c ;
    Statement s ;
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c =  (Connection) DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","rainbow@9691");
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
