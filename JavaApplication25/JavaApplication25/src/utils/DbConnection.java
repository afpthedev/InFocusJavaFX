package utils;


 import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

 /**
  *
  * @author Cyber Micro
  */
 public class DbConnection {
   Connection connect = null;
   public static Connection conDB() {
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/infocus","root","");
           return conn;
       }catch(Exception ex){
           System.err.println("ConnectionUtil : "+ex.getMessage());
           return null;
       }
     
   }
 }