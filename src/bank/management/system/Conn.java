
package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    
    Statement s;
    
    public Conn()
    {
        try{
            
//            Registering Driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
            
//            Making Connection
            c=DriverManager.getConnection("jdbc:mysql:///bankManagementSystem", "root", "Bazil@0786");
            
//            Creating Statement
            s=c.createStatement();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
