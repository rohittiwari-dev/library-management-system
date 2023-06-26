/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class connectiondb 
{
    public static Connection db()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection con =DriverManager.getConnection("jdbc:sqlite:Database\\Database.db");
            return con;
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"No Database is found try reinstalling the Software");
            return null;
        }
    }
}