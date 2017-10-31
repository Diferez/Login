/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Conectar {
    public static Connection Cone(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhoost:1521:orcl","system","12345"); 
            return con;
        }catch(Exception E)
        {
            JOptionPane.showMessageDialog(null, E);
        }
        return null;
    }
}
