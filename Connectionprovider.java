package project;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionProvider {
    public static Connection getCon()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement_db","root","");
            //JOptionPane.showMessageDialog(null,"Connected");
            return con;
        }
        catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,"Not Connected");
            return null;
            
        }
    }
}
