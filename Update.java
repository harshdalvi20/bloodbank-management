package MyDbms;
import MyDbms.SQLConnection;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   
import java.awt.event.*;  
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Update  extends JFrame  implements ActionListener 
{
    
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JFrame f1,f2,f3;
    JTextArea t1,t2,t3,t4,t5,t6;
    JButton b1,b2,b3,b4;
    Statement st=null;
    Connection c=null;
    ResultSet rs;
   
    public Update()
    {
        
        Font myFont=new Font("Arial",Font.BOLD,20);
        l1= new JLabel("Update Donor: ");
    //    l2= new JLabel("did");
        l3= new JLabel("name");
        l4= new JLabel("age");
        l5= new JLabel("address");
        l6= new JLabel("phno");
        l7= new JLabel("where did=");
        t1= new JTextArea(6,15);
        t2= new JTextArea(6,15);
        t3= new JTextArea(6,15);
        t4= new JTextArea(6,15);
        t5= new JTextArea(6,15);
        t6= new JTextArea(6,15);
        
        b1 = new JButton("GO1");
        b2 = new JButton("GO2");
        
        l1.setFont(myFont);
        l3.setFont(myFont);
        l4.setFont(myFont);
        l5.setFont(myFont);
        l6.setFont(myFont);
        l7.setFont(myFont);
        t1.setFont(myFont);
        t2.setFont(myFont);
        t3.setFont(myFont);
        t4.setFont(myFont);
        t5.setFont(myFont);
        t6.setFont(myFont);
        b1.setFont(myFont);
        b2.setFont(myFont);
       
        add(l1);  
        add(l3); 
        add(t2);
        add(l4);
        add(t3);
        add(l5);
        add(t4);
        add(l6);
        add(t5);
        add(l7);
        add(t6);
        add(b1);
        
       
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(new FlowLayout());   
    
    }
    
     public void actionPerformed (ActionEvent e) 
    {
        String g=e.getActionCommand();
        String did=null,name=null,age=null,address=null,phno=null;
        String bloodgroup=null,quantity=null,cost=null,hid=null;
        String query=null,WhereAttribute;
        int count;
       
        
        try{ 
            SQLConnection Sm = new SQLConnection();    
            c = Sm.getConn();     
            st= c.createStatement(); 
           }catch(Exception y){System.out.println(y);};
                   
        if(g.equals("GO1"))
        {
            
            name=(t2.getText());
            age=(t3.getText());
            address=(t4.getText());
            phno=(t5.getText());   
            WhereAttribute=(t6.getText()); 
            
            query="update donor set name='"+name+"',age='"+age+"',address='"+address+"',phno='"+phno+"' where did= '"+WhereAttribute+"' " ;
            System.out.println(query);
            try
          {      
           count= st.executeUpdate(query); //ResultSet used to store multiple data (used as a storage medium)         
           Font myFont=new Font("Arial",Font.PLAIN,16);
           System.out.println(+count+" rows affected ");
           st.close();
           c.close();        
           } catch(Exception x){ System.out.println(x); }  
       }             
     }
 }
