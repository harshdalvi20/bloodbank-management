//using Swing
package MyDbms;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


 class OtherQueries extends JFrame implements ActionListener
{
    static String uname ;
    static  String pass;
    static  String url;
    static String driver;
    
    JFrame f3;
    JTextArea t1,t2; //to increase scope beyond constructor and swing needs main method
    JLabel l1,l2,l3;
    JButton b1,b2,b3;

  
    public  OtherQueries ()
    {  
        Font myFont=new Font("Arial",Font.BOLD,20);
        t1= new JTextArea(6,20); //to write query
        t2= new JTextArea(6,20); //to display Output comments
        l1= new JLabel("type your query:");
        l2= new JLabel("Comments:");
        b1 = new JButton("Select");
        b2 = new JButton("insert/update/delete");
        b3 = new JButton("Clear");
        l3= new JLabel("      Tables are: Donor, BloodBank, Hospital");
   
        t1.setFont(myFont); 
        t2.setFont(myFont); 
        l1.setFont(myFont);
        l2.setFont(myFont);
        l3.setFont(myFont);
        b1.setFont(myFont);
        b2.setFont(myFont);
        b3.setFont(myFont);

        add(l1); ///display label "type your query"
        add(t1); //text field to type query
        add(b1); //select button
        add(b2); //insert/update/delete button
        add(l2); //label Comments
        add(t2); //to display comments
        add(b3); //to clear output button
        add(l3); //label tables are ...
        
        b1.addActionListener(this); //ActionListnener is an interface
        b2.addActionListener(this);
        b3.addActionListener(this);
          
        setLayout(new GridLayout(4,5)); //to get multiple outputs on single window
        setVisible(true);
        setSize(1000,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stops code exe while closing the frame window
         OtherQueries.initconnectionData();
    }
    
    static void initconnectionData()
   {  
       url="jdbc:mysql://localhost:3306/bloodbankmgmt"; //show variables where variable_name in ('hostname','port'); to know port no
       uname="root";
       pass="";
       driver="com.mysql.jdbc.Driver"; //while using jdbc use forName()
   }
  
    public void actionPerformed (ActionEvent e) 
    {
         Connection con;
         Statement st;
         ResultSet rs;
         String query1 = (t1.getText());
         String query2 = query1;
        String g=e.getActionCommand();
        int count;
            
        if(g.equals("Clear"))
        {
            t1.setText("");
            t2.setText("Query area cleared...");
        }
      
        else if(g.equals("Select"))
        {  
            try
           {   
                Class.forName(driver);
                System.out.println("Connecting to database...");
       
                
                t2.setText("Query executed succesfully...");
                con = DriverManager.getConnection(url,uname,pass);
                st = con.createStatement(); //Statement is an interface
                rs= st.executeQuery(query1); //ResultSet used to store multiple data (used as a storage medium)         
   
                Font myFont=new Font("Arial",Font.PLAIN,16);
                JTable jTable1=new JTable();
                jTable1.setFont(myFont);
                jTable1.setModel (DbUtils.resultSetToTableModel(rs)); 
                f3 = new JFrame();
                JScrollPane pg = new JScrollPane(jTable1);
                pg.setFont(myFont);
                f3.add(pg);
                f3.setSize(600,400);
                f3.setVisible(true);
                st.close();
                con.close();        
            }catch (Exception x){System.out.println(x); t2.setText("Query Exception occured...");} 
        }
        
        else
        {
            try{t2.setText("Query Exception occured...");
                Class.forName(driver);
                System.out.println("Connecting to database...");
                con = DriverManager.getConnection(url,uname,pass);
                st = con.createStatement(); //Statement is an interface
                count= st.executeUpdate(query1);
                System.out.println(count+" rows affected");
                t2.setText(count+" rows affected");
            }catch (Exception y){System.out.println(y); t2.setText("Query Exception occured...");}          
        }
        
    }
    
    public static void main(String args[])
    {    OtherQueries d =new  OtherQueries();
        d.setTitle("Blood Bank Management System");
        d.setVisible(true);
        d.getContentPane().setBackground(Color.CYAN);
    } 
}

/*
select * from donor;
insert into donor values ('D53','roger',36,'panjim',564213564);
delete from donor where did='D53';
*/

