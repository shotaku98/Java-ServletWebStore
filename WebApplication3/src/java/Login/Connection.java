/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shourya
 */
public class Connection {
     public ResultSet getrs() throws ClassNotFoundException, SQLException{
         try{
             System.out.println("Login.Connection.getrs()");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            java.sql.Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/shouryadb","shourya","shourya");
            String sql="Select * from Shourya.Products";
            PreparedStatement stmt=conn.prepareStatement(sql);

            ResultSet rs=stmt.executeQuery();
             System.out.println("Login.Connection.getrs() 2");
            return rs;
                                    
                    
                    
        }
catch(   Exception e)
{System.out.println(e);
return null;}
         
     }
     
          public ResultSet getrscart(String username) throws ClassNotFoundException, SQLException{
         try{
             System.out.println("Login.Connection.getrs()");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            java.sql.Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/shouryadb","shourya","shourya");
             String sql="SELECT * FROM Products INNER JOIN CART ON CART.IC = Products.IC Where CART.NAME='"+ username +"'  ";
                     
            PreparedStatement stmt=conn.prepareStatement(sql);

            ResultSet rs=stmt.executeQuery();
             System.out.println("Login.Connection.getrs() 2");
            return rs;
                                    
                    
                    
        }
catch(   Exception e)
{System.out.println(e);
return null;}
         
     }
     
     

public  boolean feed(String n,String e,String p) throws SQLException{
   try{ Class.forName("org.apache.derby.jdbc.ClientDriver");
            java.sql.Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/shouryadb","shourya","shourya");
            String sql="Insert into Shourya.Users values (?,?,?)";
            System.out.println("in feed");
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, n);
            stmt.setString(2, e);
            stmt.setString(3, p);
             if(stmt.executeUpdate()==1)
                    {
                    System.out.println("value added");
                    return true;
                    }
            else{
                 System.out.println("value failed to add");
            return false;
            }
   }     catch (Exception ex) {
             Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println(ex);
             return false;
             
         }
}
   public boolean Login (String u, String p){
       try{Class.forName("org.apache.derby.jdbc.ClientDriver");
            java.sql.Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/shouryadb","shourya","shourya");
            String sql="Select * from Shourya.USERS where name=? and password=?";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,u);
            stmt.setString(2,p);

            ResultSet rs=stmt.executeQuery();
            if (rs.next()){
            return true;}
            else{
   return false;
            }
       }
       catch(Exception E){
       System.out.println(E);
       return false;}
   }
   
  public void clear(String username){
  
   
    try{
             System.out.println("Login.Connection.getrs()");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            java.sql.Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/shouryadb","shourya","shourya");
             String sql="DELETE FROM  CART WHERE NAME= '"+ username+"' ";
                     
            Statement stmt=conn.createStatement();

            stmt.executeUpdate(sql);
             System.out.println("Login.Connection.getrs() 2");
            
                                    
                    
                    
        }
catch(   Exception e)
{System.out.println(e);
}
  }



}

    

