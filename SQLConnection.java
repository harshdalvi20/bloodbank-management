
package MyDbms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLConnection
{   
    String driver = "com.mysql.jdbc.Driver";
    String uname = "root";
    String url = "jdbc:mysql://localhost:3306/bloodbankmgmt";
    String pass = "";
    Connection con;
    

    public SQLConnection() 
    {
       try 
            {
                Class.forName(driver);
                con = DriverManager.getConnection(url,uname,pass);
               
                System.out.println("Connection with database succesful!!");
            } catch (Exception e) 
            {
                System.out.println("Connection with databse failed as: " + e);
                }
    }
    
   public  Connection getConn() 
    {
        return con;
    }
    
}
